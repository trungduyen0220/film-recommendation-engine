package tool.recommendation.engines.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import tool.recommendation.engines.entity.Movie;
import tool.recommendation.engines.entity.Rater;
import tool.recommendation.engines.entity.Rating;
import tool.recommendation.engines.service.FirstRatings;

public class TestFirstRatings {
	
	static FirstRatings frsRating = new FirstRatings();
	static List<Movie> lstMovie = frsRating.loadMovies("src//ratedmoviesfull.csv");
	static List<Rater> lstRater = frsRating.loadRaters("src//ratings.csv");

	public static void testNumberOfMovies() {
		System.out.println("Size of list: " + lstMovie.size());
	}
	
	public static void testNumberOfTypeMovie(String type) {
		
		int comedyCount = 0;
		for (Movie movie : lstMovie) {
			if (movie.getGenres().contains(type)) {
				comedyCount++;
			}
		}
		System.out.println("How many comedy genre: " + comedyCount);
	}
	
	public static void testNumberMoreThanTime(int time) {
		
		int count = 0;
		for (Movie movie : lstMovie) {
			if (movie.getMinutes() > time) {
				count++;
			}
		}
		System.out.println("How many movie more than 15': " + count);
	}

	public static void testMaxNumberOfOneDirector() {
		
		List<String> lstDirector = new ArrayList<>();
		for (Movie movie : lstMovie) {
			lstDirector.addAll(movie.getDirector());
		}

		Map<String, Integer> mapDirectorFilm = new HashMap<>();
		Collections.sort(lstDirector);
		int numberOfFilm = 1;
		int maxNumberOfFilm = 0;

		String tempDirector = lstDirector.get(0);
		for (int i = 0; i < lstDirector.size(); i++) {

			if (maxNumberOfFilm < numberOfFilm) {
				maxNumberOfFilm = numberOfFilm;
			}
			String nextDirector = "";
			if (i < lstDirector.size() - 1) {
				nextDirector = lstDirector.get(i + 1);
			}
			
			if (!tempDirector.equals(nextDirector)) {
				mapDirectorFilm.put(lstDirector.get(i), numberOfFilm);
				numberOfFilm = 1;
				tempDirector = nextDirector;
				
			} else {
				numberOfFilm++;
			}

		}

		System.out.println("Maximum number of movies by any director: " + maxNumberOfFilm);
		
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Integer> entry : mapDirectorFilm.entrySet()) {
			if (entry.getValue().equals(maxNumberOfFilm)) {
				sb.append(entry.getKey() + "; ");
			}
		}
		System.out.println(sb.toString());
	}

	public static void testMaxOfNumberOfFilmDirectedByOneDirector() {
		int count = 0;
		for (Movie movie : lstMovie) {
			if(movie.getDirector().size() == 1) {
				count++;
			}
		}
		
		System.out.println("Maximum number film directed by 1 director: " + count);
	}
	
	public static void testLoadRater() {
		System.out.println("Size of list rater: " + lstRater.size());
	}
	
	public static void testNumberOfRatingsOfARater(String raterId) {
		int number = 0;
		for (Rater rId : lstRater) {
			if(rId.getId().equals(raterId)) {
				break;
			}
			number++;
		}
		
		System.out.println("Number of ratings of a rater" + raterId + ": " + lstRater.get(number).numRatings());
	}
	
	public static void testGetNumberOfRatingsOfAMovie(String movieId) {
		int number = 0;
		for(Rater rater : lstRater) {
			for(Rating rating : rater.getMyRatings()) {
				if (movieId.equals(rating.getItem())){
					number++;
				}
			}
		}
		
		
		System.out.println("Number of ratings of movie " + movieId + "is: " + number);
	}
	
	public static void testGetItemsRated() {
		Set<String> lstRatedMovie = new HashSet<>();
		for (Rater rater : lstRater) {
			for(Rating rating : rater.getMyRatings()) {
				lstRatedMovie.add(rating.getItem());
			}
		}
		System.out.println("Total of movies are rated: " + lstRatedMovie.size());
	}

	public static void testTop1RatedMostMovies() {
		int maxRated = 0;
		String raterId = "";
		for (Rater rater : lstRater) {
			if (maxRated < rater.getMyRatings().size()) {
				maxRated = rater.getMyRatings().size();
				raterId = rater.getId();
			}
		}
		
		System.out.println(raterId + " " + maxRated);
	}
}
