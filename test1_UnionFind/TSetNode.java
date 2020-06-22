package project.test1_UnionFind;

public class TSetNode {
	int parent;
	int rank;
	public String name;

	public TSetNode(String name, int newParent, int newRank) {
		parent = newParent;
		rank = newRank;
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
