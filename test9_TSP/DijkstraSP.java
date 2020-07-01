package project.test9_TSP;

import java.util.List;

public class DijkstraSP {
	public int N;			//�׷��� ������ �� 
	List<Edge>[] graph;
	public int[] previous; //�ִܰ�λ� ���� ������ �����.
	public DijkstraSP(List<Edge>[] adjList) {
		N = adjList.length;
		previous = new int[N];
		graph = adjList;
	}
	public int[] shortestPath(int s) {
		boolean[] visited = new boolean[N];
		int[] D = new int[N];
		for(int i = 0; i< N; i++) {	//�ʱ�ȭ
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		D[s]=0;
		for(int k = 0; k< N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) {
				if((!visited[j]) &&(D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for(Edge e : graph[minVertex]) { //minVertex�� ������ ������
				if(!visited[e.tv]) { //���� �湮 �ȵ� �����̶��
					int currentDist = D[e.tv];	
					int newDist = D[minVertex] + e.weight;
					if(newDist< currentDist) {
						D[e.tv] = newDist;
						previous[e.tv] = minVertex;	//���� �ִܰ�θ� �� �������� ����
					}
				}
			}
		}
		return D;
	}
}

