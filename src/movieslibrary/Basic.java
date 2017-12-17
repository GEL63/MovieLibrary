package movieslibrary;

import java.util.HashMap;

public abstract class Basic {
	
	protected String id;
	protected String name;
	protected HashMap<String, Movie> movies;

	public Basic() {
		
		id = "";
		name = "";
		movies = new HashMap<String, Movie>();

	}

	public Basic(String id, String name) {
		
		this.id = id;
		this.name = name;
		this.movies = new HashMap<String, Movie>();
		
	}

	public Basic(String id, String name, HashMap<String, Movie> movies) {

		this.id = id;
		this.name = name;
		this.movies = movies;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Movie> getMovies() {
		return movies;
	}

	public void setMovies(HashMap<String, Movie> movies) {

		this.movies = movies;

	}

	public void addMovie(Movie movie) {

		movies.put(movie.getId(), movie);

	}

	public void removeMovie(String id) {

		movies.remove(id);

	}

	public void containsMovie(String id) {

		movies.containsKey(id);

	}

	public boolean isEmpty() {

		return movies.isEmpty();

	}
	
	public String toString(){
		
		return name;
		
	}

}
