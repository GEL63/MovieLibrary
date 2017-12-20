package movieslibrary;
import java.util.HashMap;

public class Movie {
		
	private String id;
	private String title;
	private String date;
	private int numOfComments;
	private CountryOfOrigin origin;
	private HashMap<String,Actor> actors;
	private HashMap<String,Director> directors;	
	private HashMap<String,FilmingLocation> locations;
	private HashMap<String, Genre> genres;
	private HashMap<String, Tag> tags;
	
	public Movie(String id, String title, String date){ //, int numOfComments){
		
		this.id=id;
		this.title=title;
		this.date = date;
		//this.numOfComments = numOfComments;
		this.directors = new HashMap<String,Director>();
		this.actors = new HashMap<String,Actor>();
		this.locations = new HashMap<String,FilmingLocation>(); 		
	}
	
	public Movie(String id,String title,String date,int numOfComments,HashMap<String,Director> directors,HashMap<String,Actor> actors, CountryOfOrigin origin,HashMap<String,FilmingLocation> locations, HashMap<String, Genre> genres){
		
		this.id = id;
		this.title = title;
		this.date = date;
		this.numOfComments = numOfComments;
		this.directors = directors;
		this.actors = actors;
		this.origin = origin;
		this.locations = locations; 
		this.genres = genres;
		
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

	public int getNumOfComments() {
		return numOfComments;
	}

	public void setNumOfComments(int numOfComments) {
		this.numOfComments = numOfComments;
	}

	public HashMap<String,Director> getDirectors() {
		return directors;
	}

	public void setDirectors(HashMap<String,Director> directors) {
		this.directors = directors;
	}

	public HashMap<String,Actor> getActors() {
		return actors;
	}

	public void setActors(HashMap<String,Actor> actors) {
		this.actors = actors;
	}

	public HashMap<String,FilmingLocation> getLocations() {
		return locations;
	}

	public void setLocations(HashMap<String,FilmingLocation> locations) {
		this.locations = locations;
	}
	
	public CountryOfOrigin getOrigin() {
		return origin;
	}
	
	public void setOrigin(CountryOfOrigin origin) {
		this.origin = origin;
	}

	public HashMap<String, Genre> getGenres() {
		return genres;
	}

	public void setGenres(HashMap<String, Genre> genres) {
		this.genres = genres;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAllDirectors(){
		
		String stringOfDirectors = "";
		for(String a: directors.keySet()){
			
			Director director = directors.get(a);
			stringOfDirectors = stringOfDirectors + director.getName();
		}
		return stringOfDirectors;
	}
	
	public String toStringFull(){
		
		String str = "Movie Title: " + this.title + "\n" + "Year of Production: " + this.date +
				"\n" + "Country of Origin: " + this.origin.toString() + "\n" + "Directors: " + "\n";
		
		for(String directorId : directors.keySet()){
			
			Director director = directors.get(directorId);
			str = str + director.toString() + "\n";
			
		}
		str = str + "\nActors: \n" ;
		for(String actorId : actors.keySet()){
			
			Actor actor = actors.get(actorId);
			str = str + actor.toString() + "\n";
			
		}		
		str = str + "\nLocations: \n" ;
		for(String locationId : locations.keySet()){
			FilmingLocation location = locations.get(locationId);
			str = str + location.toString() + "\n";
		}
		str = str + "\nGenres: \n" ;
		for(String genreId : genres.keySet()){
			
			Genre genre = genres.get(genreId);
			str = str + genre.toString() + "\n";
			
		}
		return str;
	}
	
	public String toString(){

		String str = this.title;
		if(this.date != null) {
			str = str + "\n" + this.date; 			
		}
		else {
			str = str + "\n";			
		}
		if(this.origin != null) {
			str = str +	"\n" + this.origin.toString(); 			
		}
		else {
			str = str + "\n";			
		}

		if(this.directors.size() != 0){
			str = str + "\n";
			for(String directorId : directors.keySet()){
				str = str + directors.get(directorId).toString() + ", ";
			}
			str = str.substring(0, str.length()-2);
		}
		else
			str = str +"\nUnknown";
		return str;
	}

	
	public HashMap<String, Tag> getTags() {
		return tags;
	}

	
	public void setTags(HashMap<String, Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag) {
		tags.put(tag.getId(), tag);
	}
	
	public void removeTag(String tagId) {
		tags.remove(tagId);
	}
}