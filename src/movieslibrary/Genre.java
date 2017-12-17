package movieslibrary;

import java.util.HashMap;

public class Genre extends Basic {

	public Genre(String id, String name){
		
		super(id, name);
		
	}
	
	public Genre(String id, String name, HashMap<String, Movie> movies) {
		
		super(id, name, movies);			
		
	}

}
