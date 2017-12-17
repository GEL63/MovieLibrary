package movieslibrary;

import java.util.HashMap;

public class FilmingLocation extends Basic {

	public FilmingLocation(String id, String name) {

		super(id, name);

	}

	public FilmingLocation(String id, String name, HashMap<String, Movie> movies) {

		super(id, name, movies);

	}

}
