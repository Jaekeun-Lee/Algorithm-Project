package project.test2_DFSBFS;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



class DFS {
	
	
	int N;	 // �׷��� ������ ��
	Queue<Integer> adj;
	List<Edge>[] graph;    
	Stack<Edge> back;
	private boolean[ ] visited;	// DFS ���� �� �湮�� ������ true�� �����.
	int sum = 0;
	
	
	public DFS(List<Edge>[] adjList) { // ������
		N = adjList.length;
		adj = new LinkedList<>();
		graph = adjList;  
		back = new Stack(); 
		visited = new boolean [N];
		for (int i = 0; i < N; i++) visited[i] = false;  // �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);  // ���� ���Ἲ�� ���
	}
	
	private void dfs(int i) {
		visited[i] = true;        // ���� i�� �湮�Ǿ� visited[i]�� true�� �����.
		System.out.print(i+" ");  // ���� i�� �湮�Ǿ����� ����Ѵ�.
		adj.add(i);
		
		for (Edge e: graph[i]) {
			if(!visited[e.tv]) {
				back.push(e);	
		}
	}
		
		while(!back.isEmpty()) {
			Edge e = back.pop();   // ���� i�� ������ �� ������ ����
			if (!visited[e.tv])  dfs(e.tv);
		}

	}
}