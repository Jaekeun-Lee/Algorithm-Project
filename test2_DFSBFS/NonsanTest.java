package project.test2_DFSBFS;

import java.util.LinkedList;
import java.util.List;




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
		System.out.println("1.논산 주변의 10개 도시의 연결 도로망을 간선 중심의 인접리스트로 그래프를 표현");
		int N = dist.length;			//1번
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		test.printAdjList(adjList);
		
		
		
		/* 
		.tourist[].name="";
		.tourist[].keyword="";
		.tourist[].count=4;
		*/
		Tourists Nonsan = new Tourists("논산");
		Tourists Gang = new Tourists("강경");
		Tourists Gye = new Tourists("계룡");
		Tourists Gong = new Tourists("공주");
		Tourists Buyeo = new Tourists("부여");
		Tourists DaeJeon = new Tourists("대전");
		Tourists Cheon = new Tourists("천안");
		Tourists JeonJu = new Tourists("전주");
		Tourists DaeCheon = new Tourists("대천");
		Tourists Buan = new Tourists("부안");
		
		
		//논산
		String k1 = "역사 유적지";
		String k2 = "자연 명승지";
		String k3 = "휴양지";
		String k4 = "맛집";
	
		
		Nonsan.tourist[0] = new ToursInfo("관측사", k1, 82);
	      Nonsan.tourist[1] = new ToursInfo("계백장군", k1, 80);
	      Nonsan.tourist[2] = new ToursInfo("돈암서원", k1, 78);
	      Nonsan.tourist[3] = new ToursInfo("탑정호", k2, 90);
	      Nonsan.tourist[4] = new ToursInfo("대둔산",k2,84);
	      Nonsan.tourist[5] = new ToursInfo("KT&G 상상마당",k3,86);
	      Nonsan.tourist[6] = new ToursInfo("덕바위 농촌체험 휴양마을",k3,84);
	      Nonsan.tourist[7] = new ToursInfo("논산 선샤인랜드",k3,80);
	      Nonsan.tourist[8] = new ToursInfo("신동회관",k4,84);
	      Nonsan.tourist[9] = new ToursInfo("산애들애",k4,96);
	      

	      //강경 
	      
	      Gang.tourist[0] = new ToursInfo("옥녀봉 공원", k1, 84);
	      Gang.tourist[1] = new ToursInfo("죽림서원", k1, 81);
	      Gang.tourist[2] = new ToursInfo("강경 역사관", k1, 78);
	      Gang.tourist[3] = new ToursInfo("수락계곡", k2, 86);
	      Gang.tourist[4] = new ToursInfo("양촌 자연 휴양림", k2, 85);
	      Gang.tourist[5] = new ToursInfo("강경 황산 등대 전망대", k3, 74);
	      Gang.tourist[6] = new ToursInfo("천주교 강경성당", k3, 90);
	      Gang.tourist[7] = new ToursInfo("미내다리", k3, 89);
	      Gang.tourist[8] = new ToursInfo("강경 젓갈 시장", k4, 87);
	      Gang.tourist[9] = new ToursInfo("강경 해물 칼국수", k4, 88);

	      //계룡
	      Gye.tourist[0] = new ToursInfo("무상사",k1,84);
	      Gye.tourist[1] = new ToursInfo("사계고택",k1,71);
	      Gye.tourist[2] = new ToursInfo("입암리 유적공원",k1,68);
	      Gye.tourist[3] = new ToursInfo("계룡산",k2,87);
	      Gye.tourist[4] = new ToursInfo("계룡저수지",k2,85);
	      Gye.tourist[5] = new ToursInfo("계룡대통일탑",k3,81);
	      Gye.tourist[6] = new ToursInfo("과목정 무궁화 학습원",k3,84);
	      Gye.tourist[7] = new ToursInfo("두계천 생태공원",k3,81);
	      Gye.tourist[8] = new ToursInfo("계룡면옥",k4,90);
	      Gye.tourist[9] = new ToursInfo("콩밭가인",k4,88);
	      
	      //공주
	      Gong.tourist[0] = new ToursInfo("무령왕릉", k1, 84);
	      Gong.tourist[1] = new ToursInfo("공산성", k1, 82);
	      Gong.tourist[2] = new ToursInfo("석장리 박물관", k1, 80);
	      Gong.tourist[3] = new ToursInfo("황새바위", k2, 78);
	      Gong.tourist[4] = new ToursInfo("정안천생태공원", k2, 76);
	      Gong.tourist[5] = new ToursInfo("공주한옥마을", k3, 97);
	      Gong.tourist[6] = new ToursInfo("국립공주박물관", k3, 84);
	      Gong.tourist[7] = new ToursInfo("임립미술관", k3, 67);
	      Gong.tourist[8] = new ToursInfo("동해원", k4, 75);
	      Gong.tourist[9] = new ToursInfo("유가네 칼국수", k4, 84);
	      
	      //부여
	      
	      Buyeo.tourist[0] = new ToursInfo("정림사지",k1 ,84);
	      Buyeo.tourist[1] = new ToursInfo("궁남지",k1 ,84);
	      Buyeo.tourist[2] = new ToursInfo("부소산성", k1,81);
	      Buyeo.tourist[3] = new ToursInfo("낙화암", k2,87);
	      Buyeo.tourist[4] = new ToursInfo("성흔산 사랑나무", k2,88);
	      Buyeo.tourist[5] = new ToursInfo("부여국립박물관", k3 ,78);
	      Buyeo.tourist[6] = new ToursInfo("백제문화단지", k3,96);
	      Buyeo.tourist[7] = new ToursInfo("서동요테마파크", k3,99);
	      Buyeo.tourist[8] = new ToursInfo("서동한우", k4,69);
	      Buyeo.tourist[9] = new ToursInfo("연꽃이야기", k4,75);
	      
	      

	      //대전
	      DaeJeon.tourist[0] = new ToursInfo("둔산 선사유적지", k1, 78);
	      DaeJeon.tourist[1] = new ToursInfo("대덕계족산성", k1, 67);
	      DaeJeon.tourist[2] = new ToursInfo("석장리 박물관", k1, 87);
	      DaeJeon.tourist[3] = new ToursInfo("장태산 자연휴양림", k2, 88);
	      DaeJeon.tourist[4] = new ToursInfo("보문산", k2, 79);
	      DaeJeon.tourist[5] = new ToursInfo("대전 시민 천문대", k3, 81);
	      DaeJeon.tourist[6] = new ToursInfo("오월드", k3, 94);
	      DaeJeon.tourist[7] = new ToursInfo("한밭 수목원", k3, 84);
	      DaeJeon.tourist[8] = new ToursInfo("성심당", k4, 94);
	      DaeJeon.tourist[9] = new ToursInfo("신도칼국수", k4, 74);

	      //천안
	      
	      Cheon.tourist[0] = new ToursInfo("독립기념관" ,k1 ,98);
	      Cheon.tourist[1] = new ToursInfo("태조산 각원사" ,k1 ,88);
	      Cheon.tourist[2] = new ToursInfo("유관순열사 기념관" ,k1 ,97);
	      Cheon.tourist[3] = new ToursInfo("광덕산" ,k2 ,81);
	      Cheon.tourist[4] = new ToursInfo("천호지" ,k2 ,81);
	      Cheon.tourist[5] = new ToursInfo("리각미술관" ,k3 ,67);
	      Cheon.tourist[6] = new ToursInfo("쥬쥬피아" ,k3 ,96);
	      Cheon.tourist[7] = new ToursInfo("홍대용과학관" ,k3 ,87);
	      Cheon.tourist[8] = new ToursInfo("병천시장" ,k4 ,87);
	      Cheon.tourist[9] = new ToursInfo("봉봉닭강정" ,k4 ,67);

	      //전주
	      JeonJu.tourist[0] = new ToursInfo("경기전", k1, 74);
	      JeonJu.tourist[1] = new ToursInfo("전주한옥마을", k1, 97);
	      JeonJu.tourist[2] = new ToursInfo("풍남문", k1, 81);
	      JeonJu.tourist[3] = new ToursInfo("전주 자연생태관", k2, 67);
	      JeonJu.tourist[4] = new ToursInfo("전주천교", k2, 68);
	      JeonJu.tourist[5] = new ToursInfo("덕진공원", k3, 75);
	      JeonJu.tourist[6] = new ToursInfo("자만 벽화마을", k3, 76);
	      JeonJu.tourist[7] = new ToursInfo("어진 박물관", k3, 78);
	      JeonJu.tourist[8] = new ToursInfo("진미집", k4, 79);
	      JeonJu.tourist[9] = new ToursInfo("고궁", k4, 82);
	      //대천
	      
	      DaeCheon.tourist[0] = new ToursInfo("충청 수영성" ,k1 ,71);
	      DaeCheon.tourist[1] = new ToursInfo("성주사지" ,k1 ,84);
	      DaeCheon.tourist[2] = new ToursInfo("최고운 유적" ,k1 ,64);
	      DaeCheon.tourist[3] = new ToursInfo("죽도관광지" ,k2 ,88);
	      DaeCheon.tourist[4] = new ToursInfo("무창포" , k2,72);
	      DaeCheon.tourist[5] = new ToursInfo("대천 해수욕장" , k3,97);
	      DaeCheon.tourist[6] = new ToursInfo("석탄 박물관" , k3,88);
	      DaeCheon.tourist[7] = new ToursInfo("개화 예술공원" , k3,78);
	      DaeCheon.tourist[8] = new ToursInfo("화장골 맛집거리" , k4,86);
	      DaeCheon.tourist[9] = new ToursInfo("황해원" , k4,88);


	      //부안
	      Buan.tourist[0] = new ToursInfo("부안서문안당산", k1, 87);
	      Buan.tourist[1] = new ToursInfo("반계선생유적지", k1, 84);
	      Buan.tourist[2] = new ToursInfo("선웅사 대웅전", k1, 74);
	      Buan.tourist[3] = new ToursInfo("채석강", k2, 74);
	      Buan.tourist[4] = new ToursInfo("적벽강", k2, 84);
	      Buan.tourist[5] = new ToursInfo("곰소염전", k3, 63);
	      Buan.tourist[6] = new ToursInfo("원숭이 학교", k3, 95);
	      Buan.tourist[7] = new ToursInfo("부안 영상테마파크", k3, 87);
	      Buan.tourist[8] = new ToursInfo("씨윈드", k4, 97);
	      Buan.tourist[9] = new ToursInfo("이화자백합죽", k4, 91);
		
		
		int[] d = new int[N];				//dfs,bfs를 위한 배열
		int sum = 0;
		System.out.print("DFS 인덱스 순서=> ");													//dfs,bfs 선언.
		DFS dfs = new DFS(adjList);			//dfs
		System.out.print("\nBFS 인덱스 순서=> ");
		BFS bfs = new BFS(adjList);			//bfs
		
		
		
		System.out.println("\n2.DFS 탐색으로 생성한 “도시 관광 순서도”와 경로를 모두 합한 “여행 거리”를 출력하시오.");
		for(int i= 0; i < N; i++) {
			d[i] = dfs.adj.remove();		//dfs 도시 순회 순서
			System.out.print(City[d[i]] + "=> ");
		}
		
		
		
		DijkstraSP di = new DijkstraSP(adjList);				//dfs 이동거리 구함 (다익스트라 사용)
		for(int i = 0; i < d.length -1; i++) {
			int[] distance = di.shortestPath(d[i]);
				sum += distance[d[i+1]];
		}
		System.out.println("DFS 총 여행거리는 "+ sum+ "입니다.\n"); 
		
		
		
		  System.out.println("\n3.BFS 탐색으로 생성한 “도시 관광 순서도”와 경로를 모두 합한 “여행 거리”를 출력하시오."
		  ); sum = 0;
		  
		 
		  for(int i= 0; i < N; i++) {
			d[i] = bfs.adj.remove(); //bfs 도시 순회 순서
		  	System.out.print(City[d[i]] + "=> "); 
		  } 
		  
		  for(int i = 0; i < d.length -1; i++) {					//bfs 이동거리 (다익스트라사용)
				int[] distance = di.shortestPath(d[i]);
					sum += distance[d[i+1]];
			}
			System.out.println("BFS 총 여행거리는 "+ sum+ "입니다.\n"); 
		  

			
			
			
		  /* for(int i = 0; i < N-1; i++) {		//2번 dfs 여행거리
			sum += dist[d[i]][d[i+1]];	
	    	}
		 System.out.println("DFS 총 여행거리는 "+ sum+ "입니다.\n"); */ 
		  
		 /* System.out.println("BFS 총 여행거리는 "+ sum+"입니다.\n"); */

		 //텀프로젝트 9번 문제

	}


}
