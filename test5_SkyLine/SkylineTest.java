package project.test5_SkyLine;

import java.util.Scanner;


public class SkylineTest {
    public static void main(String[] args) {

        Skyline skyline = new Skyline();
        Scanner stdIn = new Scanner(System.in);

        System.out.print("�ǹ� ���� �Է����ּ��� : ");		//�迭�� ũ�⸸ŭ
        int n = stdIn.nextInt();
        skyline.buildArray(n);

        System.out.println("��ǥ�� �Է����ּ���.");
        
        for(int i = 0; i < n; i++) {							//�ϳ��� �ǹ��� ��ǥ�� ����x, ����y, ������x���� �Է���
        		skyline.building[i].left = stdIn.nextInt();
        		skyline.building[i].height = stdIn.nextInt();
        		skyline.building[i].right = stdIn.nextInt();
        }
        
        
        
       // System.out.println(skyline.find_skyline(skyline.building,0, n-1));
        skyline.print_skyline();
    }
}