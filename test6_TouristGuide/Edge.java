package project.test6_TouristGuide;

public class Edge {

	// 간선의 클래스 자료형
	int fv, tv; //출발 도시 도착도시
	int weight; // 거리
	
	

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
