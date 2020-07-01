package project.test8_Dijkstra;

public class Tourists {
	public String CityName;
	public ToursInfo[] tourist;
	
	
	
	public Tourists(String name) {
		this.CityName = name;
		this.tourist = new ToursInfo[10];
		for(int i = 0; i < 10; i++) {
			
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return CityName;
	}
	
	
}
