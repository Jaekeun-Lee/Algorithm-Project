package project.test2_DFSBFS;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



class DFS {
	
	
	int N;	 // 그래프 정점의 수
	Queue<Integer> adj;
	List<Edge>[] graph;    
	Stack<Edge> back;
	private boolean[ ] visited;	// DFS 수행 중 방문한 정점을 true로 만든다.
	int sum = 0;
	
	
	public DFS(List<Edge>[] adjList) { // 생성자
		N = adjList.length;
		adj = new LinkedList<>();
		graph = adjList;  
		back = new Stack(); 
		visited = new boolean [N];
		for (int i = 0; i < N; i++) visited[i] = false;  // 배열 초기화
		for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);  // 복수 연결성분 대비
	}
	
	private void dfs(int i) {
		visited[i] = true;        // 점점 i가 방문되어 visited[i]를 true로 만든다.
		System.out.print(i+" ");  // 정점 i가 방문되었음을 출력한다.
		adj.add(i);
		
		for (Edge e: graph[i]) {
			if(!visited[e.tv]) {
				back.push(e);	
		}
	}
		
		while(!back.isEmpty()) {
			Edge e = back.pop();   // 정점 i에 인접한 각 정점에 대해
			if (!visited[e.tv])  dfs(e.tv);
		}

	}
}