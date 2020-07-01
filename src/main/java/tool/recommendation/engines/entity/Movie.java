package tool.recommendation.engines.entity;

public class Movie {
	private String id;
	private String title;
	private int year;
	private String genres;
	private String director;
	private String country;
	private int minutes;
	private String poster;
	
	public Movie(String id, String title, int year, String genres, String director, String country, int minutes,
			String poster) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genres = genres;
		this.director = director;
		this.country = country;
		this.minutes = minutes;
		this.poster = poster;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "Movie: " + id + ", " + title + ", " + year + ", " + genres + ", "
				+ director + ", " + country + ", " + minutes + ", " + poster;
	}
}
