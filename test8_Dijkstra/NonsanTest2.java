package project.test8_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NonsanTest2 {
	static String[] City = { "���", "����", "���", "����", "�ο�", "����", "õ��", "����", "��õ", "�ξ�" };

	public static void main(String[] args) {

		int[][] dist = { { 0, 9, 22, 34, 21, 67, 87, 51, 79, 80 }, { 9, 0, 35, 0, 0, 74, 0, 0, 0, 0 },
				{ 22, 35, 0, 0, 0, 22, 0, 0, 0, 0 }, { 34, 0, 0, 0, 33, 0, 42, 0, 0, 0 },
				{ 21, 0, 0, 33, 0, 0, 0, 0, 49, 0 }, { 67, 74, 22, 0, 0, 0, 0, 0, 0, 0 },
				{ 87, 0, 0, 42, 0, 0, 0, 0, 0, 0 }, { 51, 0, 0, 0, 0, 0, 0, 0, 0, 41 },
				{ 79, 0, 0, 0, 49, 0, 0, 0, 0, 0 }, { 80, 0, 0, 0, 0, 0, 0, 41, 0, 0 }, };

		int N = dist.length;
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (dist[i][j] != 0) {
					Edge e = new Edge(i, j, dist[i][j]);
					adjList[i].add(e);
				}
			}
		}

		DijkstraSP di = new DijkstraSP(adjList);
		Stack<Integer> s = new Stack<>();

		System.out.println("1.�� ���ÿ��� ���ñ��� �ִܰ�ε� �� ���� ū������ 10���� �����Ͻÿ�.");
		CityComparable[] Load = new CityComparable[N];
		for (int i = 0; i < N; i++) {
			int maxver = 0; // �ִܰ�ΰ� ���� ū ���
			int maxIdx = 0; // ū��� ���� �ε���
			int distan = 0; // �Ÿ�
			int back = 0;
			int[] distance = di.shortestPath(i);
			ArrayList<String> AS = new ArrayList<>();

			for (int j = 0; j < N; j++) { // �ִܰ���� �ִ�ã��
				if (maxver < distance[j]) {
					maxver = distance[j];
					distan = maxIdx = j;
				}
			}

			// System.out.print(City[i]); // �ִ��� ���� ��� ����ã�� ���ÿ� push
			AS.add(City[i]);
			while (di.previous[maxIdx] != -1) {
				s.push(maxIdx);
				maxIdx = di.previous[maxIdx];
			}

			for (int st = 0; st < N; st++) { // �������
				if (!s.isEmpty()) {
					AS.add(City[s.pop()]); // AS�迭�� ���ø��� ������� �Է�
					// System.out.print("=>" + City[s.pop()]);
				}
			}

			// System.out.print(" �ѰŸ���:" + maxver + "km");
			// System.out.println();

			Load[i] = new CityComparable(AS, maxver); // ��ü�迭�� CityComparable�� ���ü����� �ѰŸ��� �־���
		}
		System.out.println("");

		Arrays.sort(Load); // ������������ 10�� Sort
		for (int i = 0; i < N; i++) {
			Load[i].printCity();
		}

		// ���� ����

		System.out.println("\n2.�������� �湮�� ��ο� �ѰŸ� ��\n");

		for (int i = 0; i < N; i++) {
			String[] tvFv = new String[2]; // �������� Ȯ���ϱ� ���� CityComparable�� �޼ҵ忡 getBackVer�� ���ϰ��� �ޱ����� �迭
			int fv = 0;
			int tv = 0;
			tvFv = Load[i].getBackVer();

			for (int j = 0; j < N; j++) {
				if (City[j] == tvFv[0]) { // fv�� ����
					fv = j;
				}
				if (City[j] == tvFv[1]) { // tv�� ����
					tv = j;
				}
			}

			int[] distance = di.shortestPath(fv);
			int back = tv;
			while (di.previous[back] != -1) {
				System.out.print(City[back] + "=>");
				back = di.previous[back];
			}
			System.out.print(City[fv] + " �ѰŸ��� :" + distance[tv] + "km");
			System.out.println();
		}

		String k1 = "���� ������";
		String k2 = "�ڿ� �����";
		String k3 = "�޾���";
		String k4 = "����";

		Tourists[] ts = new Tourists[10];

		ts[0] = new Tourists("���");
		ts[1] = new Tourists("����");
		ts[2] = new Tourists("���");
		ts[3] = new Tourists("����");
		ts[4] = new Tourists("�ο�");
		ts[5] = new Tourists("����");
		ts[6] = new Tourists("õ��");
		ts[7] = new Tourists("����");
		ts[8] = new Tourists("��õ");
		ts[9] = new Tourists("�ξ�");
		
		//���
		ts[0].tourist[0] = new ToursInfo("������", k1, 82);
		ts[0].tourist[1] = new ToursInfo("����屺", k1, 80);
		ts[0].tourist[2] = new ToursInfo("���ϼ���", k1, 78);
		ts[0].tourist[3] = new ToursInfo("ž��ȣ", k2, 90);
		ts[0].tourist[4] = new ToursInfo("��л�", k2, 84);
		ts[0].tourist[5] = new ToursInfo("KT&G ��󸶴�", k3, 86);
		ts[0].tourist[6] = new ToursInfo("������ ����ü�� �޾縶��", k3, 84);
		ts[0].tourist[7] = new ToursInfo("��� �����η���", k3, 80);
		ts[0].tourist[8] = new ToursInfo("�ŵ�ȸ��", k4, 84);
		ts[0].tourist[9] = new ToursInfo("��ֵ��", k4, 96);

		// ����

		ts[1].tourist[0] = new ToursInfo("����� ����", k1, 84);
		ts[1].tourist[1] = new ToursInfo("�׸�����", k1, 81);
		ts[1].tourist[2] = new ToursInfo("���� �����", k1, 78);
		ts[1].tourist[3] = new ToursInfo("�������", k2, 86);
		ts[1].tourist[4] = new ToursInfo("���� �ڿ� �޾縲", k2, 85);
		ts[1].tourist[5] = new ToursInfo("���� Ȳ�� ��� ������", k3, 74);
		ts[1].tourist[6] = new ToursInfo("õ�ֱ� ���漺��", k3, 90);
		ts[1].tourist[7] = new ToursInfo("�̳��ٸ�", k3, 89);
		ts[1].tourist[8] = new ToursInfo("���� ���� ����", k4, 87);
		ts[1].tourist[9] = new ToursInfo("���� �ع� Į����", k4, 88);

		// ���
		ts[2].tourist[0] = new ToursInfo("�����", k1, 84);
		ts[2].tourist[1] = new ToursInfo("������", k1, 71);
		ts[2].tourist[2] = new ToursInfo("�Ծϸ� ��������", k1, 68);
		ts[2].tourist[3] = new ToursInfo("����", k2, 87);
		ts[2].tourist[4] = new ToursInfo("���������", k2, 85);
		ts[2].tourist[5] = new ToursInfo("��������ž", k3, 81);
		ts[2].tourist[6] = new ToursInfo("������ ����ȭ �н���", k3, 84);
		ts[2].tourist[7] = new ToursInfo("�ΰ�õ ���°���", k3, 81);
		ts[2].tourist[8] = new ToursInfo("�����", k4, 90);
		ts[2].tourist[9] = new ToursInfo("��簡��", k4, 88);

		// ����
		ts[3].tourist[0] = new ToursInfo("���ɿո�", k1, 84);
		ts[3].tourist[1] = new ToursInfo("���꼺", k1, 82);
		ts[3].tourist[2] = new ToursInfo("���帮 �ڹ���", k1, 80);
		ts[3].tourist[3] = new ToursInfo("Ȳ������", k2, 78);
		ts[3].tourist[4] = new ToursInfo("����õ���°���", k2, 76);
		ts[3].tourist[5] = new ToursInfo("�����ѿ�����", k3, 97);
		ts[3].tourist[6] = new ToursInfo("�������ֹڹ���", k3, 84);
		ts[3].tourist[7] = new ToursInfo("�Ӹ��̼���", k3, 67);
		ts[3].tourist[8] = new ToursInfo("���ؿ�", k4, 75);
		ts[3].tourist[9] = new ToursInfo("������ Į����", k4, 84);

		// �ο�

		ts[4].tourist[0] = new ToursInfo("��������", k1, 84);
		ts[4].tourist[1] = new ToursInfo("�ó���", k1, 84);
		ts[4].tourist[2] = new ToursInfo("�μһ꼺", k1, 81);
		ts[4].tourist[3] = new ToursInfo("��ȭ��", k2, 87);
		ts[4].tourist[4] = new ToursInfo("����� �������", k2, 88);
		ts[4].tourist[5] = new ToursInfo("�ο������ڹ���", k3, 78);
		ts[4].tourist[6] = new ToursInfo("������ȭ����", k3, 96);
		ts[4].tourist[7] = new ToursInfo("�������׸���ũ", k3, 99);
		ts[4].tourist[8] = new ToursInfo("�����ѿ�", k4, 69);
		ts[4].tourist[9] = new ToursInfo("�����̾߱�", k4, 75);

		// ����
		ts[5].tourist[0] = new ToursInfo("�л� ����������", k1, 78);
		ts[5].tourist[1] = new ToursInfo("��������꼺", k1, 67);
		ts[5].tourist[2] = new ToursInfo("���帮 �ڹ���", k1, 87);
		ts[5].tourist[3] = new ToursInfo("���»� �ڿ��޾縲", k2, 88);
		ts[5].tourist[4] = new ToursInfo("������", k2, 79);
		ts[5].tourist[5] = new ToursInfo("���� �ù� õ����", k3, 81);
		ts[5].tourist[6] = new ToursInfo("������", k3, 94);
		ts[5].tourist[7] = new ToursInfo("�ѹ� �����", k3, 84);
		ts[5].tourist[8] = new ToursInfo("���ɴ�", k4, 94);
		ts[5].tourist[9] = new ToursInfo("�ŵ�Į����", k4, 74);

		// õ��

		ts[6].tourist[0] = new ToursInfo("��������", k1, 98);
		ts[6].tourist[1] = new ToursInfo("������ ������", k1, 88);
		ts[6].tourist[2] = new ToursInfo("���������� ����", k1, 97);
		ts[6].tourist[3] = new ToursInfo("������", k2, 81);
		ts[6].tourist[4] = new ToursInfo("õȣ��", k2, 81);
		ts[6].tourist[5] = new ToursInfo("�����̼���", k3, 67);
		ts[6].tourist[6] = new ToursInfo("�����Ǿ�", k3, 96);
		ts[6].tourist[7] = new ToursInfo("ȫ�����а�", k3, 87);
		ts[6].tourist[8] = new ToursInfo("��õ����", k4, 87);
		ts[6].tourist[9] = new ToursInfo("�����߰���", k4, 67);

		// ����
		ts[7].tourist[0] = new ToursInfo("�����", k1, 74);
		ts[7].tourist[1] = new ToursInfo("�����ѿ�����", k1, 97);
		ts[7].tourist[2] = new ToursInfo("ǳ����", k1, 81);
		ts[7].tourist[3] = new ToursInfo("���� �ڿ����°�", k2, 67);
		ts[7].tourist[4] = new ToursInfo("����õ��", k2, 68);
		ts[7].tourist[5] = new ToursInfo("��������", k3, 75);
		ts[7].tourist[6] = new ToursInfo("�ڸ� ��ȭ����", k3, 76);
		ts[7].tourist[7] = new ToursInfo("���� �ڹ���", k3, 78);
		ts[7].tourist[8] = new ToursInfo("������", k4, 79);
		ts[7].tourist[9] = new ToursInfo("���", k4, 82);
		// ��õ

		ts[8].tourist[0] = new ToursInfo("��û ������", k1, 71);
		ts[8].tourist[1] = new ToursInfo("���ֻ���", k1, 84);
		ts[8].tourist[2] = new ToursInfo("�ְ�� ����", k1, 64);
		ts[8].tourist[3] = new ToursInfo("�׵�������", k2, 88);
		ts[8].tourist[4] = new ToursInfo("��â��", k2, 72);
		ts[8].tourist[5] = new ToursInfo("��õ �ؼ�����", k3, 97);
		ts[8].tourist[6] = new ToursInfo("��ź �ڹ���", k3, 88);
		ts[8].tourist[7] = new ToursInfo("��ȭ ��������", k3, 78);
		ts[8].tourist[8] = new ToursInfo("ȭ��� �����Ÿ�", k4, 86);
		ts[8].tourist[9] = new ToursInfo("Ȳ�ؿ�", k4, 88);

		// �ξ�
		ts[9].tourist[0] = new ToursInfo("�ξȼ����ȴ��", k1, 87);
		ts[9].tourist[1] = new ToursInfo("�ݰ輱��������", k1, 84);
		ts[9].tourist[2] = new ToursInfo("������ �����", k1, 74);
		ts[9].tourist[3] = new ToursInfo("ä����", k2, 74);
		ts[9].tourist[4] = new ToursInfo("������", k2, 84);
		ts[9].tourist[5] = new ToursInfo("���ҿ���", k3, 63);
		ts[9].tourist[6] = new ToursInfo("������ �б�", k3, 95);
		ts[9].tourist[7] = new ToursInfo("�ξ� �����׸���ũ", k3, 87);
		ts[9].tourist[8] = new ToursInfo("������", k4, 97);
		ts[9].tourist[9] = new ToursInfo("��ȭ�ڹ�����", k4, 91);
		
		
		String[] key = { "���� ������", "�ڿ� �����", "�޾���", "����"};
		int[] keypoint = new int[4];
		
		for (int i = 0; i < 10; i++) {

			Arrays.sort(ts[i].tourist); // �������� Sorting

			for (int q = 0; q < 5; q++) {					//���� 5���� Ű���忡 ���� ī��Ʈ
				if (ts[i].tourist[q].keyword == k1) {				
					keypoint[0]++;
				} else if (ts[i].tourist[q].keyword == k2) {
					keypoint[1]++;
				} else if (ts[i].tourist[q].keyword == k3) {
					keypoint[2]++;
				} else {
					keypoint[3]++;
				}
			}
		}
		
		System.out.println("\n 10�� ������ ����Ű����");
		int max = 0;
		int maxidx = 0;
		for(int i = 0; i<4; i++) {
			if(max < keypoint[i]) {
				max =keypoint[i];
				maxidx=i;
			}
			System.out.println(key[i] + "�� Ű���� ���� : "+ keypoint[i]+"��");
		}
	
		System.out.print("\n�� ������ ���� Ű����� "+key[maxidx]+"("+keypoint[maxidx]+"��)�Դϴ�.");
	}
}