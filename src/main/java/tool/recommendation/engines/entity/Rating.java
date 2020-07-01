package tool.recommendation.engines.entity;

public class Rating {
	private String item;
	private double value;
	public Rating(String item, double value) {
		super();
		this.item = item;
		this.value = value;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Rating:" + item + ", " + value;
	}
	
	public int compareTo(double value1) {
		if (value1 > value) {
			return 1;
		} else if (value1 == value){
			return 0;
		}
		return -1;
	}
}
