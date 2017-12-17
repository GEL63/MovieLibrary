package movieslibrary;

import java.util.HashMap;

public class QueryManager {
	
	DataSetManager dataSetManager;
	
	public QueryManager(DataSetManager dataSetManager){
		
		this.dataSetManager = dataSetManager;
		
	}

	public Movie searchById(String id) {
		
		HashMap<String, Movie> movies = dataSetManager.getMovies();
		return movies.get(id);
		
	}

	public Movie searchByTitle(String title) {
		
		HashMap<String, Movie> movies = dataSetManager.getMovies();
		for(String movieId : movies.keySet()){
			Movie movie = movies.get(movieId);
			if(movie.getTitle().equals(title)){//finds the movie the user wants
				return movie;
			}
		}
		return null;
		
	}

	public HashMap<String, Movie> searchByGenre(String genre) {
		
		Genre aGenre = dataSetManager.getGenres().get(genre);
		if(aGenre == null)
			return null;
		else		 
			return aGenre.getMovies();
		
	}

	public HashMap<String,Movie> searchByCountry(String country) {
		
		CountryOfOrigin aCountry = dataSetManager.getCountries().get(country);
		if(aCountry == null)
			return null;
		else
			return aCountry.getMovies();
		
	}

	public HashMap<String, Movie> searchByActor(String actorName) {
		
		HashMap<String, Actor> actors = dataSetManager.getActors();
		for(String actorId : actors.keySet()){
			Actor actor = actors.get(actorId);
			if(actor.getName().equals(actorName)){
				return actor.movies;
			}
		}
		return null;
	
	}

	public HashMap<String, Movie> searchByDirector(String directorName) {
		
		HashMap<String, Director> directors = dataSetManager.getDirectors();
		for(String directorId : directors.keySet()){
			Director director = directors.get(directorId);
			if(director.getName().equals(directorName)){
				return director.movies;
			}
		}
		return null;
		
	}
}
