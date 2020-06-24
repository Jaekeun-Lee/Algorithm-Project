package project.test3_MST;

import java.util.LinkedList;
import java.util.List;


public class NonsanTest2 {
	static String[] City = {"논산","강경","계룡","공주","부여","대전","천안","전주","대천","부안"};
	
	
	
	public static void main(String[] args) {
		
		
		int[][] dist = {
				{0, 9, 22, 34, 21, 67, 87, 51, 0, 80},
				{9, 0, 35, 0, 0, 74, 0, 0, 0, 0},
				{22, 35, 0, 0, 0, 22, 0, 0, 0, 0},
				{34, 0, 0, 0, 33, 0, 42, 0, 0, 0},
				{21, 0, 0, 33, 0, 0, 0, 0, 49, 0},
				{67, 74, 22, 0, 0, 0, 0, 0, 0, 0},
				{87, 0, 0, 42, 0, 0, 0, 0, 0, 0},
				{51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
				{0, 0, 0, 0, 49, 0, 0, 0, 0, 0},
				{80, 0, 0, 0, 0, 0, 0, 41, 0, 0},
		};
		int N = dist.length;	
		/*
		 * System.out.printf("입력 그래프의 인접행렬입니다.\n    "); for(int i=0; i<N; i++)
		 * System.out.printf("%4d", i); System.out.println(); for(int i=0; i<N; i++) {
		 * System.out.printf("%2d: ", i); for(int j=0; j<N; j++)
		 * System.out.printf("%4d", dist[i][j]); System.out.println(); }
		 * 
		 */
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		
		
		
		System.out.println("\n1. 논산 주변의 10개 도시의 연결 도로망 그래프에 대하여 MST를 구하여 출력하시오.");		//2가지 MST출력 
		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		System.out.print("Kruskal2 MST = ");
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		System.out.print("\nPrim MST = ");
		
		int[][] hung = new int[N][N];				//prim MST 출력
		int[] pmin = new int[N];
		PrimMST pmst = new PrimMST(adjList);
		pmin = pmst.mst(0);
		pmst.printPrim(pmst, N-1);					//prim MST print메서드
		
		
		/////////2번 시작/////////
		System.out.println("\n\n2. Kruskal2 MST을 사용하여 논산을 출발 도시로 하는 도시 관광 그래프의 MST를 구하고 TSP를 구현하시오.");	//Kruskal2 사용 MST
	
		
		System.out.println(">kruskal2 MST<");	          														
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		
		
		
		int[][] hang = new int[N][N];									//MST를 사용한 결과를 행렬로 치환
		  for(int i = 0; i < N-1; i++) { if(kmst.tree[i].weight != 0) {
		  hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
		  hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight; } }
		 
		
		List<Edge>[] hangList = new LinkedList[N];					//MST행렬을 리스트로 바꿈
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);
		
		System.out.print("\nTSP 정점 순서도: ");
		DFS hdfs = new DFS(hangList);								//리스트를 사용해 DFS를 통해 중복값 삭제
		hdfs.adj.add(0);   // 0 = 출발도시
		int[] d = new int[N+1];
		System.out.print(" => 0\n");
		
		System.out.print("순서:");
		for(int i= 0; i < N+1; i++) {
			d[i] = hdfs.adj.remove();		//dfs결과를 d배열에 넣어줌		
			System.out.print("=>"+City[d[i]]);	// d배열의 인덱스로 도시들의 이름을 가져와서 출력
		}
		d[N] = 0;							//도착도시을 안넣어줘도 0(논산)이지만 명시적으로 값을 넣어줌.
		
		DijkstraSP di = new DijkstraSP(adjList);				//디작스트라에 넣는 리스트를 MST의 리스트가 아닌 처음 adjList로 입력
		int sum = 0;							//이동거리
		for(int i = 0; i < d.length -1; i++) {					//MST의 순환 경로를 따라가되 adjList의 최소거리까지 참고하여 adjList의 경로가 더 짧으면 adjList의 최소거리로 값을 출력
			int [] distance = di.shortestPath(d[i]);			//d배열에 저장되있는 도시순환 인덱스를 i와 i+1의 값을 순차적으로 출력
			sum += distance[d[i+1]];							//순환 하면서 이동거리의 총합.
		}
		
		//adjList(원래 코드)를 MST를 구한다.
		//MST를 이용해 dfs를 구한다.
		//중복을 없앤 dfs에  adjList로 구한 디작스트라를 활용해 MST의 결과와 adjList의 경로를 비교해 둘중 최단거리를 구했다. 
		
		
		
		
		
		System.out.println("\nKruskal2 MST을 이용한 TSP의 총 여행거리는 "+sum+"입니다."); 
		///////////2번끝//////////
		
		
		
		
		
		
		///////////3번시작//////////
	/*	System.out.println("\n\n3. PrimMST을 사용하여 논산을 출발 도시로 하는 도시 관광 그래프의  MST를 구하고 TSP를 구현하시오.");
		int[][] hung = new int[N][N];
		int[] pmin = new int[N];
		PrimMST pmst = new PrimMST(adjList);
		pmin = pmst.mst(0);
		
		//pmst.printPrim(pmst, N-1);					//최소신장트리 가중치
		for(int i = 0; i<N; i++) {									//PrimMST를 행렬로 변환
			for(int j = 0; j < adjList[i].size(); j++) {
				if (pmin[i] == adjList[i].get(j).tv) {
					hung[i][j] = adjList[i].get(j).weight;
					hung[j][i] = adjList[i].get(j).weight;
				}
			}
		}
		
		List<Edge>[] hungList = new LinkedList[N];
		hungList = test.convertMtoL(hung, N);
		// test.printAdjList(hungList);
		int[] q = new int[N+1];
		System.out.print("TSP 정점 순서도: ");
		DFS pdfs = new DFS(hungList);
		pdfs.adj.add(0);			//시작 정점
		System.out.print("0\n");
		
		System.out.print("순서:");
		for(int i= 0; i < N+1; i++) {
			q[i] = pdfs.adj.remove();		//dfs결과를 d배열에 넣어줌
			System.out.print("=>"+City[q[i]]);
		}
		
		sum = 0;				//sum 초기화
		for(int i = 0; i < N; i++) {
			sum += dist[d[i]][d[i+1]];
		}
		System.out.println("\nprim MST을 이용한 TSP의 총 여행거리는 "+sum+"입니다.");
		
		
		for(int i = 0; i < N; i++){						//previous에서 받은 tv를 adjList의 tv와 비교해 맞으면 fv값과 weight값을 가져옴.
			for(int j = 0; j < adjList[i].size(); j++) {
				if(pmin[i] == adjList[i].get(j).tv) {
					System.out.print("("+adjList[i].get(j).fv + ","+ pmin[i] + ","+adjList[i].get(j).weight +")");
					sum += adjList[i].get(j).weight;
				}
			}
		}*/
		
		
	}


}
