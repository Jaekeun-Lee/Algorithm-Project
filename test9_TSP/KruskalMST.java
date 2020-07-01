package project.test9_TSP;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {
	int N, M;		//N 정점수 , M 간선수
	List<Edge>[] graph;		
	UnionFind uf;
	Edge[] tree;

	static class Weight_Comparison implements Comparator<Edge> {	//priorityQueue를 사용하기위해 어느 방식으로 비교해서 우선순위를 정할지 나타내는 메서드
		public int compare(Edge e, Edge f) {
			if (e.weight > f.weight) {
				return 1;
			} else if (e.weight < f.weight) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public KruskalMST(List<Edge>[] adjList, int numOfEdges) {
		N = adjList.length;					//정점의 수
		M = numOfEdges;						//간선의 수
		graph = adjList;					//행렬방식에서 리스트로 바꾼 adjList를 graph에 담음
		uf = new UnionFind(N);				//Union-find 메서드를 사용하기위해 객체생성 
		tree = new Edge[N - 1];				//간선의 갯수는 정점 개수 -1
	}

	public Edge[] mst() {
		Weight_Comparison BY_WEIGHT = new Weight_Comparison();		//우선순위를 정하는 객체 생성
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(M, BY_WEIGHT);	//우선순위 큐 객체 생성

		for (int i = 0; i < N; i++) {
			for (Edge e : graph[i]) {		//graph[i]에 있는 각각의 Edge형 자료들을 pg에 넣어 큐에 저장
				pq.add(e);
			}
		}

		int count = 0;
		while (!pq.isEmpty() && count < N - 1) {	//pg가 empty가 아니거나 count가 간선개수를 넘지 않았다면
			Edge e = pq.poll();						//최소 값을 e에 담음
			int u = e.fv;		//from vertex		
			int v = e.tv;		//to vertex
			if (!uf.isConnected(u, v)) {		//UnionFind 메서드 중 두 정점이 연결되있는지 확인하는 메서드
				uf.union(u, v);					//연결이 안되있으면 연결해줌
				tree[count++] = e;				//tree에 추가
			}
		}
		return tree;							//Edge[] tree를 반환
	}

}
