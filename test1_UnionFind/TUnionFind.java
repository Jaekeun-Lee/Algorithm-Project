package project.test1_UnionFind;

public class TUnionFind {

	public TSetNode[] a;

	public TUnionFind(TSetNode[] Tset) { // 생성자
		a = Tset;
		for (int i = 0; i < a.length; i++)
			a[i] = new TSetNode(Tset[i].name ,Tset[i].parent, 0);
		// 초기에 모든 노드는 자신을 부모로 하고 rank는 0 인 단일 노드의 집합으로 구성됨
	}

	// i가 속한 집합의 루트 노드를 재귀적으로 찾고 최종적으로 경로상의 각 원소의 부모를 루트 노드로 만든다.
	protected int find(int i) { // 경로 압축
		if (i != a[i].parent)
			a[i].parent = find(a[i].parent); // 리턴하며 경로상의 각 노드의 부모가 루트가되게 만든다.
		return a[i].parent;
	}

	public void union(int i, int j) { // Union 연산, i 부모, j 자식
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot)
			return; // 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴
		// rank가 높은 루트 노드가 승자가 된다.
		if (a[iroot].rank > a[jroot].rank) {
			a[jroot].parent = iroot; // iroot가 승자
			System.out.println(a[iroot] +"원소 집합에 통합되었습니다.");
		}else if (a[iroot].rank < a[jroot].rank) {
			
			if (a[iroot].rank == 0) {
				a[iroot].rank = a[jroot].rank + 1; // start of link
				a[j].parent = i;
			} else {
				a[iroot].parent = jroot; // jroot가 승자
				System.out.println(a[jroot] +"원소 집합에 통합되었습니다.");
			}
		} else {
			a[jroot].parent = iroot; // 둘중에 하나 임의로 승자
			a[iroot].rank++; // iroot의 rank 1 증가
			System.out.println(a[iroot] +"원소 집합에 통합되었습니다.");
		}
	}

	void printSet(TSetNode A, String name) {
		System.out.print("("+a[A.parent]+"," + A.name+ ") ");
		
		
	}

}
