package project.test3_MST;

import java.util.LinkedList;
import java.util.List;


public class NonsanTest {
	static String[] City = {"논산","강경","계룡","공주","부여","대전","천안","전주","대천","부안"};
	
	
	
	public static void main(String[] args) {
		
		
		int[][] dist = {
				{0, 10, 22, 0, 20, 0, 0, 0, 0, 0},
	            {10, 0, 0, 0, 20, 0, 0, 41, 0, 62},
	            {22, 0, 0, 29, 0, 23, 0, 61, 0, 0},
	            {0, 0, 29, 0, 0, 35, 47, 0, 0, 0},
	            {20, 20, 0, 0, 0, 0, 0, 0, 49, 0},
	            {0, 0, 23, 35, 0, 0, 0, 0, 0, 0},
	            {0, 0, 0, 47, 0, 0, 0, 0, 93, 0},
	            {0, 41, 61, 0, 0, 0, 0, 0, 0, 41},
	            {0, 0, 0, 0, 49, 0, 93, 0, 0, 0},
	            {0, 62, 0, 0, 0, 0, 0, 41, 0, 0},
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
		
		
		
		System.out.println("\n1. 논산 주변의 10개 도시의 연결 도로망 그래프에 대하여 MST를 구하여 출력하시오.");		//MST출력
		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		
		
		/////////2번 시작/////////
		System.out.println("\n\n2. Kruskal2 MST을 사용하여 논산을 출발 도시로 하는 도시 관광 그래프의 MST를 구하고 TSP를 구현하시오.");	//Kruskal2 사용 MST
	
		int[][] hang = new int[N][N];									//MST를 사용한 결과를 행렬로 치환
		  for(int i = 0; i < N-1; i++) { if(kmst.tree[i].weight != 0) {
		  hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
		  hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight; } }
		 
		
		List<Edge>[] hangList = new LinkedList[N];					//MST행렬을 리스트로 바꿈
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);
		
		System.out.print("TSP 정점 순서도: ");
		DFS hdfs = new DFS(hangList);								//DFS를 통해 중복값 삭제
		hdfs.adj.add(0);   // 0 = 출발도시
		int[] d = new int[N+1];
		System.out.print("0\n");
		
		System.out.print("순서:");
		for(int i= 0; i < N+1; i++) {
			d[i] = hdfs.adj.remove();		//dfs결과를 d배열에 넣어줌
			System.out.print("=>"+City[d[i]]);
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += dist[d[i]][d[i+1]];
		}
		System.out.println("\nKruskal2 MST을 이용한 TSP의 총 여행거리는 "+sum+"입니다.");
		///////////2번끝//////////
		
		
		
		
		
		
		///////////3번시작//////////
		System.out.println("\n\n3. PrimMST을 사용하여 논산을 출발 도시로 하는 도시 관광 그래프의  MST를 구하고 TSP를 구현하시오.");
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
		}
		
		
	}


}
