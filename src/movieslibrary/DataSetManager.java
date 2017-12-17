package movieslibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//Checks if path and files exist
//Reads all files and create collections
//Stores all collections

public class DataSetManager {
	
	static final boolean DEBUG = false;
	
	private String path;
	private boolean isConnected;
	private HashMap<String, Movie> movies;
	private HashMap<String, Actor> actors;
	private HashMap<String, Director> directors;
	private HashMap<String, Genre> genres;
	private HashMap<String, CountryOfOrigin> countries;
	private HashMap<String, FilmingLocation> locations;

	public DataSetManager(String path) {

		this.path = path;
		isConnected = false;
		movies = new HashMap<String, Movie>();
		actors = new HashMap<String, Actor>();
		directors = new HashMap<String, Director>();
		genres = new HashMap<String, Genre>();
		countries = new HashMap<String, CountryOfOrigin>();
		locations = new HashMap<String, FilmingLocation>();

	}

	public boolean connect() {
		isConnected = false;
		File f = new File(path);
		if (f.exists() && f.isDirectory()) {
			f = new File(path + "\\movies.dat");
			if (f.exists()) {
				f = new File(path + "\\movie_actors.dat");
				if (f.exists()) {
					f = new File(path + "\\movie_countries.dat");
					if (f.exists()) {
						f = new File(path + "\\movie_directors.dat");
						if (f.exists()) {
							f = new File(path + "\\movie_genres.dat");
							if (f.exists()) {
								f = new File(path + "\\movie_locations.dat");
								if (f.exists()) {
									f = new File(path + "\\movie_tags.dat");
									if (f.exists()) {
										f = new File(path + "\\tags.dat");
										if (f.exists()) {
											f = new File(path
													+ "\\user_ratedmovies.dat");
											if (f.exists()) {
												f = new File(
														path
																+ "\\user_ratedmovies-timestamps.dat");
												if (f.exists()) {
													f = new File(
															path
																	+ "\\user_taggedmovies.dat");
													if (f.exists()) {
														f = new File(
																path
																		+ "\\user_taggedmovies-timestamps.dat");
														if (f.exists()) {
															isConnected = true;
															return true;
														} else {
															return false;
														}
													} else {
														return false;
													}
												} else {
													return false;
												}
											} else {
												return false;
											}
										} else {
											return false;
										}
									} else {
										return false;
									}
								} else {
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}

			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void readData() {

		if (!isConnected)
			return;

		Scanner irMovie = null;
		Scanner irActor = null;
		Scanner irDirector = null;
		Scanner irLocation = null;
		Scanner irCountry = null;
		Scanner irGenre = null;

		// Open files to read
		try {// for movie
			irMovie = new Scanner(new FileInputStream(path + "\\movies.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movies.dat was not found!");
			System.exit(0);
		}
		try {// for actor
			irActor = new Scanner(new FileInputStream(path + "\\movie_actors.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movies_actors.dat was not found!");
			System.exit(0);
		}
		try {// for director
			irDirector = new Scanner(new FileInputStream(path + "\\movie_directors.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movies_directors.dat was not found!");
			System.exit(0);
		}
		try {// for Location
			irLocation = new Scanner(new FileInputStream(path + "\\movie_locations.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movies_locations.dat was not found!");
			System.exit(0);
		}
		try {// for Countries
			irCountry = new Scanner(new FileInputStream(path + "\\movie_countries.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movie_countries.dat was not found!");
			System.exit(0);
		}
		try {// for Genre
			irGenre = new Scanner(new FileInputStream(path + "\\movie_genres.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Movies.dat was not found!");
			System.exit(0);
		}

		// Skip first line(title-line) of all files
		if (irMovie.hasNextLine()) 		{ irMovie.nextLine(); }
		if (irActor.hasNextLine()) 		{ irActor.nextLine(); }
		if (irDirector.hasNextLine()) 	{ irDirector.nextLine(); }
		if (irLocation.hasNextLine()) 	{ irLocation.nextLine(); }
		if (irCountry.hasNextLine()) 	{ irCountry.nextLine(); }
		if (irGenre.hasNextLine()) 		{ irGenre.nextLine(); }

		while (irMovie.hasNextLine()) { // movieWhile

			String[] actorData, directorData, locationData, countryData, genreData;

			HashMap<String, Actor> movieActors 				= new HashMap<String, Actor>();
			HashMap<String, Director> movieDirectors 		= new HashMap<String, Director>();
			HashMap<String, FilmingLocation> movieLocations = new HashMap<String, FilmingLocation>();
			HashMap<String, Genre> movieGenres 				= new HashMap<String, Genre>();

			String line = irMovie.nextLine(); // read lines
			String[] movieData = line.split("\t"); // splitarw
			if (movieData[0] != "") {
				Movie movie = new Movie(movieData[0], movieData[1], movieData[5]);
				
				// --Add Movie Actors to movie and actors
				while (irActor.hasNext(movie.getId())) { 

					String aLine = irActor.nextLine();
					actorData = aLine.split("\t");
					if (actorData.length >= 2) {
						Actor actor;
						if (!actors.containsKey(actorData[1])) {
							actor = new Actor(actorData[1], actorData[2]);// create
							actors.put(actorData[1], actor);// put it in
						} else {
							actor = actors.get(actorData[1]);
						}
						movieActors.put(actor.getId(), actor);
						if(DEBUG) System.out.print("Actor: " + actor.getName() + ", ");
						actor.addMovie(movie);
					}

				}
				if(DEBUG) System.out.print("\n");
				movie.setActors(movieActors);// Movie has all actors
				
				// --Add Movie Directors to movie and directors
				while (irDirector.hasNext(movie.getId())) {

					String dLine = irDirector.nextLine();
					directorData = dLine.split("\t");
					if (directorData.length >= 2) {
						Director director;
						if (!directors.containsKey(directorData[1])) {
							director = new Director(directorData[1], directorData[2]);
							directors.put(directorData[1], director);
						} else {
							director = directors.get(directorData[1]);
						}
						movieDirectors.put(director.getId(), director);
						if(DEBUG) System.out.print("Director: " + director.getName() + ", ");
						director.addMovie(movie);
					}

				}
				if(DEBUG) System.out.print("\n");
				movie.setDirectors(movieDirectors);

				// --Add Movie Filming Locations to movie and locations
				while (irLocation.hasNext(movie.getId())) {

					String loLine = irLocation.nextLine();
					locationData = loLine.split("\t");
					if (locationData.length > 1) {
						String temp = "";
						for (int i = 1; i < locationData.length; i++) {
							temp = temp + ", " + locationData[i];
						}
						FilmingLocation location;
						if (!locations.containsKey(temp)) {
							location = new FilmingLocation("", temp);
							locations.put(temp, location);
						} else {
							location = locations.get(temp);
						}
						movieLocations.put(location.getId(), location);
						if(DEBUG) System.out.print("Filming Location: " + location.getName() + ", ");
						location.addMovie(movie);
					}

				}
				if(DEBUG) System.out.print("\n");
				movie.setLocations(movieLocations);

				// Add Movie Country  to movie and countries
				while (irCountry.hasNext(movie.getId())) {// countryDo

					String cLine = irCountry.nextLine();
					countryData = cLine.split("\t");
					if (countryData.length == 2) {
						CountryOfOrigin country;
						if (!countries.containsKey(countryData[1])) {
							country = new CountryOfOrigin(countryData[1], countryData[1]);
							countries.put(countryData[1], country);
						} else {
							country = countries.get(countryData[1]);
						}
						movie.setOrigin(country);
						if(DEBUG) System.out.print("Country of Origin: " + country.getName() + ", ");
						country.addMovie(movie);
					}
				}
				if(DEBUG) System.out.print("\n");

				// Add Movie Genres to movie and genres and movie to genre
				while (irGenre.hasNext(movie.getId())) {// genreDo

					String gLine = irGenre.nextLine();
					genreData = gLine.split("\t");
					if (genreData.length >= 1) {
						Genre genre;
						if (!genres.containsKey(genreData[1])) {
							genre = new Genre(genreData[1], genreData[1]);
							genres.put(genreData[1], genre);
						} else {
							genre = genres.get(genreData[1]);
						}
						movieGenres.put(genre.getId(), genre);
						if(DEBUG) System.out.print("Genre: " + genre.getName() + ", ");
						genre.addMovie(movie);
					}
				}
				movie.setGenres(movieGenres);
				if(DEBUG) System.out.print("\n");
				
				//Add movie to movies
				movies.put(movie.getId(), movie);
				if(DEBUG) System.out.println("MovieId: " + movie.getId());
			} else {
				irMovie.nextLine();
			}
		}
		irMovie.close();
		irActor.close();
		irDirector.close();
		irLocation.close();
		irCountry.close();
		irGenre.close();

	}

	public HashMap<String, Movie> getMovies() {

		return movies;

	}

	public HashMap<String, Actor> getActors() {

		return actors;

	}

	public HashMap<String, Director> getDirectors() {

		return directors;

	}

	public HashMap<String, Genre> getGenres() {

		return genres;

	}

	public HashMap<String, CountryOfOrigin> getCountries() {

		return countries;

	}

	public HashMap<String, FilmingLocation> getLocations() {

		return locations;

	}

}