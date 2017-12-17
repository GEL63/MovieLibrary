package movieslibrary;

import java.util.HashMap;

public class Actor extends Basic {

	public Actor(String id, String name) {

		super(id, name);

	}

	public Actor(String id, String name, HashMap<String, Movie> movies) {

		super(id, name, movies);

	}

}
