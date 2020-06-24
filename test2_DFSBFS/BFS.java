package project.test2_DFSBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS {
	int N;  // �׷��� ������ ��
	List<Edge>[] graph;
	public Queue<Integer> adj;
	private boolean[ ] visited;	 // BFS ���� �� �湮�� ������ ���Ҹ� true�� �����.
	int sum  =0;
	
	public BFS(List<Edge>[] adjList) { // ������
		N = adjList.length;    
		adj = new LinkedList<>();
		graph = adjList;    
		visited = new boolean [N];
		for (int i = 0; i < N; i++) visited[i] = false;   // �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) if (!visited[i]) bfs(i);
	}
	private void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();  // ť ����
		visited[i] = true;
		q.add(i); //ť�� ���� ���� s�� ����		
		while (!q.isEmpty()) {
			int j = q.remove();  	     // ť���� ���� j�� ������ 
			adj.add(j);
			System.out.print(j+" ");
		
			for (Edge e: graph[j]) {     // ���� j�� ������ ���� �湮
				if (!visited[e.tv]) {
					visited[e.tv] = true;
					q.add(e.tv);  // �湮�� ������ ť�� ����
					sum += e.weight*2;
				
				}
			}
		}
	
	}
}