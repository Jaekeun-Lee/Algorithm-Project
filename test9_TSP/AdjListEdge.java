package project.test9_TSP;

import java.util.LinkedList;
import java.util.List;

class AdjListEdge{
	private int totalV;                // number of max vertex
	private List<Edge>[] adjList;  // 정점별 간선 리스트
	
	public List<Edge>[] convertMtoL(int dist[][] , int N) {  // 인접리스트로 바꾸기
		
		adjList = new List[N];
	
		for(int i=0; i<N; i++) {
			adjList[i] = new LinkedList<>();
			for(int j=0; j<N; j++) {
				if(dist[i][j] > 0) {
					Edge e = new Edge(i,j,dist[i][j]);
					adjList[i].add(e);
					
				}
			}
		}
		return adjList;
	}
	
	public void printAdjList(List<Edge> adjList[]) {
		TSPTest Nt = new TSPTest();
		
		
		
		for(int i = 0; i < adjList.length; i++) {
			System.out.print(""+Nt.City[i]+ "출발:");
			for(int j = 0; j < adjList[i].size(); j++) {
				System.out.print("==> "+ Nt.City[adjList[i].get(j).tv] + " " + adjList[i].get(j).weight +"km");
			}
			System.out.println();
		}

		
	}
}
