package project.test7_KeywordSearching;

import java.util.Arrays;

public class BoyerMooreHorspool {
	  public static int BM_Search(String text, String pattern) {
	        int patLen  = pattern.length(); //������ ����
	        int textLen = text.length();
	    //�ؽ�Ʈ�� ������ ��ġ���� �ʾ��� ����
	    //�̵� ����
	        int[] skip = new int[65536];  //���� �ִ밪
	        int i;
	        int j;
	        
	        //ǥ skip�ۼ�
	        Arrays.fill(skip, patLen);
	        for (int x = 0; x < patLen -1; x++){
	            skip[pattern.charAt(x)] = patLen - x - 1;
	        }
	        //�����͸� �ʱ�ȭ�Ѵ�. ������ �ڿ������� ���ϱ� ������
	        i = patLen - 1;
	        //�ؽ�Ʈ�� ���� �������� ������ ������ �ݺ��Ѵ�
	        
	        while (i < textLen) {
	            //������ j�� ������ ������ ���ڸ� ����Ű���� �Ѵ�
	            j = patLen -1;
	            //�ؽ�Ʈ�� ������ ��ġ�ϴ� ���� �ݺ��Ѵ�
	            while (text.charAt(i) == pattern.charAt(j)) {
	                //ó�� ���ڱ��� ��ġ�ߴٸ� Ž���� �����̴�
	                if (j == 0)   {return i;}
	                i--; j--;
	            }
	            i = i + Math.max(skip[text.charAt(i)], patLen - j);
	        }
	        
	        //�ᱹ �߰����� ��������
	        return -1;
	    }
}
