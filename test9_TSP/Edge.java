package project.test9_TSP;

public class Edge {

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
}
