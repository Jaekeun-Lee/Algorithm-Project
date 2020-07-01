package project.test8_Dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
		
		int N = dist.length;
		List<Edge>[] adjList = new List[N];
		for(int i =0; i<N; i++) {
			adjList[i] = new LinkedList<>();
			for(int j = 0; j< N; j++) {
				if(dist[i][j] != 0 ) {
					Edge e = new Edge(i,j, dist[i][j]);
					adjList[i].add(e);
				}
			}
		}
	
		DijkstraSP di = new DijkstraSP(adjList);
		Stack<Integer> s = new Stack<>();
		Edge[] ESort = new Edge[N];
		
		
		 		//���� �ε��� 0
		
		/* for(int i = 0; i< distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println(i+"�� ���Ἲ�� ����");
			}else {
				System.out.println("(0 => "+i+") = �� �Ÿ� �� : "+ distance[i]);
			}
		}
		
		for(int i = 1; i < di.N; i++) {
			int back = i;
			//System.out.print(back); 
			s.push(back);					//������ ����.
			while(back != 0) {
				
				//System.out.print(" <=" + di.previous[back]);
				s.push(di.previous[back]);		//������ ���� ����.
				back = di.previous[back];
			}
			System.out.println();
			
			for(int q = 0; q< 10; q++) {
				
				if(!s.isEmpty()) {						//Stack�ȿ� ��Ұ� ������ pop()����
					System.out.print(City[s.pop()]+"=>");
				}
			}
		}
		*/
		
		System.out.println("�ִܰŸ� ����");
		for(int i = 0; i < N; i++) {				//�ִܰŸ� , �Ÿ����, ��ε���
			int min=10000;
			int max=0;
			int minver = 0;		
			int Fromver = 0;	//fv
			int Tover = 0;		//tv
			
			
			int[] distance = di.shortestPath(i);
			
			for(int j=0; j<N; j++) {					
				if(distance[j] < min && distance[j] != 0) {
					min = distance[j];
					Tover = minver = j;
					Fromver =i;
				}else if(distance[j]> max) {
					max = distance[j];
				}
			}
			ESort[i] = new Edge(Fromver, Tover, min);			//sort�� ���� fv tv ����ġ�� �������迭�� ����
			System.out.println(City[i]+"���� ���� �ִܰŸ� ���ô� "+ City[minver]+"�̰� �Ÿ��� "+ min+"km �Դϴ�.");
			
			while(di.previous[minver] != -1) {
				
				if(di.previous[minver] != 0) {
					s.push(minver);
					minver = di.previous[minver];
				}else if(di.previous[minver] == 0 && di.previous[0] == -1) {
					s.push(minver);
					break;
				}
			}
			
			for(int q = 0; q< 10; q++) {
				if(!s.isEmpty()) {						//Stack�ȿ� ��Ұ� ������ pop()����
					System.out.println("�ִܰ��: "+City[i]+ "=>"+City[s.pop()]);
				}
			}
				
			System.out.println();

		}
		
		Arrays.sort(ESort);
		
		System.out.println("�ִ� ����� �Ÿ��� ū ���� 10��");
		for(int i = 0; i<N; i++) {
			System.out.println(ESort[i]);
		}
		
	}

}
