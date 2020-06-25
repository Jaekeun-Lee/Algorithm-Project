package project.test5_SkyLine;

import java.util.Scanner;


public class SkylineTest {
    public static void main(String[] args) {

        Skyline skyline = new Skyline();
        Scanner stdIn = new Scanner(System.in);

        System.out.print("건물 수를 입력해주세요 : ");		//배열의 크기만큼
        int n = stdIn.nextInt();
        skyline.buildArray(n);

        System.out.println("좌표를 입력해주세요.");
        
        for(int i = 0; i < n; i++) {							//하나의 건물의 좌표를 왼쪽x, 왼쪽y, 오른쪽x값을 입력함
        		skyline.building[i].left = stdIn.nextInt();
        		skyline.building[i].height = stdIn.nextInt();
        		skyline.building[i].right = stdIn.nextInt();
        }
        
        
        
       // System.out.println(skyline.find_skyline(skyline.building,0, n-1));
        skyline.print_skyline();
    }
}