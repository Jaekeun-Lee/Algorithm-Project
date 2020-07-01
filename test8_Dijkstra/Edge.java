package project.test8_Dijkstra;

public class Edge implements Comparable<Edge> {

	static String[] City = {"논산","강경","계룡","공주","부여","대전","천안","전주","대천","부안"};
	// 간선의 클래스 자료형
	public int fv, tv; //출발 도시 도착도시
	public int weight; // 거리
	
	

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

