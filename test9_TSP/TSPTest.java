package project.test9_TSP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class TSPTest {
	static String[] City = { "���", "����", "���", "����", "�ο�", "����", "õ��", "����", "��õ", "�ξ�" };

	public static void main(String[] args) {
		int[][] dist = {   
				  {0, 9, 22, 34, 21, 43, 75, 51, 67, 80},
			      {9, 0, 30, 0, 0, 52, 0, 0, 0, 0},
			      {22, 30, 0, 0, 0, 22, 74, 0, 0, 0},
			      {34, 0, 0, 0, 33, 0, 42, 0, 70, 0},
			      {21, 0, 0, 33, 0, 0, 0, 0, 49, 79},
			      {43, 52, 22, 0, 0, 0, 0, 0, 0, 0},
			      {75, 0, 74, 42, 0, 0, 0, 0, 0, 0},
			      {51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
			      {67, 0, 0, 70, 49, 0, 0, 0, 0, 0},
			      {80, 0, 0, 0, 79, 0, 0, 41, 0, 0}, };
		int N = dist.length;
		AdjListEdge adj = new AdjListEdge();
		List<Edge>[] adjList = new LinkedList[N];
		adjList = adj.convertMtoL(dist, N);

		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		int[][] hang = new int[N][N]; // MST�� ����� ����� ��ķ� ġȯ
		for (int i = 0; i < N - 1; i++) {
			if (kmst.tree[i].weight != 0) {
				hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
				hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight;
			}
		}

		List<Edge>[] hangList = new LinkedList[N]; // MST����� ����Ʈ�� �ٲ�
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);

		DFS dfs = new DFS(hangList);	
		
		int[] dfsVer = new int[11];		//dfs��μ����� �����ϴ� �迭	
		dfsVer[0] = 0;
		dfsVer[10] = 0;
		for(int i =1; i< N+1; i++) {		//�ߺ��� ����
			dfsVer[i] = dfs.adj.pop();
			//System.out.print(" "+ dfsVer[i]);
		}

		System.out.println("MST + DFS + �ߺ�ȸ�� ����� TSP�Դϴ�.");
		System.out.print("TSP :");
		int SumDist = 0;
		for(int i= 0; i<N; i++) {											//���� �׷������� TSP�� ã��
			for(int j=0; j<adjList[dfsVer[i]].size(); j++) {
				if(adjList[dfsVer[i]].get(j).tv == dfsVer[i+1]) {
					System.out.print("=>"+City[dfsVer[i]]);
					SumDist += adjList[dfsVer[i]].get(j).weight;
				}else if(dfsVer[i+1] == 0){
					System.out.print("=>"+City[0]);
				}
			}
		}
		System.out.print("\n TSP�� �ѰŸ��� ���� "+ SumDist+"km �Դϴ�.");
	
		
		
		
		
		
		//���Ϸ� ����Ŭ + �ߺ�ȸ�� ����� TSP�Դϴ�.
		
		DijkstraSP di = new DijkstraSP(adjList);
		ArrayList<Integer> qs = new ArrayList<>();
		
		for(int i = 0 ; i<N; i++) {		//���������� Ȧ���� ���� ã��
			//System.out.print(i +"  ");
			int j;
			for(j= 0; j< hangList[i].size(); j++) {
				//System.out.print(" "+hangList[i].get(j).tv);
			}
			if(j % 2 != 0 ) {
				qs.add(i);				//ã�� Ȧ�� ã���� ArrayList�� �߰�
			}
			//System.out.println();
		}
		
		for(int i =0; i<N; i++) {		//MST�� ��� Ȯ��
			for(int j=0; j<N; j++) {
				//System.out.print(" "+hang[i][j]);
			}
			//System.out.println();
		}
		
		
		for(int i=0; i<qs.size(); i++) {				//Ȧ���� �������� �������� ���� �����ϴ� ������ 
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			int[] distance = di.shortestPath(qs.get(i));
			for(int j = 0; j<qs.size();j++) {
				if(distance[qs.get(j)] != 0 && distance[qs.get(j)] < min) {	//Ȧ�� ������ ���̿� �ִܰ�θ� ã�� if��
					min = distance[qs.get(j)];
					minIdx = qs.get(j);
				}
			}
			//	System.out.println(qs.get(i) + " " +minIdx);
			if(dist[qs.get(i)][minIdx] != 0) {					//Ȧ�� �����鰣�� ��θ� ������ ���� ���� ��Ŀ� �� ���� �ִٸ� ������ ����� �� ������ MST�׷����� �߰�
				Edge e = new Edge(qs.get(i),minIdx, dist[qs.get(i)][minIdx]);
				hangList[qs.get(i)].add(e);
				hangList[minIdx].add(e);	
		}
		}
		
		
		for(int i = 0; i < N; i++) { 				// ���ܰ迡�� ���� �ߺ� ������ ����� ������
			for(int j=0; j< hangList[i].size()-1; j++) {
				if(hangList[i].get(j).tv == hangList[i].get(j+1).tv) {
					hangList[i].remove(j+1);
				}
			}
		}
		
		for(int i = 0 ; i<N; i++) {		//��������Ʈ Ȯ��
			//System.out.print(i +"  ");
			int j;
			for(j= 0; j< hangList[i].size(); j++) {
				//System.out.print(" "+hangList[i].get(j).tv);
			}
			if(j % 2 != 0 ) {
				//qs.add(i);
			}
			//System.out.println();
		}
		
		DFS odfs = new DFS(hangList);
		dfsVer[0] = 0;
		dfsVer[10] = 0;
		for(int i =1; i< N+1; i++) {		//ã�� MST�׷������� �ߺ��� ����
			dfsVer[i] = odfs.adj.pop();
			//System.out.print(" "+ dfsVer[i]);
		}

		System.out.println("\n\nMST + ���Ϸ�����Ŭ + �ߺ�ȸ�� ����� TSP�Դϴ�.");
		System.out.print("TSP :");
		SumDist = 0;
		for(int i= 0; i<N; i++) {											//���� �׷������� TSP�� ã��
			for(int j=0; j<adjList[dfsVer[i]].size(); j++) {
				if(adjList[dfsVer[i]].get(j).tv == dfsVer[i+1]) {
					System.out.print("=>"+City[dfsVer[i]]);
					SumDist += adjList[dfsVer[i]].get(j).weight;
				}else if(dfsVer[i+1] == 0){
					System.out.print("=>"+City[0]);
				}
			}
		}
		System.out.print("\n TSP�� �ѰŸ��� ���� "+ SumDist+"km �Դϴ�.");
		
	}
}
