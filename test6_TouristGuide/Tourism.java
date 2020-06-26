package project.test6_TouristGuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Tourism {
	static String[] City = {"���","����","���","����","�ο�","����","õ��","����","��õ","�ξ�"};

	public static void main(String[]args) {
		
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
		
		int N = dist.length;			//1��
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		
		
		DijkstraSP di = new DijkstraSP(adjList);
		int[] distance = new int[N];
		distance = di.shortestPath(0);  	//������ �ִܵ���
		int count = 0;
		
		Attractions[] tourism = new Attractions[100];
		//���� , ������κ��� �Ÿ� , ��� ����
		String k1 = "���� ������";
		String k2 = "�ڿ� �����";
		String k3 = "�޾���";
		String k4 = "����";
		//������κ��� �Ÿ� distance[]
		//���
		tourism[count++] = new Attractions("���",distance[0],"���˻�",82);
		tourism[count++] = new Attractions("���",distance[0],"����屺",80);
		tourism[count++] = new Attractions("���",distance[0],"���ϼ���",78);
		tourism[count++] = new Attractions("���",distance[0],"ž��ȣ",90);
		tourism[count++] = new Attractions("���",distance[0],"��л�",84);
		tourism[count++] = new Attractions("���",distance[0],"KT&G ��󸶴�",86);
		tourism[count++] = new Attractions("���",distance[0],"������ ����ü�� �޾縶��",84);
		tourism[count++] = new Attractions("���",distance[0],"��� ������ ����",80);
		tourism[count++] = new Attractions("���",distance[0],"�ŵ�ȸ��",84);
		tourism[count++] = new Attractions("���",distance[0],"��ֵ��",96);
		//����
		tourism[count++] = new Attractions("����",distance[1],"����� ����",84);
		tourism[count++] = new Attractions("����",distance[1],"�׸�����",81);
		tourism[count++] = new Attractions("����",distance[1],"���� �����",78);
		tourism[count++] = new Attractions("����",distance[1],"�������",86);
		tourism[count++] = new Attractions("����",distance[1],"���� �ڿ� �޾縲",85);
		tourism[count++] = new Attractions("����",distance[1],"���� Ȳ�� ��� ������",74);
		tourism[count++] = new Attractions("����",distance[1],"õ�ֱ� ���漺��",90);
		tourism[count++] = new Attractions("����",distance[1],"�̳��ٸ�",89);
		tourism[count++] = new Attractions("����",distance[1],"���� ���� ����",87);
		tourism[count++] = new Attractions("����",distance[1],"���� �ع� Į����",88);
		//���
		tourism[count++] = new Attractions("���",distance[2],"�����",84);
		tourism[count++] = new Attractions("���",distance[2],"������",71);
		tourism[count++] = new Attractions("���",distance[2],"�оϸ� ��������",68);
		tourism[count++] = new Attractions("���",distance[2],"����",87);
		tourism[count++] = new Attractions("���",distance[2],"���������",85);
		tourism[count++] = new Attractions("���",distance[2],"��������ž",81);
		tourism[count++] = new Attractions("���",distance[2],"������ ����ȭ �н���",84);
		tourism[count++] = new Attractions("���",distance[2],"�ΰ�õ ���°���",81);
		tourism[count++] = new Attractions("���",distance[2],"�����",90);
		tourism[count++] = new Attractions("���",distance[2],"��簡��",88);
		//����
		tourism[count++] = new Attractions("����",distance[3],"���ɿո�",84);
		tourism[count++] = new Attractions("����",distance[3],"���꼺",82);
		tourism[count++] = new Attractions("����",distance[3],"���帮 �ڹ���",80);
		tourism[count++] = new Attractions("����",distance[3],"Ȳ������",78);
		tourism[count++] = new Attractions("����",distance[3],"����õ���°���",76);
		tourism[count++] = new Attractions("����",distance[3],"�����ѿ�����",97);
		tourism[count++] = new Attractions("����",distance[3],"�������ֹڹ���",84);
		tourism[count++] = new Attractions("����",distance[3],"�Ӹ��̼���",67);
		tourism[count++] = new Attractions("����",distance[3],"���ؿ�",75);
		tourism[count++] = new Attractions("����",distance[3],"������ Į����",84);

		//�ο�
		tourism[count++] = new Attractions("�ο�",distance[4],"��������",84);
		tourism[count++] = new Attractions("�ο�",distance[4],"�ó���",84);
		tourism[count++] = new Attractions("�ο�",distance[4],"�μһ꼺",81);
		tourism[count++] = new Attractions("�ο�",distance[4],"��ȭ��",87);
		tourism[count++] = new Attractions("�ο�",distance[4],"����� �������",88);
		tourism[count++] = new Attractions("�ο�",distance[4],"�ο������ڹ���",78);
		tourism[count++] = new Attractions("�ο�",distance[4],"������ȭ����",96);
		tourism[count++] = new Attractions("�ο�",distance[4],"�������׸���ũ",99);
		tourism[count++] = new Attractions("�ο�",distance[4],"�����ѿ�",69);
		tourism[count++] = new Attractions("�ο�",distance[4],"�����̾߱�",75);

		//����
		tourism[count++] = new Attractions("����",distance[5],"�л� ����������",78);
		tourism[count++] = new Attractions("����",distance[5],"��������꼺",67);
		tourism[count++] = new Attractions("����",distance[5],"���帮 �ڹ���",87);
		tourism[count++] = new Attractions("����",distance[5],"���»� �ڿ��޾縲",88);
		tourism[count++] = new Attractions("����",distance[5],"������",79);
		tourism[count++] = new Attractions("����",distance[5],"���� �ù� õ����",81);
		tourism[count++] = new Attractions("����",distance[5],"������",94);
		tourism[count++] = new Attractions("����",distance[5],"�ѹ� �����",84);
		tourism[count++] = new Attractions("����",distance[5],"���ɴ�",94);
		tourism[count++] = new Attractions("����",distance[5],"�ŵ�Į����",74);

		//õ��
		tourism[count++] = new Attractions("õ��",distance[6],"��������",98);
		tourism[count++] = new Attractions("õ��",distance[6],"������ ������",88);
		tourism[count++] = new Attractions("õ��",distance[6],"���������� ����",97);
		tourism[count++] = new Attractions("õ��",distance[6],"������",81);
		tourism[count++] = new Attractions("õ��",distance[6],"õȣ��",81);
		tourism[count++] = new Attractions("õ��",distance[6],"�����̼���",67);
		tourism[count++] = new Attractions("õ��",distance[6],"�����Ǿ�",96);
		tourism[count++] = new Attractions("õ��",distance[6],"ȫ�����а�",87);
		tourism[count++] = new Attractions("õ��",distance[6],"��õ����",87);
		tourism[count++] = new Attractions("õ��",distance[6],"�غش߰���",67);

		//����
		tourism[count++] = new Attractions("����",distance[7],"�����",74);
		tourism[count++] = new Attractions("����",distance[7],"�����ѿ�����",97);
		tourism[count++] = new Attractions("����",distance[7],"ǳ����",81);
		tourism[count++] = new Attractions("����",distance[7],"���� �ڿ����°�",67);
		tourism[count++] = new Attractions("����",distance[7],"����õ��",68);
		tourism[count++] = new Attractions("����",distance[7],"��������",75);
		tourism[count++] = new Attractions("����",distance[7],"�ڸ� ��ȭ����",76);
		tourism[count++] = new Attractions("����",distance[7],"���� �ڹ���",78);
		tourism[count++] = new Attractions("����",distance[7],"������",79);
		tourism[count++] = new Attractions("����",distance[7],"���",82);

		//��õ
		tourism[count++] = new Attractions("��õ",distance[8],"��û ������",71);
		tourism[count++] = new Attractions("��õ",distance[8],"���ֻ���",84);
		tourism[count++] = new Attractions("��õ",distance[8],"�ְ�� ����",64);
		tourism[count++] = new Attractions("��õ",distance[8],"�׵�������",88);
		tourism[count++] = new Attractions("��õ",distance[8],"��â��",72);
		tourism[count++] = new Attractions("��õ",distance[8],"��õ �ؼ�����",97);
		tourism[count++] = new Attractions("��õ",distance[8],"��ź �ڹ���",88);
		tourism[count++] = new Attractions("��õ",distance[8],"��ȭ ��������",78);
		tourism[count++] = new Attractions("��õ",distance[8],"ȭ��� �����Ÿ�",86);
		tourism[count++] = new Attractions("��õ",distance[8],"Ȳ�ؿ�",88);

		//�ξ�
		tourism[count++] = new Attractions("�ξ�",distance[9],"�ξȼ����Ȼ��",87);
		tourism[count++] = new Attractions("�ξ�",distance[9],"�ݰ輱��������",84);
		tourism[count++] = new Attractions("�ξ�",distance[9],"������ �����",74);
		tourism[count++] = new Attractions("�ξ�",distance[9],"ä����",74);
		tourism[count++] = new Attractions("�ξ�",distance[9],"������",84);
		tourism[count++] = new Attractions("�ξ�",distance[9],"���ҿ���",63);
		tourism[count++] = new Attractions("�ξ�",distance[9],"������ �б�",95);
		tourism[count++] = new Attractions("�ξ�",distance[9],"�ξ� �����׸���ũ",87);
		tourism[count++] = new Attractions("�ξ�",distance[9],"������",97);
		tourism[count++] = new Attractions("�ξ�",distance[9],"��ȭ�ڹ�����",91);
		
		
		System.out.println("���õ��� ������ҵ��� �������� �ջ��Ͽ� ������������ ���");
		
		int cityCount = 10;
		int cityCount2 = 0;
		CityScore[] CS = new CityScore[N];
		
		
		for(int i =0; i< N; i++) {						//�� ���ø��� ���������� ����
			int SumScore = 0;
			for(int j= 0; j<cityCount; j++) {
				SumScore += tourism[cityCount2].rating;
				CS[i] = new CityScore(City[i],SumScore);
				cityCount2++;
			}
		}
		
		Arrays.sort(CS);			//3.�������� �� Sort
		
		for(int i=0; i<N; i++) {
			System.out.println(CS[i]);
		}
		
		
		
		
		
		Arrays.sort(tourism);			//4.������ �� Sort
		
		ArrayList<String> AS = new ArrayList<>();
		
		System.out.println("\n���������� �������� ������������ �����ϰ� ���� 10���� ���� ��Ҹ�  ���");		//AS�迭�� ���� ������ �߰�.
		for(int i=0; i<N; i++) {
			System.out.println(tourism[i]);
			if(!AS.contains(tourism[i].City)) {
				AS.add(tourism[i].City);
			}
		}
		
		System.out.print("\n������Ҹ� �湮�ϴ� ���õ���(");				//�������� ���� = Ű�μ��� ������ 50% + ����������� 50%
		for(int i= 0; i<AS.size(); i++) {
			System.out.print(AS.get(i)+ " ");
		}
		
		int SumDistance = 0; 
		for(int i= 0; i<AS.size(); i++) {				//�����ִ� CIty�迭�� ã�� ���ÿ� ���� ��ġ�ϸ� �� ������ �Ÿ��� ����
			for(int j = 0; j<N; j++) {
				if(AS.get(i)==City[j]) {
					SumDistance += distance[j];			//distance�� ������ ���� ������κ��� �����ð����� �ִܰŸ�
				}
			}
		}
	
		System.out.println(")�̰� �� ���õ��� �湮�ϴ� ����� �� �Ÿ��� "+SumDistance+"km �Դϴ�");
		
		
	}
}
