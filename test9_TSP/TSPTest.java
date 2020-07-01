package project.test9_TSP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class TSPTest {
	static String[] City = { "논산", "강경", "계룡", "공주", "부여", "대전", "천안", "전주", "대천", "부안" };

	public static void main(String[] args) {
		int[][] dist = {   
				  {0, 9, 22, 34, 21, 43, 75, 51, 67, 80},
			      {9, 0, 30, 0, 0, 52, 0, 0, 0, 0},
			      {22, 30, 0, 0, 0, 22, 74, 0, 0, 0},
			      {34, 0, 0, 0, 33, 0, 42, 0, 70, 0},
			      {21, 0, 0, 33, 0, 0, 0, 0, 49, 79},
			      {43, 52, 22, 0, 0, 0, 0, 0, 0, 0},
			      {75, 0, 74, 42, 0, 0, 0, 0, 0, 0},
			      {51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
			      {67, 0, 0, 70, 49, 0, 0, 0, 0, 0},
			      {80, 0, 0, 0, 79, 0, 0, 41, 0, 0}, };
		int N = dist.length;
		AdjListEdge adj = new AdjListEdge();
		List<Edge>[] adjList = new LinkedList[N];
		adjList = adj.convertMtoL(dist, N);

		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		int[][] hang = new int[N][N]; // MST를 사용한 결과를 행렬로 치환
		for (int i = 0; i < N - 1; i++) {
			if (kmst.tree[i].weight != 0) {
				hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
				hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight;
			}
		}

		List<Edge>[] hangList = new LinkedList[N]; // MST행렬을 리스트로 바꿈
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);

		DFS dfs = new DFS(hangList);	
		
		int[] dfsVer = new int[11];		//dfs경로순서를 저장하는 배열	
		dfsVer[0] = 0;
		dfsVer[10] = 0;
		for(int i =1; i< N+1; i++) {		//중복을 없앰
			dfsVer[i] = dfs.adj.pop();
			//System.out.print(" "+ dfsVer[i]);
		}

		System.out.println("MST + DFS + 중복회피 방식의 TSP입니다.");
		System.out.print("TSP :");
		int SumDist = 0;
		for(int i= 0; i<N; i++) {											//원래 그래프에서 TSP를 찾음
			for(int j=0; j<adjList[dfsVer[i]].size(); j++) {
				if(adjList[dfsVer[i]].get(j).tv == dfsVer[i+1]) {
					System.out.print("=>"+City[dfsVer[i]]);
					SumDist += adjList[dfsVer[i]].get(j).weight;
				}else if(dfsVer[i+1] == 0){
					System.out.print("=>"+City[0]);
				}
			}
		}
		System.out.print("\n TSP의 총거리의 합은 "+ SumDist+"km 입니다.");
	
		
		
		
		
		
		//오일러 사이클 + 중복회피 방식의 TSP입니다.
		
		DijkstraSP di = new DijkstraSP(adjList);
		ArrayList<Integer> qs = new ArrayList<>();
		
		for(int i = 0 ; i<N; i++) {		//연결차수가 홀수인 차수 찾기
			//System.out.print(i +"  ");
			int j;
			for(j= 0; j< hangList[i].size(); j++) {
				//System.out.print(" "+hangList[i].get(j).tv);
			}
			if(j % 2 != 0 ) {
				qs.add(i);				//찾은 홀수 찾수를 ArrayList에 추가
			}
			//System.out.println();
		}
		
		for(int i =0; i<N; i++) {		//MST의 행렬 확인
			for(int j=0; j<N; j++) {
				//System.out.print(" "+hang[i][j]);
			}
			//System.out.println();
		}
		
		
		for(int i=0; i<qs.size(); i++) {				//홀수인 차수들의 정점들을 서로 연결하는 루프문 
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			int[] distance = di.shortestPath(qs.get(i));
			for(int j = 0; j<qs.size();j++) {
				if(distance[qs.get(j)] != 0 && distance[qs.get(j)] < min) {	//홀수 정점들 사이에 최단경로를 찾는 if문
					min = distance[qs.get(j)];
					minIdx = qs.get(j);
				}
			}
			//	System.out.println(qs.get(i) + " " +minIdx);
			if(dist[qs.get(i)][minIdx] != 0) {					//홀수 정점들간의 경로를 따지기 위해 원래 행렬에 그 값이 있다면 엣지를 만들고 그 엣지를 MST그래프에 추가
				Edge e = new Edge(qs.get(i),minIdx, dist[qs.get(i)][minIdx]);
				hangList[qs.get(i)].add(e);
				hangList[minIdx].add(e);	
		}
		}
		
		
		for(int i = 0; i < N; i++) { 				// 윗단계에서 생긴 중복 정점을 지우는 루프문
			for(int j=0; j< hangList[i].size()-1; j++) {
				if(hangList[i].get(j).tv == hangList[i].get(j+1).tv) {
					hangList[i].remove(j+1);
				}
			}
		}
		
		for(int i = 0 ; i<N; i++) {		//인접리스트 확인
			//System.out.print(i +"  ");
			int j;
			for(j= 0; j< hangList[i].size(); j++) {
				//System.out.print(" "+hangList[i].get(j).tv);
			}
			if(j % 2 != 0 ) {
				//qs.add(i);
			}
			//System.out.println();
		}
		
		DFS odfs = new DFS(hangList);
		dfsVer[0] = 0;
		dfsVer[10] = 0;
		for(int i =1; i< N+1; i++) {		//찾은 MST그래프에서 중복을 없앰
			dfsVer[i] = odfs.adj.pop();
			//System.out.print(" "+ dfsVer[i]);
		}

		System.out.println("\n\nMST + 오일러싸이클 + 중복회피 방식의 TSP입니다.");
		System.out.print("TSP :");
		SumDist = 0;
		for(int i= 0; i<N; i++) {											//원래 그래프에서 TSP를 찾음
			for(int j=0; j<adjList[dfsVer[i]].size(); j++) {
				if(adjList[dfsVer[i]].get(j).tv == dfsVer[i+1]) {
					System.out.print("=>"+City[dfsVer[i]]);
					SumDist += adjList[dfsVer[i]].get(j).weight;
				}else if(dfsVer[i+1] == 0){
					System.out.print("=>"+City[0]);
				}
			}
		}
		System.out.print("\n TSP의 총거리의 합은 "+ SumDist+"km 입니다.");
		
	}
}
