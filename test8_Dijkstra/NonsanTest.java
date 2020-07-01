package project.test8_Dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NonsanTest {
	static String[] City = {"논산","강경","계룡","공주","부여","대전","천안","전주","대천","부안"};
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
		Stack<Integer> s = new Stack<>();
		Edge[] ESort = new Edge[N];
		
		
		 		//시작 인덱스 0
		
		/* for(int i = 0; i< distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println(i+"와 연결성분 없음");
			}else {
				System.out.println("(0 => "+i+") = 총 거리 합 : "+ distance[i]);
			}
		}
		
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
					System.out.print(City[s.pop()]+"=>");
				}
			}
		}
		*/
		
		System.out.println("최단거리 도시");
		for(int i = 0; i < N; i++) {				//최단거리 , 거리경로, 경로도시
			int min=10000;
			int max=0;
			int minver = 0;		
			int Fromver = 0;	//fv
			int Tover = 0;		//tv
			
			
			int[] distance = di.shortestPath(i);
			
			for(int j=0; j<N; j++) {					
				if(distance[j] < min && distance[j] != 0) {
					min = distance[j];
					Tover = minver = j;
					Fromver =i;
				}else if(distance[j]> max) {
					max = distance[j];
				}
			}
			ESort[i] = new Edge(Fromver, Tover, min);			//sort를 위해 fv tv 가중치를 엣지형배열에 저장
			System.out.println(City[i]+"으로 부터 최단거리 도시는 "+ City[minver]+"이고 거리는 "+ min+"km 입니다.");
			
			while(di.previous[minver] != -1) {
				
				if(di.previous[minver] != 0) {
					s.push(minver);
					minver = di.previous[minver];
				}else if(di.previous[minver] == 0 && di.previous[0] == -1) {
					s.push(minver);
					break;
				}
			}
			
			for(int q = 0; q< 10; q++) {
				if(!s.isEmpty()) {						//Stack안에 요소가 있으면 pop()실행
					System.out.println("최단경로: "+City[i]+ "=>"+City[s.pop()]);
				}
			}
				
			System.out.println();

		}
		
		Arrays.sort(ESort);
		
		System.out.println("최단 경로의 거리가 큰 순서 10개");
		for(int i = 0; i<N; i++) {
			System.out.println(ESort[i]);
		}
		
	}

}
