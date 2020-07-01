package tool.recommendation.engines.entity;

import java.util.ArrayList;
import java.util.List;

public class Rater {
	private String myID;
	private List<Rating> myRatings;
	private long time;

	public Rater(String id, List<Rating> myRating, long time) {
		this.myID = id;
		this.myRatings = myRating;
		this.time = time;
	}


	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}

	public List<Rating> getMyRatings() {
		return myRatings;
	}

	public void setMyRatings(List<Rating> myRatings) {
		this.myRatings = myRatings;
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

	public int numRatings() {
		return myRatings.size();
	}

	public List<String> getItemsRated() {
		List<String> lstItem = new ArrayList<>();
		for (Rating rate : myRatings) {
			lstItem.add(rate.getItem());
		}
		return lstItem;
	}
}
