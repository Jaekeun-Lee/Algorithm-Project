package project.test7_KeywordSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class KeyWordMatching {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:\\Users\\USER\\Desktop\\2019년\\알고리즘\\돈암서원.txt");
		FileReader Freader = new FileReader(file);
		Scanner stdIn = new Scanner(file);
		String don = "";
		String ex = "";
		while (stdIn.hasNextLine()) {
			ex = stdIn.nextLine();
			don = don.concat(ex); // 따로 \n을 제거하지않아도 concat을 이용해 사라지게함.
			System.out.println(ex);
		}
		System.out.println("C:\\Users\\USER\\Desktop\\2019년\\알고리즘\\돈암서원.txt 파일읽기가 종료되었습니다.");

		System.out.println("탐색할 Key Word 패턴을 입력하세요.");
		String pattern = "";
		Scanner s = new Scanner(System.in);
		pattern = s.nextLine();
		stdIn.close();

		// 1번 원시적 매칭
		System.out.println("\n원시적 매칭으로 찾은 위치: ");
		NaiveMatch NM = new NaiveMatch();
		System.out.print("패턴이 시작되는 위치: ");
		NM.findPattern(don, pattern);
		System.out.println("");

		// 2번 Automata 매칭
		System.out.println("\nAutomata 매칭으로 찾은 위치: ");
		char inchar[] = { '돈', '암', '서', '원' }; // 입력 문자의 집합
		int[][] TM = { // 돈암서원 상태 전이 함수 매트릭스
				{ 1, 0, 0, 0 }, { 0, 2, 0, 0 }, { 0, 0, 3, 0 }, { 0, 0, 0, 4 }, { 0, 0, 0, 0 }, };

		System.out.print("패턴이 시작되는 위치: ");
		AutomataMatch AM = new AutomataMatch();
		AM.findPattern(don, inchar, TM);
		System.out.println();

		//3번 boyerMooreHorspool
		int index =0;
        int count = 0;
        String pt = don;
        
        BoyerMooreHorspool by = new BoyerMooreHorspool();
        System.out.print(" \nboyerMooreHorspool로 매칭으로 찾은 위치:\n");
        System.out.print("패턴이 시작되는 위치: ");
		 while(pt.length() >= pattern.length()) {
	    	   index = by.BM_Search(pt,pattern);
	    	   pt = pt.substring(index+4);
	    	   if(index+count<1816)
	    	   System.out.print(index+count+" ");
	    	   
	    	  count += index+4;	//4는 돈암서원의 글자 길이
		 }
		
		
		// 3번 KMP automata
		System.out.println("\n\nKMP Automata 매칭으로 찾은 위치: ");

		KmpMatch c = new KmpMatch();
		int PIE[] = c.preprocessing(pattern);
		System.out.print("패턴이 시작되는 위치: ");
		c.findKMP(don, pattern, PIE);

		

	}
}