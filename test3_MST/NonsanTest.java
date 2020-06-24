package project.test3_MST;

import java.util.LinkedList;
import java.util.List;


public class NonsanTest {
	static String[] City = {"���","����","���","����","�ο�","����","õ��","����","��õ","�ξ�"};
	
	
	
	public static void main(String[] args) {
		
		
		int[][] dist = {
				{0, 10, 22, 0, 20, 0, 0, 0, 0, 0},
	            {10, 0, 0, 0, 20, 0, 0, 41, 0, 62},
	            {22, 0, 0, 29, 0, 23, 0, 61, 0, 0},
	            {0, 0, 29, 0, 0, 35, 47, 0, 0, 0},
	            {20, 20, 0, 0, 0, 0, 0, 0, 49, 0},
	            {0, 0, 23, 35, 0, 0, 0, 0, 0, 0},
	            {0, 0, 0, 47, 0, 0, 0, 0, 93, 0},
	            {0, 41, 61, 0, 0, 0, 0, 0, 0, 41},
	            {0, 0, 0, 0, 49, 0, 93, 0, 0, 0},
	            {0, 62, 0, 0, 0, 0, 0, 41, 0, 0},
		};
		int N = dist.length;	
		/*
		 * System.out.printf("�Է� �׷����� ��������Դϴ�.\n    "); for(int i=0; i<N; i++)
		 * System.out.printf("%4d", i); System.out.println(); for(int i=0; i<N; i++) {
		 * System.out.printf("%2d: ", i); for(int j=0; j<N; j++)
		 * System.out.printf("%4d", dist[i][j]); System.out.println(); }
		 * 
		 */
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		
		
		
		System.out.println("\n1. ��� �ֺ��� 10�� ������ ���� ���θ� �׷����� ���Ͽ� MST�� ���Ͽ� ����Ͻÿ�.");		//MST���
		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		
		
		/////////2�� ����/////////
		System.out.println("\n\n2. Kruskal2 MST�� ����Ͽ� ����� ��� ���÷� �ϴ� ���� ���� �׷����� MST�� ���ϰ� TSP�� �����Ͻÿ�.");	//Kruskal2 ��� MST
	
		int[][] hang = new int[N][N];									//MST�� ����� ����� ��ķ� ġȯ
		  for(int i = 0; i < N-1; i++) { if(kmst.tree[i].weight != 0) {
		  hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
		  hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight; } }
		 
		
		List<Edge>[] hangList = new LinkedList[N];					//MST����� ����Ʈ�� �ٲ�
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);
		
		System.out.print("TSP ���� ������: ");
		DFS hdfs = new DFS(hangList);								//DFS�� ���� �ߺ��� ����
		hdfs.adj.add(0);   // 0 = ��ߵ���
		int[] d = new int[N+1];
		System.out.print("0\n");
		
		System.out.print("����:");
		for(int i= 0; i < N+1; i++) {
			d[i] = hdfs.adj.remove();		//dfs����� d�迭�� �־���
			System.out.print("=>"+City[d[i]]);
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += dist[d[i]][d[i+1]];
		}
		System.out.println("\nKruskal2 MST�� �̿��� TSP�� �� ����Ÿ��� "+sum+"�Դϴ�.");
		///////////2����//////////
		
		
		
		
		
		
		///////////3������//////////
		System.out.println("\n\n3. PrimMST�� ����Ͽ� ����� ��� ���÷� �ϴ� ���� ���� �׷�����  MST�� ���ϰ� TSP�� �����Ͻÿ�.");
		int[][] hung = new int[N][N];
		int[] pmin = new int[N];
		PrimMST pmst = new PrimMST(adjList);
		pmin = pmst.mst(0);
		
		//pmst.printPrim(pmst, N-1);					//�ּҽ���Ʈ�� ����ġ
		for(int i = 0; i<N; i++) {									//PrimMST�� ��ķ� ��ȯ
			for(int j = 0; j < adjList[i].size(); j++) {
				if (pmin[i] == adjList[i].get(j).tv) {
					hung[i][j] = adjList[i].get(j).weight;
					hung[j][i] = adjList[i].get(j).weight;
				}
			}
		}
		
		List<Edge>[] hungList = new LinkedList[N];
		hungList = test.convertMtoL(hung, N);
		// test.printAdjList(hungList);
		int[] q = new int[N+1];
		System.out.print("TSP ���� ������: ");
		DFS pdfs = new DFS(hungList);
		pdfs.adj.add(0);			//���� ����
		System.out.print("0\n");
		
		System.out.print("����:");
		for(int i= 0; i < N+1; i++) {
			q[i] = pdfs.adj.remove();		//dfs����� d�迭�� �־���
			System.out.print("=>"+City[q[i]]);
		}
		
		sum = 0;				//sum �ʱ�ȭ
		for(int i = 0; i < N; i++) {
			sum += dist[d[i]][d[i+1]];
		}
		System.out.println("\nprim MST�� �̿��� TSP�� �� ����Ÿ��� "+sum+"�Դϴ�.");
		
		
		for(int i = 0; i < N; i++){						//previous���� ���� tv�� adjList�� tv�� ���� ������ fv���� weight���� ������.
			for(int j = 0; j < adjList[i].size(); j++) {
				if(pmin[i] == adjList[i].get(j).tv) {
					System.out.print("("+adjList[i].get(j).fv + ","+ pmin[i] + ","+adjList[i].get(j).weight +")");
					sum += adjList[i].get(j).weight;
				}
			}
		}
		
		
	}


}
