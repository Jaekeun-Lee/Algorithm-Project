package project.test3_MST;

import java.util.List;
import java.util.LinkedList;

public class PrimMST {
	int N;
	List<Edge>[] graph;
	List<Edge>[] prim;

	public PrimMST(List<Edge>[] adjList) {
		N = adjList.length;
		graph = adjList;
	}

	public int[] mst(int s) { // s= ��������
		boolean[] visited = new boolean[N];
		int[] D = new int[N];
		int[] previous = new int[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		previous[s] = 0; // �������� s�� �ڷ� �ʱ�ȭ
		D[s] = 0;

		for (int k = 0; k < N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if ((!visited[j]) && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			for (Edge i : graph[minVertex]) {
				if (!visited[i.tv]) {
					int currentDist = D[i.tv];
					int newDist = i.weight;
					if (newDist < currentDist) {
						D[i.tv] = newDist;
						previous[i.tv] = minVertex;
					}
				}
			}
		}
		return previous;

	}

	public void printPrim(PrimMST a, int N) {
		int[] minTree = new int[graph.length - 1];
		int sum = 0;
		minTree = a.mst(0); // PrimMST�� ������ ��������� �ְ� �װ� minTree�� ����

		for (int i = 0; i < graph.length; i++) { // previous���� ���� tv�� adjList�� tv�� ���� ������ fv���� weight���� ������.
			for (int j = 0; j < graph[i].size(); j++) {
				if (minTree[i] == graph[i].get(j).tv) {
					System.out.print("(" + graph[i].get(j).fv + "," + minTree[i] + "," + graph[i].get(j).weight + ") ");
					sum += graph[i].get(j).weight;
				}
			}
		}
		
		//System.out.println("�ּҽ���Ʈ���� ���� ����ġ ���� " + sum + "�Դϴ�.");
	}

	/*
	 * public void returnList(PrimMST a, int s) { // s= ���۰� int[] minTree = new
	 * int[graph.length - 1]; prim = new LinkedList[N]; minTree = a.mst(s);
	 * 
	 * for (int i = 1; i < graph.length; i++) { // previous���� ���� tv�� adjList�� tv��
	 * ���� ������ fv���� weight���� ������. for (int j = 0; j < graph[i].size(); j++) { if
	 * (minTree[i] == graph[i].get(j).tv) { Edge e = new Edge(graph[i].get(j).fv,
	 * minTree[i], graph[i].get(j).weight); prim[i].add(e);
	 * 
	 * if (minTree[i] == s) { Edge g = new Edge(s, graph[i].get(j).fv,
	 * graph[i].get(j).weight); prim[0].add(g); }
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * }
	 */
}
