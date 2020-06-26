package project.test6_TouristGuide;

public class CityScore implements Comparable<CityScore> {


	String City;
	int SumScore;
	
	public CityScore(String City, int SumScore) {
		this.City = City;
		this.SumScore = SumScore;
	}

	
	@Override
	public String toString() {
		return City +", "+SumScore;
	}
	
	@Override
	public int compareTo(CityScore o) {
		if (this.SumScore < o.SumScore) {
			return 1;
		} else if (this.SumScore == o.SumScore) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
}
