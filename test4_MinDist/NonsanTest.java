package project.test4_MinDist;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NonsanTest {

	public static void main(String[] args) {
		int[][] dist = {
				{0, 9, 22, 34, 21, 67, 87, 51, 79, 80},
				{9, 0, 35, 0, 0, 74, 0, 0, 0, 0},
				{22, 35, 0, 0, 0, 22, 0, 0, 0, 0},
				{34, 0, 0, 0, 33, 0, 42, 0, 0, 0},
				{21, 0, 0, 33, 0, 0, 0, 0, 49, 0},
				{67, 74, 22, 0, 0, 0, 0, 0, 0, 0},
				{87, 0, 0, 42, 0, 0, 0, 0, 0, 0},
				{51, 0, 0, 0, 0, 0, 0, 0, 0, 41},
				{79, 0, 0, 0, 49, 0, 0, 0, 0, 0},
				{80, 0, 0, 0, 0, 0, 0, 41, 0, 0},
		};
		
		int N = dist.length;
		List<Edge>[] adjList = new List[N];
		for(int i =0; i<N; i++) {
			adjList[i] = new LinkedList<>();
			for(int j = 0; j< N; j++) {
				if(dist[i][j] != 0 ) {
					Edge e = new Edge(i,j, dist[i][j]);
					adjList[i].add(e);
				}
			}
		}
		
		DijkstraSP di = new DijkstraSP(adjList);
		System.out.println("0으로 부터 최단거리(논산)");
		int[] distance = di.shortestPath(0); 		//시작 인덱스 0
		
		for(int i = 0; i< distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println(i+"와 연결성분 없음");
			}else {
				System.out.println("(0 => "+i+") = 총 거리 합 : "+ distance[i]);
			}
		}
		Stack<Integer> s = new Stack<>();
		System.out.println("\n정점 0(논산)으로부터의 최단경로");
		
		for(int i = 1; i < di.N; i++) {
			int back = i;
			//System.out.print(back); 
			s.push(back);					//도착값 스택.
			while(back != 0) {
				
				//System.out.print(" <=" + di.previous[back]);
				s.push(di.previous[back]);		//정점의 순서 스택.
				back = di.previous[back];
			}
			System.out.println();
			
			for(int q = 0; q< 10; q++) {
				
				if(!s.isEmpty()) {						//Stack안에 요소가 있으면 pop()실행
					System.out.print("=>"+ s.pop());
				}
			}
			
		}
		
		
		
		
		
	
	}

}
