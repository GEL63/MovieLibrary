package movieslibrary;

import java.util.HashMap;

public class CountryOfOrigin extends Basic{

	public CountryOfOrigin(String id, String name){
		
		super(id, name);
		
	}
	
	public CountryOfOrigin(String id, String name, HashMap<String, Movie> movies) {
		
		super(id,name, movies);			
		
	}

}
