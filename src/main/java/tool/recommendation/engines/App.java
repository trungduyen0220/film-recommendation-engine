package tool.recommendation.engines;

import tool.recommendation.engines.test.TestFirstRatings;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("-------------------------Test movie:");
		TestFirstRatings.testNumberOfMovies();
		TestFirstRatings.testNumberOfTypeMovie("Comed");
		TestFirstRatings.testNumberMoreThanTime(150);
		TestFirstRatings.testMaxNumberOfOneDirector();
		TestFirstRatings.testMaxOfNumberOfFilmDirectedByOneDirector();
		System.out.println("-------------------------Test rater:");
		TestFirstRatings.testLoadRater();
		TestFirstRatings.testNumberOfRatingsOfARater("193");
		TestFirstRatings.testGetNumberOfRatingsOfAMovie("1798709");
		TestFirstRatings.testGetItemsRated();
		TestFirstRatings.testTop1RatedMostMovies();
	}

	
}