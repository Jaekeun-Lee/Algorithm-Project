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

		System.out.println("1. 예제 그림의 c,b,a,h원소로 된 집합 트리를 만든다."); // 1번

		for (int i = 0; i < 4; i++) {
			TF.printSet(A[i], name[i]);
		}
		System.out.println("\n");

		System.out.println("2. 예제 그림의 e,d,f,g 원소로 된 집합 트리를 만든다."); // 2번

		for (int i = 4; i < 8; i++) {
			TF.printSet(A[i], name[i]);
		}
		System.out.println("\n");

		int num; // 3, 4번
		int num2;

		System.out.println("3. a원소 노드가 있는 집합을 찾아낸다.");		//3번
		num = TF.find(2);
		System.out.println("a원소는 루트 원소가 " + TF.a[num] + "인 집합에 있습니다.\n");

		System.out.println("4. f원소 노드가 있는 집합을 찾아낸다.");		//4번
		num2 = TF.find(6);
		System.out.println("f원소는 루트 원소가 " + TF.a[num2] + "인 집합에 있습니다.\n");

		
		System.out.println("5. 두 집합의 합집합을 만들어 원소들을 출력한다.");
		TF.union(0, 4);						//5번
		for(int i = 0; i < A.length; i++) {
			TF.printSet(A[i], name[i]);
		}System.out.println("\n");
		
		
		System.out.println("6.a원소가 있는 집합을 찾아낸다.");		//6번
		int num3 = TF.find(2);
		System.out.println("a원소는 루트 원소가"+ TF.a[num3]+"인 집합에 있습니다.");
		
		
		
		
		
		
		
		
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * for(int i = 0; i < B.length; i++) {
		 * System.out.print("("+TF2.a[TF2.a[i].parent]+ "," + TF2.a[i].name + ") " ); }
		 * /////////2번끝 System.out.println("\n");
		 * 
		 * 
		 * int num; //3, 4번 int num2;
		 * 
		 * num = TF.find(2); num2 = TF2.find(2);
		 * System.out.println("3. a원소 노드가 있는 집합을 찾아낸다.");
		 * 
		 * if(num == 0 && TF.a[2].name == "a") {
		 * System.out.println("a원소는 루트 원소가 "+TF.a[0]+"인 집합에 있습니다.\n"); }
		 * 
		 * System.out.println("4. f원소 노드가 있는 집합을 찾아낸다."); if(num == 0 && TF2.a[2].name
		 * == "f") { System.out.println("f원소는 루트 원소가 "+ TF2.a[0]+"인 집합에 있습니다.\n");
		 * }///3,4번 끝
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
