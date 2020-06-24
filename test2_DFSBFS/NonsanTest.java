package project.test2_DFSBFS;

import java.util.LinkedList;
import java.util.List;




public class NonsanTest {
	static String[] City = {"���","����","���","����","�ο�","����","õ��","����","��õ","�ξ�"};
	
	
	
	public static void main(String[] args) {
		
		
		int[][] dist = {
				{0, 9, 22, 34, 21, 67, 87, 51, 79, 80},
				{9, 0, 35, 0, 0, 74, 0, 0, 0, 0},
				{22, 35, 0, 0, 0, 22, 0, 0, 0, 0},
				{34, 0, 0, 0, 33, 0, 42, 0, 0, 0},
				{21, 0, 0, 33, 0, 0, 0, 0, 49, 0},
				{67, 74, 22, 0, 0, 0, 0, 0, 0, 0},
				{87, 0, 0, 42, 0, 0, 0, 0, 0, 0},
				{51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
				{79, 0, 0, 0, 49, 0, 0, 0, 0, 0},
				{80, 0, 0, 0, 0, 0, 0, 41, 0, 0},
		};
		System.out.println("1.��� �ֺ��� 10�� ������ ���� ���θ��� ���� �߽��� ��������Ʈ�� �׷����� ǥ��");
		int N = dist.length;			//1��
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		test.printAdjList(adjList);
		
		
		
		/* 
		.tourist[].name="";
		.tourist[].keyword="";
		.tourist[].count=4;
		*/
		Tourists Nonsan = new Tourists("���");
		Tourists Gang = new Tourists("����");
		Tourists Gye = new Tourists("���");
		Tourists Gong = new Tourists("����");
		Tourists Buyeo = new Tourists("�ο�");
		Tourists DaeJeon = new Tourists("����");
		Tourists Cheon = new Tourists("õ��");
		Tourists JeonJu = new Tourists("����");
		Tourists DaeCheon = new Tourists("��õ");
		Tourists Buan = new Tourists("�ξ�");
		
		
		//���
		String k1 = "���� ������";
		String k2 = "�ڿ� �����";
		String k3 = "�޾���";
		String k4 = "����";
	
		
		Nonsan.tourist[0] = new ToursInfo("������", k1, 82);
	      Nonsan.tourist[1] = new ToursInfo("����屺", k1, 80);
	      Nonsan.tourist[2] = new ToursInfo("���ϼ���", k1, 78);
	      Nonsan.tourist[3] = new ToursInfo("ž��ȣ", k2, 90);
	      Nonsan.tourist[4] = new ToursInfo("��л�",k2,84);
	      Nonsan.tourist[5] = new ToursInfo("KT&G ��󸶴�",k3,86);
	      Nonsan.tourist[6] = new ToursInfo("������ ����ü�� �޾縶��",k3,84);
	      Nonsan.tourist[7] = new ToursInfo("��� �����η���",k3,80);
	      Nonsan.tourist[8] = new ToursInfo("�ŵ�ȸ��",k4,84);
	      Nonsan.tourist[9] = new ToursInfo("��ֵ��",k4,96);
	      

	      //���� 
	      
	      Gang.tourist[0] = new ToursInfo("����� ����", k1, 84);
	      Gang.tourist[1] = new ToursInfo("�׸�����", k1, 81);
	      Gang.tourist[2] = new ToursInfo("���� �����", k1, 78);
	      Gang.tourist[3] = new ToursInfo("�������", k2, 86);
	      Gang.tourist[4] = new ToursInfo("���� �ڿ� �޾縲", k2, 85);
	      Gang.tourist[5] = new ToursInfo("���� Ȳ�� ��� ������", k3, 74);
	      Gang.tourist[6] = new ToursInfo("õ�ֱ� ���漺��", k3, 90);
	      Gang.tourist[7] = new ToursInfo("�̳��ٸ�", k3, 89);
	      Gang.tourist[8] = new ToursInfo("���� ���� ����", k4, 87);
	      Gang.tourist[9] = new ToursInfo("���� �ع� Į����", k4, 88);

	      //���
	      Gye.tourist[0] = new ToursInfo("�����",k1,84);
	      Gye.tourist[1] = new ToursInfo("������",k1,71);
	      Gye.tourist[2] = new ToursInfo("�Ծϸ� ��������",k1,68);
	      Gye.tourist[3] = new ToursInfo("����",k2,87);
	      Gye.tourist[4] = new ToursInfo("���������",k2,85);
	      Gye.tourist[5] = new ToursInfo("��������ž",k3,81);
	      Gye.tourist[6] = new ToursInfo("������ ����ȭ �н���",k3,84);
	      Gye.tourist[7] = new ToursInfo("�ΰ�õ ���°���",k3,81);
	      Gye.tourist[8] = new ToursInfo("�����",k4,90);
	      Gye.tourist[9] = new ToursInfo("��簡��",k4,88);
	      
	      //����
	      Gong.tourist[0] = new ToursInfo("���ɿո�", k1, 84);
	      Gong.tourist[1] = new ToursInfo("���꼺", k1, 82);
	      Gong.tourist[2] = new ToursInfo("���帮 �ڹ���", k1, 80);
	      Gong.tourist[3] = new ToursInfo("Ȳ������", k2, 78);
	      Gong.tourist[4] = new ToursInfo("����õ���°���", k2, 76);
	      Gong.tourist[5] = new ToursInfo("�����ѿ�����", k3, 97);
	      Gong.tourist[6] = new ToursInfo("�������ֹڹ���", k3, 84);
	      Gong.tourist[7] = new ToursInfo("�Ӹ��̼���", k3, 67);
	      Gong.tourist[8] = new ToursInfo("���ؿ�", k4, 75);
	      Gong.tourist[9] = new ToursInfo("������ Į����", k4, 84);
	      
	      //�ο�
	      
	      Buyeo.tourist[0] = new ToursInfo("��������",k1 ,84);
	      Buyeo.tourist[1] = new ToursInfo("�ó���",k1 ,84);
	      Buyeo.tourist[2] = new ToursInfo("�μһ꼺", k1,81);
	      Buyeo.tourist[3] = new ToursInfo("��ȭ��", k2,87);
	      Buyeo.tourist[4] = new ToursInfo("����� �������", k2,88);
	      Buyeo.tourist[5] = new ToursInfo("�ο������ڹ���", k3 ,78);
	      Buyeo.tourist[6] = new ToursInfo("������ȭ����", k3,96);
	      Buyeo.tourist[7] = new ToursInfo("�������׸���ũ", k3,99);
	      Buyeo.tourist[8] = new ToursInfo("�����ѿ�", k4,69);
	      Buyeo.tourist[9] = new ToursInfo("�����̾߱�", k4,75);
	      
	      

	      //����
	      DaeJeon.tourist[0] = new ToursInfo("�л� ����������", k1, 78);
	      DaeJeon.tourist[1] = new ToursInfo("��������꼺", k1, 67);
	      DaeJeon.tourist[2] = new ToursInfo("���帮 �ڹ���", k1, 87);
	      DaeJeon.tourist[3] = new ToursInfo("���»� �ڿ��޾縲", k2, 88);
	      DaeJeon.tourist[4] = new ToursInfo("������", k2, 79);
	      DaeJeon.tourist[5] = new ToursInfo("���� �ù� õ����", k3, 81);
	      DaeJeon.tourist[6] = new ToursInfo("������", k3, 94);
	      DaeJeon.tourist[7] = new ToursInfo("�ѹ� �����", k3, 84);
	      DaeJeon.tourist[8] = new ToursInfo("���ɴ�", k4, 94);
	      DaeJeon.tourist[9] = new ToursInfo("�ŵ�Į����", k4, 74);

	      //õ��
	      
	      Cheon.tourist[0] = new ToursInfo("��������" ,k1 ,98);
	      Cheon.tourist[1] = new ToursInfo("������ ������" ,k1 ,88);
	      Cheon.tourist[2] = new ToursInfo("���������� ����" ,k1 ,97);
	      Cheon.tourist[3] = new ToursInfo("������" ,k2 ,81);
	      Cheon.tourist[4] = new ToursInfo("õȣ��" ,k2 ,81);
	      Cheon.tourist[5] = new ToursInfo("�����̼���" ,k3 ,67);
	      Cheon.tourist[6] = new ToursInfo("�����Ǿ�" ,k3 ,96);
	      Cheon.tourist[7] = new ToursInfo("ȫ�����а�" ,k3 ,87);
	      Cheon.tourist[8] = new ToursInfo("��õ����" ,k4 ,87);
	      Cheon.tourist[9] = new ToursInfo("�����߰���" ,k4 ,67);

	      //����
	      JeonJu.tourist[0] = new ToursInfo("�����", k1, 74);
	      JeonJu.tourist[1] = new ToursInfo("�����ѿ�����", k1, 97);
	      JeonJu.tourist[2] = new ToursInfo("ǳ����", k1, 81);
	      JeonJu.tourist[3] = new ToursInfo("���� �ڿ����°�", k2, 67);
	      JeonJu.tourist[4] = new ToursInfo("����õ��", k2, 68);
	      JeonJu.tourist[5] = new ToursInfo("��������", k3, 75);
	      JeonJu.tourist[6] = new ToursInfo("�ڸ� ��ȭ����", k3, 76);
	      JeonJu.tourist[7] = new ToursInfo("���� �ڹ���", k3, 78);
	      JeonJu.tourist[8] = new ToursInfo("������", k4, 79);
	      JeonJu.tourist[9] = new ToursInfo("���", k4, 82);
	      //��õ
	      
	      DaeCheon.tourist[0] = new ToursInfo("��û ������" ,k1 ,71);
	      DaeCheon.tourist[1] = new ToursInfo("���ֻ���" ,k1 ,84);
	      DaeCheon.tourist[2] = new ToursInfo("�ְ�� ����" ,k1 ,64);
	      DaeCheon.tourist[3] = new ToursInfo("�׵�������" ,k2 ,88);
	      DaeCheon.tourist[4] = new ToursInfo("��â��" , k2,72);
	      DaeCheon.tourist[5] = new ToursInfo("��õ �ؼ�����" , k3,97);
	      DaeCheon.tourist[6] = new ToursInfo("��ź �ڹ���" , k3,88);
	      DaeCheon.tourist[7] = new ToursInfo("��ȭ ��������" , k3,78);
	      DaeCheon.tourist[8] = new ToursInfo("ȭ��� �����Ÿ�" , k4,86);
	      DaeCheon.tourist[9] = new ToursInfo("Ȳ�ؿ�" , k4,88);


	      //�ξ�
	      Buan.tourist[0] = new ToursInfo("�ξȼ����ȴ��", k1, 87);
	      Buan.tourist[1] = new ToursInfo("�ݰ輱��������", k1, 84);
	      Buan.tourist[2] = new ToursInfo("������ �����", k1, 74);
	      Buan.tourist[3] = new ToursInfo("ä����", k2, 74);
	      Buan.tourist[4] = new ToursInfo("������", k2, 84);
	      Buan.tourist[5] = new ToursInfo("���ҿ���", k3, 63);
	      Buan.tourist[6] = new ToursInfo("������ �б�", k3, 95);
	      Buan.tourist[7] = new ToursInfo("�ξ� �����׸���ũ", k3, 87);
	      Buan.tourist[8] = new ToursInfo("������", k4, 97);
	      Buan.tourist[9] = new ToursInfo("��ȭ�ڹ�����", k4, 91);
		
		
		int[] d = new int[N];				//dfs,bfs�� ���� �迭
		int sum = 0;
		System.out.print("DFS �ε��� ����=> ");													//dfs,bfs ����.
		DFS dfs = new DFS(adjList);			//dfs
		System.out.print("\nBFS �ε��� ����=> ");
		BFS bfs = new BFS(adjList);			//bfs
		
		
		
		System.out.println("\n2.DFS Ž������ ������ ������ ���� ���������� ��θ� ��� ���� ������ �Ÿ����� ����Ͻÿ�.");
		for(int i= 0; i < N; i++) {
			d[i] = dfs.adj.remove();		//dfs ���� ��ȸ ����
			System.out.print(City[d[i]] + "=> ");
		}
		
		
		
		DijkstraSP di = new DijkstraSP(adjList);				//dfs �̵��Ÿ� ���� (���ͽ�Ʈ�� ���)
		for(int i = 0; i < d.length -1; i++) {
			int[] distance = di.shortestPath(d[i]);
				sum += distance[d[i+1]];
		}
		System.out.println("DFS �� ����Ÿ��� "+ sum+ "�Դϴ�.\n"); 
		
		
		
		  System.out.println("\n3.BFS Ž������ ������ ������ ���� ���������� ��θ� ��� ���� ������ �Ÿ����� ����Ͻÿ�."
		  ); sum = 0;
		  
		 
		  for(int i= 0; i < N; i++) {
			d[i] = bfs.adj.remove(); //bfs ���� ��ȸ ����
		  	System.out.print(City[d[i]] + "=> "); 
		  } 
		  
		  for(int i = 0; i < d.length -1; i++) {					//bfs �̵��Ÿ� (���ͽ�Ʈ����)
				int[] distance = di.shortestPath(d[i]);
					sum += distance[d[i+1]];
			}
			System.out.println("BFS �� ����Ÿ��� "+ sum+ "�Դϴ�.\n"); 
		  

			
			
			
		  /* for(int i = 0; i < N-1; i++) {		//2�� dfs ����Ÿ�
			sum += dist[d[i]][d[i+1]];	
	    	}
		 System.out.println("DFS �� ����Ÿ��� "+ sum+ "�Դϴ�.\n"); */ 
		  
		 /* System.out.println("BFS �� ����Ÿ��� "+ sum+"�Դϴ�.\n"); */

		 //��������Ʈ 9�� ����

	}


}
