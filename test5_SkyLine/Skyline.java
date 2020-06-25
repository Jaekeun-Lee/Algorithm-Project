package project.test5_SkyLine;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Skyline {

    Building[] building;

    public class Building {							//좌표 입력
        int left, height, right;

        public Building() {
            this.left = 0;
            this.height = 0;
            this.right = 0;
        }

        public Building(int left, int height, int right) {	//building 좌표 생성자
            this.left = left;
            this.height = height;
            this.right = right;
        }
    }

    
    
    public class Point {								
        int x, height;

        public Point() {
            this.x = 0;
            this.height = 0;
        }

        public Point(int left, int height) {
            this.x = left;
            this.height = height;
        }

        public String toString() {						//Point 자료형을 리턴할 시 그 값의 x값과 높이를 출력함.
            return this.x + ", " + this.height;
        }
    }

    public void buildArray(int n) {						//배열의 크기를 지정.
        this.building = new Building[n];

        for(int i = 0 ; i < n; i++) {					//배열 초기화
            this.building[i] = new Building();
        }
    }
    
    

    
    public ArrayList<Point> find_skyline(Building[] build, int first, int end) {		//재귀적으로 분할하는 매서드
        if( first == end ) {															//시작과 끝이 같으면 skyline에 추가
            ArrayList<Point> partition_skyline = new ArrayList<Point>();
            partition_skyline.add(new Point(build[first].left, build[first].height)); 	
            partition_skyline.add(new Point(build[end].right, 0));
            return partition_skyline;
        }

        int mid = ( first + end ) / 2;
        ArrayList<Point> sky1 = this.find_skyline(build, first, mid);			//partition을 나눠 재귀 분할하는 부분
        ArrayList<Point> sky2 = this.find_skyline(build, mid+1, end);
        return merge_skyline(sky1, sky2);										//나눈 부분을 합쳐주는 메사드
    }
    
    

    public ArrayList<Point> merge_skyline(ArrayList<Point> sky1, ArrayList<Point> sky2) {	//정복 메서드
        ArrayList<Point> skyline = new ArrayList<Point>();
        int current_height1 = 0;
        int current_height2 = 0;
        int current_x, max_h;

        while(sky1.size()>0 && sky2.size()>0) {					
            if(sky1.get(0).x < sky2.get(0).x) {					//sky2의 x값이 더 크다면
                current_x = sky1.get(0).x;						
                current_height1 = sky1.get(0).height;
                max_h = current_height1;

                if(current_height2 > max_h) {
                    max_h = current_height2;
                }
                skyline.add(new Point(current_x, max_h));
                sky1.remove(0);
            }

            else {
                current_x = sky2.get(0).x;
                current_height2 = sky2.get(0).height;
                max_h = current_height1;

                if(current_height2 > max_h) {
                    max_h = current_height2;
                }
                skyline.add(new Point(current_x, max_h));
                sky2.remove(0);
            }
        }

        while(sky1.size() > 0) {										//sky2의 사이즈가 0일때 sky1의 x좌표와 높이를 skyline에 추가함.
            skyline.add(new Point(sky1.get(0).x, sky1.get(0).height));
            sky1.remove(0);
        }
       
        while(sky2.size() > 0) {										//sky1의 사이즈 0일때 sky2의 x좌표와 높이를 skyline에 추가함
            skyline.add(new Point(sky2.get(0).x, sky2.get(0).height));
            sky2.remove(0);
        }

        return skyline;													//완성된 skyline리턴
    }

    
    public void print_skyline() {
        int size = this.find_skyline(this.building, 0 , this.building.length-1).size(); 

        for(int i = 0; i < size; i++) {
            if( i != 0 && i != size-1 && this.find_skyline(this.building, 0 , this.building.length-1).get(i-1).height == this.find_skyline(this.building, 0 , this.building.length-1).get(i).height) {
            	//높이가 같다면 높이의 변화가 없으므로 출력아무 동작도 안함
            }
            else
            if(i == size-1) System.out.print(this.find_skyline(this.building, 0 , this.building.length-1).get(i));	//높이가 변한다면 그 지점의 x좌표와 그지점의 높이를 출력함.
            else System.out.print(this.find_skyline(this.building, 0 , this.building.length-1).get(i)+", ");		//Point형 자료형을 사용했고 리턴시 x값과 높이를 출력하게 함.
        }
    }

}
