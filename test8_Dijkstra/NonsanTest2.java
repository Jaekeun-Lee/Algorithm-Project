package project.test8_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NonsanTest2 {
	static String[] City = { "논산", "강경", "계룡", "공주", "부여", "대전", "천안", "전주", "대천", "부안" };

	public static void main(String[] args) {

		int[][] dist = { { 0, 9, 22, 34, 21, 67, 87, 51, 79, 80 }, { 9, 0, 35, 0, 0, 74, 0, 0, 0, 0 },
				{ 22, 35, 0, 0, 0, 22, 0, 0, 0, 0 }, { 34, 0, 0, 0, 33, 0, 42, 0, 0, 0 },
				{ 21, 0, 0, 33, 0, 0, 0, 0, 49, 0 }, { 67, 74, 22, 0, 0, 0, 0, 0, 0, 0 },
				{ 87, 0, 0, 42, 0, 0, 0, 0, 0, 0 }, { 51, 0, 0, 0, 0, 0, 0, 0, 0, 41 },
				{ 79, 0, 0, 0, 49, 0, 0, 0, 0, 0 }, { 80, 0, 0, 0, 0, 0, 0, 41, 0, 0 }, };

		int N = dist.length;
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (dist[i][j] != 0) {
					Edge e = new Edge(i, j, dist[i][j]);
					adjList[i].add(e);
				}
			}
		}

		DijkstraSP di = new DijkstraSP(adjList);
		Stack<Integer> s = new Stack<>();

		System.out.println("1.각 도시에서 도시까지 최단경로들 중 가장 큰값부터 10개를 나열하시오.");
		CityComparable[] Load = new CityComparable[N];
		for (int i = 0; i < N; i++) {
			int maxver = 0; // 최단경로가 가장 큰 경로
			int maxIdx = 0; // 큰경로 정점 인덱스
			int distan = 0; // 거리
			int back = 0;
			int[] distance = di.shortestPath(i);
			ArrayList<String> AS = new ArrayList<>();

			for (int j = 0; j < N; j++) { // 최단경로중 최댓값찾기
				if (maxver < distance[j]) {
					maxver = distance[j];
					distan = maxIdx = j;
				}
			}

			// System.out.print(City[i]); // 최댓값을 가진 경로 도시찾고 스택에 push
			AS.add(City[i]);
			while (di.previous[maxIdx] != -1) {
				s.push(maxIdx);
				maxIdx = di.previous[maxIdx];
			}

			for (int st = 0; st < N; st++) { // 스택출력
				if (!s.isEmpty()) {
					AS.add(City[s.pop()]); // AS배열에 도시명을 순서대로 입력
					// System.out.print("=>" + City[s.pop()]);
				}
			}

			// System.out.print(" 총거리는:" + maxver + "km");
			// System.out.println();

			Load[i] = new CityComparable(AS, maxver); // 객체배열에 CityComparable에 도시순서와 총거리를 넣어줌
		}
		System.out.println("");

		Arrays.sort(Load); // 내림차순으로 10개 Sort
		for (int i = 0; i < N; i++) {
			Load[i].printCity();
		}

		// 역순 인증

		System.out.println("\n2.역순으로 방문시 경로와 총거리 비교\n");

		for (int i = 0; i < N; i++) {
			String[] tvFv = new String[2]; // 역순으로 확인하기 위한 CityComparable의 메소드에 getBackVer의 리턴값을 받기위한 배열
			int fv = 0;
			int tv = 0;
			tvFv = Load[i].getBackVer();

			for (int j = 0; j < N; j++) {
				if (City[j] == tvFv[0]) { // fv를 구함
					fv = j;
				}
				if (City[j] == tvFv[1]) { // tv를 구함
					tv = j;
				}
			}

			int[] distance = di.shortestPath(fv);
			int back = tv;
			while (di.previous[back] != -1) {
				System.out.print(City[back] + "=>");
				back = di.previous[back];
			}
			System.out.print(City[fv] + " 총거리는 :" + distance[tv] + "km");
			System.out.println();
		}

		String k1 = "역사 유적지";
		String k2 = "자연 명승지";
		String k3 = "휴양지";
		String k4 = "맛집";

		Tourists[] ts = new Tourists[10];

		ts[0] = new Tourists("논산");
		ts[1] = new Tourists("강경");
		ts[2] = new Tourists("계룡");
		ts[3] = new Tourists("공주");
		ts[4] = new Tourists("부여");
		ts[5] = new Tourists("대전");
		ts[6] = new Tourists("천안");
		ts[7] = new Tourists("전주");
		ts[8] = new Tourists("대천");
		ts[9] = new Tourists("부안");
		
		//논산
		ts[0].tourist[0] = new ToursInfo("관측사", k1, 82);
		ts[0].tourist[1] = new ToursInfo("계백장군", k1, 80);
		ts[0].tourist[2] = new ToursInfo("돈암서원", k1, 78);
		ts[0].tourist[3] = new ToursInfo("탑정호", k2, 90);
		ts[0].tourist[4] = new ToursInfo("대둔산", k2, 84);
		ts[0].tourist[5] = new ToursInfo("KT&G 상상마당", k3, 86);
		ts[0].tourist[6] = new ToursInfo("덕바위 농촌체험 휴양마을", k3, 84);
		ts[0].tourist[7] = new ToursInfo("논산 선샤인랜드", k3, 80);
		ts[0].tourist[8] = new ToursInfo("신동회관", k4, 84);
		ts[0].tourist[9] = new ToursInfo("산애들애", k4, 96);

		// 강경

		ts[1].tourist[0] = new ToursInfo("옥녀봉 공원", k1, 84);
		ts[1].tourist[1] = new ToursInfo("죽림서원", k1, 81);
		ts[1].tourist[2] = new ToursInfo("강경 역사관", k1, 78);
		ts[1].tourist[3] = new ToursInfo("수락계곡", k2, 86);
		ts[1].tourist[4] = new ToursInfo("양촌 자연 휴양림", k2, 85);
		ts[1].tourist[5] = new ToursInfo("강경 황산 등대 전망대", k3, 74);
		ts[1].tourist[6] = new ToursInfo("천주교 강경성당", k3, 90);
		ts[1].tourist[7] = new ToursInfo("미내다리", k3, 89);
		ts[1].tourist[8] = new ToursInfo("강경 젓갈 시장", k4, 87);
		ts[1].tourist[9] = new ToursInfo("강경 해물 칼국수", k4, 88);

		// 계룡
		ts[2].tourist[0] = new ToursInfo("무상사", k1, 84);
		ts[2].tourist[1] = new ToursInfo("사계고택", k1, 71);
		ts[2].tourist[2] = new ToursInfo("입암리 유적공원", k1, 68);
		ts[2].tourist[3] = new ToursInfo("계룡산", k2, 87);
		ts[2].tourist[4] = new ToursInfo("계룡저수지", k2, 85);
		ts[2].tourist[5] = new ToursInfo("계룡대통일탑", k3, 81);
		ts[2].tourist[6] = new ToursInfo("과목정 무궁화 학습원", k3, 84);
		ts[2].tourist[7] = new ToursInfo("두계천 생태공원", k3, 81);
		ts[2].tourist[8] = new ToursInfo("계룡면옥", k4, 90);
		ts[2].tourist[9] = new ToursInfo("콩밭가인", k4, 88);

		// 공주
		ts[3].tourist[0] = new ToursInfo("무령왕릉", k1, 84);
		ts[3].tourist[1] = new ToursInfo("공산성", k1, 82);
		ts[3].tourist[2] = new ToursInfo("석장리 박물관", k1, 80);
		ts[3].tourist[3] = new ToursInfo("황새바위", k2, 78);
		ts[3].tourist[4] = new ToursInfo("정안천생태공원", k2, 76);
		ts[3].tourist[5] = new ToursInfo("공주한옥마을", k3, 97);
		ts[3].tourist[6] = new ToursInfo("국립공주박물관", k3, 84);
		ts[3].tourist[7] = new ToursInfo("임립미술관", k3, 67);
		ts[3].tourist[8] = new ToursInfo("동해원", k4, 75);
		ts[3].tourist[9] = new ToursInfo("유가네 칼국수", k4, 84);

		// 부여

		ts[4].tourist[0] = new ToursInfo("정림사지", k1, 84);
		ts[4].tourist[1] = new ToursInfo("궁남지", k1, 84);
		ts[4].tourist[2] = new ToursInfo("부소산성", k1, 81);
		ts[4].tourist[3] = new ToursInfo("낙화암", k2, 87);
		ts[4].tourist[4] = new ToursInfo("성흔산 사랑나무", k2, 88);
		ts[4].tourist[5] = new ToursInfo("부여국립박물관", k3, 78);
		ts[4].tourist[6] = new ToursInfo("백제문화단지", k3, 96);
		ts[4].tourist[7] = new ToursInfo("서동요테마파크", k3, 99);
		ts[4].tourist[8] = new ToursInfo("서동한우", k4, 69);
		ts[4].tourist[9] = new ToursInfo("연꽃이야기", k4, 75);

		// 대전
		ts[5].tourist[0] = new ToursInfo("둔산 선사유적지", k1, 78);
		ts[5].tourist[1] = new ToursInfo("대덕계족산성", k1, 67);
		ts[5].tourist[2] = new ToursInfo("석장리 박물관", k1, 87);
		ts[5].tourist[3] = new ToursInfo("장태산 자연휴양림", k2, 88);
		ts[5].tourist[4] = new ToursInfo("보문산", k2, 79);
		ts[5].tourist[5] = new ToursInfo("대전 시민 천문대", k3, 81);
		ts[5].tourist[6] = new ToursInfo("오월드", k3, 94);
		ts[5].tourist[7] = new ToursInfo("한밭 수목원", k3, 84);
		ts[5].tourist[8] = new ToursInfo("성심당", k4, 94);
		ts[5].tourist[9] = new ToursInfo("신도칼국수", k4, 74);

		// 천안

		ts[6].tourist[0] = new ToursInfo("독립기념관", k1, 98);
		ts[6].tourist[1] = new ToursInfo("태조산 각원사", k1, 88);
		ts[6].tourist[2] = new ToursInfo("유관순열사 기념관", k1, 97);
		ts[6].tourist[3] = new ToursInfo("광덕산", k2, 81);
		ts[6].tourist[4] = new ToursInfo("천호지", k2, 81);
		ts[6].tourist[5] = new ToursInfo("리각미술관", k3, 67);
		ts[6].tourist[6] = new ToursInfo("쥬쥬피아", k3, 96);
		ts[6].tourist[7] = new ToursInfo("홍대용과학관", k3, 87);
		ts[6].tourist[8] = new ToursInfo("병천시장", k4, 87);
		ts[6].tourist[9] = new ToursInfo("봉봉닭강정", k4, 67);

		// 전주
		ts[7].tourist[0] = new ToursInfo("경기전", k1, 74);
		ts[7].tourist[1] = new ToursInfo("전주한옥마을", k1, 97);
		ts[7].tourist[2] = new ToursInfo("풍남문", k1, 81);
		ts[7].tourist[3] = new ToursInfo("전주 자연생태관", k2, 67);
		ts[7].tourist[4] = new ToursInfo("전주천교", k2, 68);
		ts[7].tourist[5] = new ToursInfo("덕진공원", k3, 75);
		ts[7].tourist[6] = new ToursInfo("자만 벽화마을", k3, 76);
		ts[7].tourist[7] = new ToursInfo("어진 박물관", k3, 78);
		ts[7].tourist[8] = new ToursInfo("진미집", k4, 79);
		ts[7].tourist[9] = new ToursInfo("고궁", k4, 82);
		// 대천

		ts[8].tourist[0] = new ToursInfo("충청 수영성", k1, 71);
		ts[8].tourist[1] = new ToursInfo("성주사지", k1, 84);
		ts[8].tourist[2] = new ToursInfo("최고운 유적", k1, 64);
		ts[8].tourist[3] = new ToursInfo("죽도관광지", k2, 88);
		ts[8].tourist[4] = new ToursInfo("무창포", k2, 72);
		ts[8].tourist[5] = new ToursInfo("대천 해수욕장", k3, 97);
		ts[8].tourist[6] = new ToursInfo("석탄 박물관", k3, 88);
		ts[8].tourist[7] = new ToursInfo("개화 예술공원", k3, 78);
		ts[8].tourist[8] = new ToursInfo("화장골 맛집거리", k4, 86);
		ts[8].tourist[9] = new ToursInfo("황해원", k4, 88);

		// 부안
		ts[9].tourist[0] = new ToursInfo("부안서문안당산", k1, 87);
		ts[9].tourist[1] = new ToursInfo("반계선생유적지", k1, 84);
		ts[9].tourist[2] = new ToursInfo("선웅사 대웅전", k1, 74);
		ts[9].tourist[3] = new ToursInfo("채석강", k2, 74);
		ts[9].tourist[4] = new ToursInfo("적벽강", k2, 84);
		ts[9].tourist[5] = new ToursInfo("곰소염전", k3, 63);
		ts[9].tourist[6] = new ToursInfo("원숭이 학교", k3, 95);
		ts[9].tourist[7] = new ToursInfo("부안 영상테마파크", k3, 87);
		ts[9].tourist[8] = new ToursInfo("씨윈드", k4, 97);
		ts[9].tourist[9] = new ToursInfo("이화자백합죽", k4, 91);
		
		
		String[] key = { "역사 유적지", "자연 명승지", "휴양지", "맛집"};
		int[] keypoint = new int[4];
		
		for (int i = 0; i < 10; i++) {

			Arrays.sort(ts[i].tourist); // 점수별로 Sorting

			for (int q = 0; q < 5; q++) {					//상위 5개의 키워드에 따라 카운트
				if (ts[i].tourist[q].keyword == k1) {				
					keypoint[0]++;
				} else if (ts[i].tourist[q].keyword == k2) {
					keypoint[1]++;
				} else if (ts[i].tourist[q].keyword == k3) {
					keypoint[2]++;
				} else {
					keypoint[3]++;
				}
			}
		}
		
		System.out.println("\n 10개 도시의 관광키워드");
		int max = 0;
		int maxidx = 0;
		for(int i = 0; i<4; i++) {
			if(max < keypoint[i]) {
				max =keypoint[i];
				maxidx=i;
			}
			System.out.println(key[i] + "의 키워드 개수 : "+ keypoint[i]+"개");
		}
	
		System.out.print("\n이 여행의 관광 키워드는 "+key[maxidx]+"("+keypoint[maxidx]+"개)입니다.");
	}
}