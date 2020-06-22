package project.test1_UnionFind;

public class TUnionFind {

	public TSetNode[] a;

	public TUnionFind(TSetNode[] Tset) { // ������
		a = Tset;
		for (int i = 0; i < a.length; i++)
			a[i] = new TSetNode(Tset[i].name ,Tset[i].parent, 0);
		// �ʱ⿡ ��� ���� �ڽ��� �θ�� �ϰ� rank�� 0 �� ���� ����� �������� ������
	}

	// i�� ���� ������ ��Ʈ ��带 ��������� ã�� ���������� ��λ��� �� ������ �θ� ��Ʈ ���� �����.
	protected int find(int i) { // ��� ����
		if (i != a[i].parent)
			a[i].parent = find(a[i].parent); // �����ϸ� ��λ��� �� ����� �θ� ��Ʈ���ǰ� �����.
		return a[i].parent;
	}

	public void union(int i, int j) { // Union ����, i �θ�, j �ڽ�
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot)
			return; // ��Ʈ ��尡 �����ϸ� ���̻��� ������� �״�� ����
		// rank�� ���� ��Ʈ ��尡 ���ڰ� �ȴ�.
		if (a[iroot].rank > a[jroot].rank) {
			a[jroot].parent = iroot; // iroot�� ����
			System.out.println(a[iroot] +"���� ���տ� ���յǾ����ϴ�.");
		}else if (a[iroot].rank < a[jroot].rank) {
			
			if (a[iroot].rank == 0) {
				a[iroot].rank = a[jroot].rank + 1; // start of link
				a[j].parent = i;
			} else {
				a[iroot].parent = jroot; // jroot�� ����
				System.out.println(a[jroot] +"���� ���տ� ���յǾ����ϴ�.");
			}
		} else {
			a[jroot].parent = iroot; // ���߿� �ϳ� ���Ƿ� ����
			a[iroot].rank++; // iroot�� rank 1 ����
			System.out.println(a[iroot] +"���� ���տ� ���յǾ����ϴ�.");
		}
	}

	void printSet(TSetNode A, String name) {
		System.out.print("("+a[A.parent]+"," + A.name+ ") ");
		
		
	}

}
