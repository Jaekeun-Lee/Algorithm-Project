package project.test9_TSP;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {
	int N, M;		//N ������ , M ������
	List<Edge>[] graph;		
	UnionFind uf;
	Edge[] tree;

	static class Weight_Comparison implements Comparator<Edge> {	//priorityQueue�� ����ϱ����� ��� ������� ���ؼ� �켱������ ������ ��Ÿ���� �޼���
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
		N = adjList.length;					//������ ��
		M = numOfEdges;						//������ ��
		graph = adjList;					//��Ĺ�Ŀ��� ����Ʈ�� �ٲ� adjList�� graph�� ����
		uf = new UnionFind(N);				//Union-find �޼��带 ����ϱ����� ��ü���� 
		tree = new Edge[N - 1];				//������ ������ ���� ���� -1
	}

	public Edge[] mst() {
		Weight_Comparison BY_WEIGHT = new Weight_Comparison();		//�켱������ ���ϴ� ��ü ����
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(M, BY_WEIGHT);	//�켱���� ť ��ü ����

		for (int i = 0; i < N; i++) {
			for (Edge e : graph[i]) {		//graph[i]�� �ִ� ������ Edge�� �ڷ���� pg�� �־� ť�� ����
				pq.add(e);
			}
		}

		int count = 0;
		while (!pq.isEmpty() && count < N - 1) {	//pg�� empty�� �ƴϰų� count�� ���������� ���� �ʾҴٸ�
			Edge e = pq.poll();						//�ּ� ���� e�� ����
			int u = e.fv;		//from vertex		
			int v = e.tv;		//to vertex
			if (!uf.isConnected(u, v)) {		//UnionFind �޼��� �� �� ������ ������ִ��� Ȯ���ϴ� �޼���
				uf.union(u, v);					//������ �ȵ������� ��������
				tree[count++] = e;				//tree�� �߰�
			}
		}
		return tree;							//Edge[] tree�� ��ȯ
	}

}
