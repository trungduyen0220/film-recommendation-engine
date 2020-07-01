package tool.recommendation.engines.entity;

import java.util.List;

public class Rater {
	private String myID;
	private List<Rating> myRatings;

	public Rater(String myID) {
		super();
		this.myID = myID;
	}

	public void addRating(String item, double rating) {
		Rating rate = new Rating(item, rating);
		myRatings.add(rate);
	}

	public String getId() {
		return myID;
	}

	public boolean hasRating(String item) {
		for (Rating rate : myRatings) {
			if (rate.getItem().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public double getRating(String item) {
		for (Rating rate : myRatings) {
			if (rate.getItem().equals(item)) {
				return rate.getValue();
			}
		}
		return -1;
	}
}
