package movieslibrary;

import java.util.HashMap;

public class Director extends Basic {

	public Director(String id, String name) {

		super(id, name);

	}

	public Director(String id, String name, HashMap<String, Movie> movies) {

		super(id, name, movies);

	}

}

