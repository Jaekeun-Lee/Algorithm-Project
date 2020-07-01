package project.test9_TSP;

import java.util.LinkedList;
import java.util.List;

class AdjListEdge{
	private int totalV;                // number of max vertex
	private List<Edge>[] adjList;  // ������ ���� ����Ʈ
	
	public List<Edge>[] convertMtoL(int dist[][] , int N) {  // ��������Ʈ�� �ٲٱ�
		
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
			System.out.print(""+Nt.City[i]+ "���:");
			for(int j = 0; j < adjList[i].size(); j++) {
				System.out.print("==> "+ Nt.City[adjList[i].get(j).tv] + " " + adjList[i].get(j).weight +"km");
			}
			System.out.println();
		}

		
	}
}
