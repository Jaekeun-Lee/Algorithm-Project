package project.test6_TouristGuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Tourism {
	static String[] City = {"논산","강경","계룡","공주","부여","대전","천안","전주","대천","부안"};

	public static void main(String[]args) {
		
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
		
		int N = dist.length;			//1번
		List<Edge>[] adjList = new LinkedList[N];
		AdjListEdge test = new AdjListEdge();
		adjList = test.convertMtoL(dist, N);
		
		
		DijkstraSP di = new DijkstraSP(adjList);
		int[] distance = new int[N];
		distance = di.shortestPath(0);  	//논산출발 최단도시
		int count = 0;
		
		Attractions[] tourism = new Attractions[100];
		//도시 , 논산으로부터 거리 , 장소 점수
		String k1 = "역사 유적지";
		String k2 = "자연 명승지";
		String k3 = "휴양지";
		String k4 = "맛집";
		//논산으로부터 거리 distance[]
		//논산
		tourism[count++] = new Attractions("논산",distance[0],"관촉사",82);
		tourism[count++] = new Attractions("논산",distance[0],"계백장군",80);
		tourism[count++] = new Attractions("논산",distance[0],"돈암서원",78);
		tourism[count++] = new Attractions("논산",distance[0],"탑정호",90);
		tourism[count++] = new Attractions("논산",distance[0],"대둔산",84);
		tourism[count++] = new Attractions("논산",distance[0],"KT&G 상상마당",86);
		tourism[count++] = new Attractions("논산",distance[0],"덕바위 농촌체험 휴양마을",84);
		tourism[count++] = new Attractions("논산",distance[0],"논산 선샤인 랜드",80);
		tourism[count++] = new Attractions("논산",distance[0],"신동회관",84);
		tourism[count++] = new Attractions("논산",distance[0],"산애들애",96);
		//강경
		tourism[count++] = new Attractions("강경",distance[1],"옥녀봉 공원",84);
		tourism[count++] = new Attractions("강경",distance[1],"죽림서원",81);
		tourism[count++] = new Attractions("강경",distance[1],"강경 역사관",78);
		tourism[count++] = new Attractions("강경",distance[1],"수락계곡",86);
		tourism[count++] = new Attractions("강경",distance[1],"양촌 자연 휴양림",85);
		tourism[count++] = new Attractions("강경",distance[1],"강경 황상 등대 전망대",74);
		tourism[count++] = new Attractions("강경",distance[1],"천주교 강경성당",90);
		tourism[count++] = new Attractions("강경",distance[1],"미내다리",89);
		tourism[count++] = new Attractions("강경",distance[1],"강경 젓갈 시장",87);
		tourism[count++] = new Attractions("강경",distance[1],"강경 해물 칼국수",88);
		//계룡
		tourism[count++] = new Attractions("계룡",distance[2],"무상사",84);
		tourism[count++] = new Attractions("계룡",distance[2],"사계고택",71);
		tourism[count++] = new Attractions("계룡",distance[2],"압암리 유적공원",68);
		tourism[count++] = new Attractions("계룡",distance[2],"계룡산",87);
		tourism[count++] = new Attractions("계룡",distance[2],"계룡저수지",85);
		tourism[count++] = new Attractions("계룡",distance[2],"계룡대통일탑",81);
		tourism[count++] = new Attractions("계룡",distance[2],"과목정 무궁화 학습원",84);
		tourism[count++] = new Attractions("계룡",distance[2],"두계천 생태공원",81);
		tourism[count++] = new Attractions("계룡",distance[2],"계룡면옥",90);
		tourism[count++] = new Attractions("계룡",distance[2],"콩밭가인",88);
		//공주
		tourism[count++] = new Attractions("공주",distance[3],"무령왕릉",84);
		tourism[count++] = new Attractions("공주",distance[3],"공산성",82);
		tourism[count++] = new Attractions("공주",distance[3],"석장리 박물관",80);
		tourism[count++] = new Attractions("공주",distance[3],"황새바위",78);
		tourism[count++] = new Attractions("공주",distance[3],"정안천생태공원",76);
		tourism[count++] = new Attractions("공주",distance[3],"공주한옥마을",97);
		tourism[count++] = new Attractions("공주",distance[3],"국립공주박물관",84);
		tourism[count++] = new Attractions("공주",distance[3],"임립미술관",67);
		tourism[count++] = new Attractions("공주",distance[3],"동해원",75);
		tourism[count++] = new Attractions("공주",distance[3],"유가네 칼국수",84);

		//부여
		tourism[count++] = new Attractions("부여",distance[4],"정림사지",84);
		tourism[count++] = new Attractions("부여",distance[4],"궁남지",84);
		tourism[count++] = new Attractions("부여",distance[4],"부소산성",81);
		tourism[count++] = new Attractions("부여",distance[4],"낙화암",87);
		tourism[count++] = new Attractions("부여",distance[4],"성흥산 사랑나무",88);
		tourism[count++] = new Attractions("부여",distance[4],"부여국립박물관",78);
		tourism[count++] = new Attractions("부여",distance[4],"백제문화단지",96);
		tourism[count++] = new Attractions("부여",distance[4],"서동요테마파크",99);
		tourism[count++] = new Attractions("부여",distance[4],"서동한우",69);
		tourism[count++] = new Attractions("부여",distance[4],"연꽃이야기",75);

		//대전
		tourism[count++] = new Attractions("대전",distance[5],"둔산 선사유적지",78);
		tourism[count++] = new Attractions("대전",distance[5],"대덕계족산성",67);
		tourism[count++] = new Attractions("대전",distance[5],"석장리 박물관",87);
		tourism[count++] = new Attractions("대전",distance[5],"장태산 자연휴양림",88);
		tourism[count++] = new Attractions("대전",distance[5],"보문산",79);
		tourism[count++] = new Attractions("대전",distance[5],"대전 시민 천문대",81);
		tourism[count++] = new Attractions("대전",distance[5],"오월드",94);
		tourism[count++] = new Attractions("대전",distance[5],"한밭 수목원",84);
		tourism[count++] = new Attractions("대전",distance[5],"성심당",94);
		tourism[count++] = new Attractions("대전",distance[5],"신도칼국수",74);

		//천안
		tourism[count++] = new Attractions("천안",distance[6],"독립기념관",98);
		tourism[count++] = new Attractions("천안",distance[6],"태조산 각원사",88);
		tourism[count++] = new Attractions("천안",distance[6],"유관순열사 기념관",97);
		tourism[count++] = new Attractions("천안",distance[6],"광덕산",81);
		tourism[count++] = new Attractions("천안",distance[6],"천호지",81);
		tourism[count++] = new Attractions("천안",distance[6],"리각미술관",67);
		tourism[count++] = new Attractions("천안",distance[6],"쥬쥬피아",96);
		tourism[count++] = new Attractions("천안",distance[6],"홍대용과학관",87);
		tourism[count++] = new Attractions("천안",distance[6],"병천시장",87);
		tourism[count++] = new Attractions("천안",distance[6],"붕붕닭강정",67);

		//전주
		tourism[count++] = new Attractions("전주",distance[7],"경기전",74);
		tourism[count++] = new Attractions("전주",distance[7],"전주한옥마을",97);
		tourism[count++] = new Attractions("전주",distance[7],"풍남문",81);
		tourism[count++] = new Attractions("전주",distance[7],"전주 자연생태관",67);
		tourism[count++] = new Attractions("전주",distance[7],"전주천교",68);
		tourism[count++] = new Attractions("전주",distance[7],"덕진공원",75);
		tourism[count++] = new Attractions("전주",distance[7],"자만 벽화마을",76);
		tourism[count++] = new Attractions("전주",distance[7],"어진 박물관",78);
		tourism[count++] = new Attractions("전주",distance[7],"진미집",79);
		tourism[count++] = new Attractions("전주",distance[7],"고궁",82);

		//대천
		tourism[count++] = new Attractions("대천",distance[8],"충청 수영성",71);
		tourism[count++] = new Attractions("대천",distance[8],"성주사지",84);
		tourism[count++] = new Attractions("대천",distance[8],"최고운 유적",64);
		tourism[count++] = new Attractions("대천",distance[8],"죽도관광지",88);
		tourism[count++] = new Attractions("대천",distance[8],"무창포",72);
		tourism[count++] = new Attractions("대천",distance[8],"대천 해수욕장",97);
		tourism[count++] = new Attractions("대천",distance[8],"석탄 박물관",88);
		tourism[count++] = new Attractions("대천",distance[8],"개화 예술공원",78);
		tourism[count++] = new Attractions("대천",distance[8],"화장골 맛집거리",86);
		tourism[count++] = new Attractions("대천",distance[8],"황해원",88);

		//부안
		tourism[count++] = new Attractions("부안",distance[9],"부안서문안산당",87);
		tourism[count++] = new Attractions("부안",distance[9],"반계선생유적지",84);
		tourism[count++] = new Attractions("부안",distance[9],"선웅사 대웅전",74);
		tourism[count++] = new Attractions("부안",distance[9],"채석강",74);
		tourism[count++] = new Attractions("부안",distance[9],"적벽강",84);
		tourism[count++] = new Attractions("부안",distance[9],"곰소염전",63);
		tourism[count++] = new Attractions("부안",distance[9],"원숭이 학교",95);
		tourism[count++] = new Attractions("부안",distance[9],"부안 영상테마파크",87);
		tourism[count++] = new Attractions("부안",distance[9],"씨윈드",97);
		tourism[count++] = new Attractions("부안",distance[9],"이화자백합죽",91);
		
		
		System.out.println("도시들의 관광명소들의 평가점수를 합산하여 종합평가점수를 출력");
		
		int cityCount = 10;
		int cityCount2 = 0;
		CityScore[] CS = new CityScore[N];
		
		
		for(int i =0; i< N; i++) {						//각 도시마다 종합점수를 더함
			int SumScore = 0;
			for(int j= 0; j<cityCount; j++) {
				SumScore += tourism[cityCount2].rating;
				CS[i] = new CityScore(City[i],SumScore);
				cityCount2++;
			}
		}
		
		Arrays.sort(CS);			//3.종합점수 별 Sort
		
		for(int i=0; i<N; i++) {
			System.out.println(CS[i]);
		}
		
		
		
		
		
		Arrays.sort(tourism);			//4.평가점수 별 Sort
		
		ArrayList<String> AS = new ArrayList<>();
		
		System.out.println("\n종합점수를 기준으로 내림차순으로 정렬하고 상위 10개의 관광 명소를  출력");		//AS배열에 값이 없으면 추가.
		for(int i=0; i<N; i++) {
			System.out.println(tourism[i]);
			if(!AS.contains(tourism[i].City)) {
				AS.add(tourism[i].City);
			}
		}
		
		System.out.print("\n관광명소를 방문하는 도시들은(");				//도시점수 기준 = 키로수별 점수로 50% + 관광명소저뭇 50%
		for(int i= 0; i<AS.size(); i++) {
			System.out.print(AS.get(i)+ " ");
		}
		
		int SumDistance = 0; 
		for(int i= 0; i<AS.size(); i++) {				//원래있는 CIty배열과 찾은 도시와 비교해 일치하면 그 도시의 거리를 더함
			for(int j = 0; j<N; j++) {
				if(AS.get(i)==City[j]) {
					SumDistance += distance[j];			//distance는 이전에 구한 논산으로부터 각도시가지의 최단거리
				}
			}
		}
	
		System.out.println(")이고 이 도시들을 방문하는 경로의 총 거리는 "+SumDistance+"km 입니다");
		
		
	}
}
