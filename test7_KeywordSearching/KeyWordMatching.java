package project.test7_KeywordSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class KeyWordMatching {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:\\Users\\USER\\Desktop\\2019��\\�˰���\\���ϼ���.txt");
		FileReader Freader = new FileReader(file);
		Scanner stdIn = new Scanner(file);
		String don = "";
		String ex = "";
		while (stdIn.hasNextLine()) {
			ex = stdIn.nextLine();
			don = don.concat(ex); // ���� \n�� ���������ʾƵ� concat�� �̿��� ���������.
			System.out.println(ex);
		}
		System.out.println("C:\\Users\\USER\\Desktop\\2019��\\�˰���\\���ϼ���.txt �����бⰡ ����Ǿ����ϴ�.");

		System.out.println("Ž���� Key Word ������ �Է��ϼ���.");
		String pattern = "";
		Scanner s = new Scanner(System.in);
		pattern = s.nextLine();
		stdIn.close();

		// 1�� ������ ��Ī
		System.out.println("\n������ ��Ī���� ã�� ��ġ: ");
		NaiveMatch NM = new NaiveMatch();
		System.out.print("������ ���۵Ǵ� ��ġ: ");
		NM.findPattern(don, pattern);
		System.out.println("");

		// 2�� Automata ��Ī
		System.out.println("\nAutomata ��Ī���� ã�� ��ġ: ");
		char inchar[] = { '��', '��', '��', '��' }; // �Է� ������ ����
		int[][] TM = { // ���ϼ��� ���� ���� �Լ� ��Ʈ����
				{ 1, 0, 0, 0 }, { 0, 2, 0, 0 }, { 0, 0, 3, 0 }, { 0, 0, 0, 4 }, { 0, 0, 0, 0 }, };

		System.out.print("������ ���۵Ǵ� ��ġ: ");
		AutomataMatch AM = new AutomataMatch();
		AM.findPattern(don, inchar, TM);
		System.out.println();

		//3�� boyerMooreHorspool
		int index =0;
        int count = 0;
        String pt = don;
        
        BoyerMooreHorspool by = new BoyerMooreHorspool();
        System.out.print(" \nboyerMooreHorspool�� ��Ī���� ã�� ��ġ:\n");
        System.out.print("������ ���۵Ǵ� ��ġ: ");
		 while(pt.length() >= pattern.length()) {
	    	   index = by.BM_Search(pt,pattern);
	    	   pt = pt.substring(index+4);
	    	   if(index+count<1816)
	    	   System.out.print(index+count+" ");
	    	   
	    	  count += index+4;	//4�� ���ϼ����� ���� ����
		 }
		
		
		// 3�� KMP automata
		System.out.println("\n\nKMP Automata ��Ī���� ã�� ��ġ: ");

		KmpMatch c = new KmpMatch();
		int PIE[] = c.preprocessing(pattern);
		System.out.print("������ ���۵Ǵ� ��ġ: ");
		c.findKMP(don, pattern, PIE);

		

	}
}