package project.test8_Dijkstra;

public class ToursInfo implements Comparable<ToursInfo> {
	public String name ="";
	public String keyword ="" ;
	public int count = 0;
	
	public ToursInfo(String name, String keyword,int count) {
		this.name = name;
		this.keyword = keyword;
		this.count = count;
	}

	@Override
	public String toString() {
		
		return name;
	}

	@Override
	public int compareTo(ToursInfo o) {
		if(this.count < o.count) {
			return 1;
		}else if(this.count == o.count) {
			return 0;
		}else {
			return -1;
		}
		
	
	}
	
	
	
	

	
}
