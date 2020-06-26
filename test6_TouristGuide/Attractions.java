package project.test6_TouristGuide;



public class Attractions implements Comparable<Attractions>{
	String City;
	int distance;
	String spot;
	int rating;
	int MaxScore;
	int half = 50;
	
	public Attractions(String City, int distance, String spot, int rating) {
		this.City = City;
		this.distance = distance;
		this.spot = spot;
		this.rating = rating;
		
		if(distance>=0 && distance <=30) {	//거리에 따른 점수형식을 사용
			this.MaxScore = (int)(rating/2) + half;
		}else if(distance > 30 && distance <=40) {
			this.MaxScore = (int)(rating/2) + half-2;
		}else if(distance > 40 && distance <=50) {
			this.MaxScore = (int)(rating/2) + half-4;
		}else if(distance > 50 && distance <=60) {
			this.MaxScore = (int)(rating/2) + half-6;
		}else if(distance > 60 && distance <=70) {
			this.MaxScore = (int)(rating/2) + half-8;
		}else {
			this.MaxScore = (int)(rating/2) + half-10;
		}
		
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	

	@Override
	public String toString() {
		return City+"도시의 관광명소 "+spot+"의 종합 점수는"+MaxScore+"입니다";
	}

	@Override
	public int compareTo(Attractions o) {
		if (this.MaxScore < o.MaxScore) {
			return 1;
		} else if (this.MaxScore == o.MaxScore) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
	
}
