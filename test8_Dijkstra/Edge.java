package project.test8_Dijkstra;

public class Edge implements Comparable<Edge> {

	static String[] City = {"���","����","���","����","�ο�","����","õ��","����","��õ","�ξ�"};
	// ������ Ŭ���� �ڷ���
	public int fv, tv; //��� ���� ��������
	public int weight; // �Ÿ�
	
	

	Edge() {
		this.fv = 0;
		this.tv = 0;
		this.weight = 0;
	}

	Edge(int a, int b, int length) {
		this.fv = a;
		this.tv = b;
		this.weight = length;
	}

	public String toString(){

		return City[fv]+"->"+City[tv]+" : " + weight+"km";
	}
	
	
	@Override
	public int compareTo(Edge arg0) {
		if (this.weight < arg0.weight) {
			return 1;
		} else if (this.weight == arg0.weight) {
			return 0;
		} else {
			return -1;
		}

	}
	}

