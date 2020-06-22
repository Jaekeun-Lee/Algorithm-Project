package project.test1_UnionFind;

import java.util.Scanner;

public class TreeUnionFind {

	public static void main(String[] argh) {
		Scanner s = new Scanner(System.in);
		String name[] = { "c", "b", "a", "h", "e", "d", "f", "g" };
		TSetNode[] A = new TSetNode[8];

		TSetNode c = new TSetNode("c", 0, 0);
		TSetNode b = new TSetNode("b", 0, 0);
		TSetNode a = new TSetNode("a", 1, 0);
		TSetNode h = new TSetNode("h", 0, 0);
		TSetNode e = new TSetNode("e", 4, 0);
		TSetNode d = new TSetNode("d", 4, 0);
		TSetNode f = new TSetNode("f", 4, 0);
		TSetNode g = new TSetNode("g", 4, 0);

		A[0] = c;
		A[1] = b;
		A[2] = a;
		A[3] = h;
		A[4] = e;
		A[5] = d;
		A[6] = f;
		A[7] = g;

		TUnionFind TF = new TUnionFind(A);

		System.out.println("1. ���� �׸��� c,b,a,h���ҷ� �� ���� Ʈ���� �����."); // 1��

		for (int i = 0; i < 4; i++) {
			TF.printSet(A[i], name[i]);
		}
		System.out.println("\n");

		System.out.println("2. ���� �׸��� e,d,f,g ���ҷ� �� ���� Ʈ���� �����."); // 2��

		for (int i = 4; i < 8; i++) {
			TF.printSet(A[i], name[i]);
		}
		System.out.println("\n");

		int num; // 3, 4��
		int num2;

		System.out.println("3. a���� ��尡 �ִ� ������ ã�Ƴ���.");		//3��
		num = TF.find(2);
		System.out.println("a���Ҵ� ��Ʈ ���Ұ� " + TF.a[num] + "�� ���տ� �ֽ��ϴ�.\n");

		System.out.println("4. f���� ��尡 �ִ� ������ ã�Ƴ���.");		//4��
		num2 = TF.find(6);
		System.out.println("f���Ҵ� ��Ʈ ���Ұ� " + TF.a[num2] + "�� ���տ� �ֽ��ϴ�.\n");

		
		System.out.println("5. �� ������ �������� ����� ���ҵ��� ����Ѵ�.");
		TF.union(0, 4);						//5��
		for(int i = 0; i < A.length; i++) {
			TF.printSet(A[i], name[i]);
		}System.out.println("\n");
		
		
		System.out.println("6.a���Ұ� �ִ� ������ ã�Ƴ���.");		//6��
		int num3 = TF.find(2);
		System.out.println("a���Ҵ� ��Ʈ ���Ұ�"+ TF.a[num3]+"�� ���տ� �ֽ��ϴ�.");
		
		
		
		
		
		
		
		
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * for(int i = 0; i < B.length; i++) {
		 * System.out.print("("+TF2.a[TF2.a[i].parent]+ "," + TF2.a[i].name + ") " ); }
		 * /////////2���� System.out.println("\n");
		 * 
		 * 
		 * int num; //3, 4�� int num2;
		 * 
		 * num = TF.find(2); num2 = TF2.find(2);
		 * System.out.println("3. a���� ��尡 �ִ� ������ ã�Ƴ���.");
		 * 
		 * if(num == 0 && TF.a[2].name == "a") {
		 * System.out.println("a���Ҵ� ��Ʈ ���Ұ� "+TF.a[0]+"�� ���տ� �ֽ��ϴ�.\n"); }
		 * 
		 * System.out.println("4. f���� ��尡 �ִ� ������ ã�Ƴ���."); if(num == 0 && TF2.a[2].name
		 * == "f") { System.out.println("f���Ҵ� ��Ʈ ���Ұ� "+ TF2.a[0]+"�� ���տ� �ֽ��ϴ�.\n");
		 * }///3,4�� ��
		 * 
		 * 
		 * TF.u
		 * 
		 * 
		 * 
		 * for(int i = 0; i < A.length; i++) { System.out.println(TF.a[i]); }
		 * 
		 */

	}

}
