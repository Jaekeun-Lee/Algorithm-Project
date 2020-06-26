package project.test7_KeywordSearching;

import java.util.Scanner;

public class KmpMatch {



   public void findKMP(String TextSeq, String pattern, int PIE[]) {
      int i=0, j=0, count=0, position;
      int goalst = PIE.length;  // 목표 도달까지의 상태수 = pattern.length()
      
      while(i < TextSeq.length()) {
         if ( TextSeq.charAt(i) == pattern.charAt(j))   j++;
         else  j = PIE[j];
         
         if (j == goalst-1) {
            count++;    position = i - goalst + 2;
            System.out.printf(" "+ position);
            j = PIE[j];
         }
         i++;
      }
   }
      
   int [] preprocessing(String pattern) {
      int j=0, k=-1;
      int length = pattern.length();
      int PIE[] = new int[length+1];
      
      PIE[0] = 0;
      while (j < length) {
         if ((k==-1)||(pattern.charAt(j) == pattern.charAt(k)))  { k++;  PIE[j+1] = k; }
         else  k = PIE[k];
         
         j++;
      }
      
      System.out.printf("KMP automata: [ ");
      for(int i=0; i<=length; i++) System.out.printf("%2d ", PIE[i]);
      System.out.println("]");
      
      return PIE;
   }
}



