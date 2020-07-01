package tool.recommendation.engines.service;

import java.util.ArrayList;
import java.util.List;
import tool.recommendation.engines.entity.CSVObject;
import tool.recommendation.engines.entity.Movie;
import tool.recommendation.engines.entity.Rater;
import tool.recommendation.engines.entity.Rating;
import tool.recommendation.engines.utils.CSVUtils;

public class FirstRatings {

	public List<Movie> loadMovies(String fileName) {
		List<Movie> lstMovie = new ArrayList<>();

		CSVObject csvObj = CSVUtils.readCSV(fileName);
		for (List<String> record : csvObj.getLstRecords()) {
			String id = record.get(0);
			String title = record.get(1);
			int year = Integer.parseInt(record.get(2));
			String country = record.get(3);
			String genre = record.get(4);
			
			String[] director = record.get(5).split(",");
			List<String> lstDirector = new ArrayList<>();
			for (int i = 0; i < director.length; i++) {
				lstDirector.add(director[i]);
			}
			
			
			int minutes = Integer.parseInt(record.get(6));
			String poster = record.get(7);

			lstMovie.add(new Movie(id, title, year, country, genre, lstDirector, minutes, poster));
		}

		return lstMovie;
	}
	
	public List<Rater> loadRaters(String fileName) {
		List<Rater> lstRater = new ArrayList<>();

		CSVObject csvObj = CSVUtils.readCSV(fileName);
		List<Rating> lstRating = new ArrayList<>();
		for (int i = 0; i<csvObj.getLstRecords().size(); i++) {
		
			List<String> currRecord = csvObj.getLstRecords().get(i);
			List<String> nextRecord = new ArrayList<>();
			String nextRaterId = "";
			if ( i < csvObj.getLstRecords().size() - 1) {
				nextRecord = csvObj.getLstRecords().get(i + 1);
				nextRaterId = nextRecord.get(0);
			}
			
			String movieId = currRecord.get(1);
			Double value = Double.parseDouble(currRecord.get(2));
			Rating rating = new Rating(movieId, value);
			lstRating.add(rating);

			
			

			String raterId = currRecord.get(0);
			long time = Long.parseLong(currRecord.get(3));
			
			String tempRaterId = currRecord.get(0);
			
			if(!tempRaterId.equals(nextRaterId)) {
				List<Rating> tempLstRating = new ArrayList<>();
				for(Rating rate : lstRating) {
					tempLstRating.add(rate);
				}
				
				lstRater.add(new Rater(raterId, tempLstRating, time));
				lstRating.clear();
			}
			
		}
		return lstRater;
	}
	
}
