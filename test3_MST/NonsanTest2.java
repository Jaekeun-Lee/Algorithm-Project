package project.test3_MST;

import java.util.LinkedList;
import java.util.List;


public class NonsanTest2 {
	static String[] City = {"���","����","���","����","�ο�","����","õ��","����","��õ","�ξ�"};
	
	
	
	public static void main(String[] args) {
		
		
		int[][] dist = {
				{0, 9, 22, 34, 21, 67, 87, 51, 0, 80},
				{9, 0, 35, 0, 0, 74, 0, 0, 0, 0},
				{22, 35, 0, 0, 0, 22, 0, 0, 0, 0},
				{34, 0, 0, 0, 33, 0, 42, 0, 0, 0},
				{21, 0, 0, 33, 0, 0, 0, 0, 49, 0},
				{67, 74, 22, 0, 0, 0, 0, 0, 0, 0},
				{87, 0, 0, 42, 0, 0, 0, 0, 0, 0},
				{51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
				{0, 0, 0, 0, 49, 0, 0, 0, 0, 0},
				{80, 0, 0, 0, 0, 0, 0, 41, 0, 0},
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
		
		
		
		System.out.println("\n1. ��� �ֺ��� 10�� ������ ���� ���θ� �׷����� ���Ͽ� MST�� ���Ͽ� ����Ͻÿ�.");		//2���� MST��� 
		KruskalMST kmst = new KruskalMST(adjList, N);
		kmst.mst();
		System.out.print("Kruskal2 MST = ");
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		System.out.print("\nPrim MST = ");
		
		int[][] hung = new int[N][N];				//prim MST ���
		int[] pmin = new int[N];
		PrimMST pmst = new PrimMST(adjList);
		pmin = pmst.mst(0);
		pmst.printPrim(pmst, N-1);					//prim MST print�޼���
		
		
		/////////2�� ����/////////
		System.out.println("\n\n2. Kruskal2 MST�� ����Ͽ� ����� ��� ���÷� �ϴ� ���� ���� �׷����� MST�� ���ϰ� TSP�� �����Ͻÿ�.");	//Kruskal2 ��� MST
	
		
		System.out.println(">kruskal2 MST<");	          														
		for(int i = 0; i < N-1; i++) {
			System.out.print("("+kmst.tree[i].fv + "," + kmst.tree[i].tv+ ","+ kmst.tree[i].weight+") " ) ;
		}
		
		
		
		
		int[][] hang = new int[N][N];									//MST�� ����� ����� ��ķ� ġȯ
		  for(int i = 0; i < N-1; i++) { if(kmst.tree[i].weight != 0) {
		  hang[kmst.tree[i].fv][kmst.tree[i].tv] = kmst.tree[i].weight;
		  hang[kmst.tree[i].tv][kmst.tree[i].fv] = kmst.tree[i].weight; } }
		 
		
		List<Edge>[] hangList = new LinkedList[N];					//MST����� ����Ʈ�� �ٲ�
		AdjListEdge hL = new AdjListEdge();
		hangList = hL.convertMtoL(hang, N);
		
		System.out.print("\nTSP ���� ������: ");
		DFS hdfs = new DFS(hangList);								//����Ʈ�� ����� DFS�� ���� �ߺ��� ����
		hdfs.adj.add(0);   // 0 = ��ߵ���
		int[] d = new int[N+1];
		System.out.print(" => 0\n");
		
		System.out.print("����:");
		for(int i= 0; i < N+1; i++) {
			d[i] = hdfs.adj.remove();		//dfs����� d�迭�� �־���		
			System.out.print("=>"+City[d[i]]);	// d�迭�� �ε����� ���õ��� �̸��� �����ͼ� ���
		}
		d[N] = 0;							//���������� �ȳ־��൵ 0(���)������ ��������� ���� �־���.
		
		DijkstraSP di = new DijkstraSP(adjList);				//���۽�Ʈ�� �ִ� ����Ʈ�� MST�� ����Ʈ�� �ƴ� ó�� adjList�� �Է�
		int sum = 0;							//�̵��Ÿ�
		for(int i = 0; i < d.length -1; i++) {					//MST�� ��ȯ ��θ� ���󰡵� adjList�� �ּҰŸ����� �����Ͽ� adjList�� ��ΰ� �� ª���� adjList�� �ּҰŸ��� ���� ���
			int [] distance = di.shortestPath(d[i]);			//d�迭�� ������ִ� ���ü�ȯ �ε����� i�� i+1�� ���� ���������� ���
			sum += distance[d[i+1]];							//��ȯ �ϸ鼭 �̵��Ÿ��� ����.
		}
		
		//adjList(���� �ڵ�)�� MST�� ���Ѵ�.
		//MST�� �̿��� dfs�� ���Ѵ�.
		//�ߺ��� ���� dfs��  adjList�� ���� ���۽�Ʈ�� Ȱ���� MST�� ����� adjList�� ��θ� ���� ���� �ִܰŸ��� ���ߴ�. 
		
		
		
		
		
		System.out.println("\nKruskal2 MST�� �̿��� TSP�� �� ����Ÿ��� "+sum+"�Դϴ�."); 
		///////////2����//////////
		
		
		
		
		
		
		///////////3������//////////
	/*	System.out.println("\n\n3. PrimMST�� ����Ͽ� ����� ��� ���÷� �ϴ� ���� ���� �׷�����  MST�� ���ϰ� TSP�� �����Ͻÿ�.");
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
		}*/
		
		
	}


}
