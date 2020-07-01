package project.test8_Dijkstra;

import java.util.ArrayList;

public class CityComparable implements Comparable<CityComparable>{
	ArrayList<String> City = new ArrayList<>();
	int distance;
	
	
	public CityComparable(ArrayList<String> City, int distance){
		this.City = City;
		this.distance = distance;
	}

	@Override
	public int compareTo(CityComparable o) {
		if (this.distance < o.distance) {
			return 1;
		} else if (this.distance == o.distance) {
			return 0;
		} else {
			return -1;
		}

	}

	public void printCity() {
		System.out.print(City.get(0));
		for(int i=1; i<City.size(); i++) {
			System.out.print("=>"+ City.get(i));
		}
		
		System.out.println( " ÃÑ°Å¸®´Â :"+this.distance+"km");
	}
	
	public String[] getBackVer() {
		String[] fvTv = new String[2];
		fvTv[0] = this.City.get(0);
		fvTv[1] = this.City.get(City.size()-1);
		
		return fvTv;
	}
	
	
	
	
	
}
