package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import movieslibrary.DataSetManager;
import movieslibrary.Movie;
import movieslibrary.PresentationManager;
import movieslibrary.QueryManager;

public class MovieLibrary {

	static final String PATH = "C:\\Users\\toshiba\\workspace\\MovieLibrary\\DataSet";
	static final boolean DEBUG = true;

	public static void main(String[] args) {

		DataSetManager dataSetManager = new DataSetManager(PATH);
		Scanner keyboard = new Scanner(System.in);
		int userInputMain;
		
		do {
			System.out.println("\n\nMain menu:\n------------------------------\n\n" 
									+ " 1. Read data\n"
									+ " 2. Make a question\n" 
									+ " 3. Exit ");
			System.out.print("\nMake a choice: ");
			try {
				userInputMain = keyboard.nextInt();
			} catch (InputMismatchException e) {
				flushKeyboard(keyboard);
				userInputMain = 0;
			}
			
			switch(userInputMain){
			case 1:
				if (!dataSetManager.connect()) {
					System.out.println("Path or file does not exist!");
				} else {
					System.out.print("\nSuccessfully connected!\nReading data. Please wait...");
					dataSetManager.readData();
					System.out.println(" Successfully read " + dataSetManager.getMovies().size() + " movies.");
				}
				break;
			case 2:
				int userInputQuery;
				do {
					System.out.println("\nQuery menu:\n------------------------------\n\n" + ""
							+ " 1. Search by id\n" 
							+ " 2. Search by title\n"
							+ " 3. Search by genre\n"
							+ " 4. Search by country of origin\n"
							+ " 5. Search by actor\n"
							+ " 6. Search by director\n" 
							+ " 7. Back");
					System.out.print("\nMake a choice: ");
					try {
						userInputQuery = keyboard.nextInt();
					} catch (InputMismatchException e) {
						flushKeyboard(keyboard);
						userInputQuery = 0;
					}
					
					QueryManager queryManager = new QueryManager(dataSetManager);
					switch (userInputQuery) {
					case 1:
						System.out.print("\nEnter movie id: ");
						flushKeyboard(keyboard);
						Integer userInputMovieId = keyboard.nextInt();

						Movie movie = queryManager.searchById(userInputMovieId.toString());
						if (movie != null) {
							ArrayList<String> strList = new ArrayList<String>();
							strList.add(movie.toString());
							askForm(strList, keyboard);
							
							if(DEBUG) System.out.println("\n" + movie);
						} else {
							System.out.println("Movie does not exist! Try again.");
						}
						break;
					case 2:
						System.out.print("\nEnter a movie title: ");
						flushKeyboard(keyboard);
						String userInputTitle = keyboard.nextLine();
						Movie theMovie = queryManager.searchByTitle(userInputTitle);
						if (theMovie != null) {
							ArrayList<String> strList = new ArrayList<String>();
							strList.add(theMovie.toString());
							askForm(strList, keyboard);
							
							if(DEBUG) System.out.println("\n" + theMovie.toString());
						} else {
								System.out.println("\nMovie does not exist! Try again.\n");
						}
						break;
					case 3:
						System.out.print("\nEnter a movie genre: ");// TODO:use this code
						flushKeyboard(keyboard);
						String userInputGenre = keyboard.nextLine();
						HashMap<String, Movie> moviesOfGenre = queryManager.searchByGenre(userInputGenre);

						if (moviesOfGenre != null) {
							ArrayList<String> strList = new ArrayList<String>();
							for (String movieId : moviesOfGenre.keySet()) {
								Movie aMovie = moviesOfGenre.get(movieId);
								strList.add(aMovie.toString());// use to PresentationManager(the list)
							}
							System.out.println(moviesOfGenre.size() + " number of movies found." );
							askForm(strList, keyboard);
							
							if(DEBUG){
								for (int i = 0; i < strList.size(); i++) 
									System.out.println(strList.get(i));
								System.out.println("The number of movies is: " + moviesOfGenre.size());
							}
						} else {
							System.out.println("Genre does not exist! Try again.");
						}
						break;
					case 4:
						System.out.print("\nEnter movie's country of origin: ");
						flushKeyboard(keyboard);
						String userInputOrigin = keyboard.nextLine();
						HashMap<String, Movie> moviesOfCountry = queryManager.searchByCountry(userInputOrigin);

						if (moviesOfCountry != null) {
							ArrayList<String> strList = new ArrayList<String>();
							for (String movieId : moviesOfCountry.keySet()) {
								Movie aMovie = moviesOfCountry.get(movieId);
								strList.add(aMovie.toString());
							}
							System.out.println(moviesOfCountry.size() + " number of movies found." );
							askForm(strList, keyboard);
							
							if(DEBUG){
								for (int i = 0; i < strList.size(); i++) 
									System.out.println(strList.get(i));
								System.out.println("The number of movies is: " + moviesOfCountry.size());
							}
						} else {
							System.out.println("Country does not exist! Try again.");
						}
						break;
					case 5:
						System.out.print("\nEnter name of actor: ");
						flushKeyboard(keyboard);
						String userInputActor = keyboard.nextLine();
						HashMap<String, Movie> moviesOfActor = queryManager.searchByActor(userInputActor);

						if (moviesOfActor != null) {
							ArrayList<String> strList = new ArrayList<String>();
							for (String movieId : moviesOfActor.keySet()) {
								Movie aMovie = moviesOfActor.get(movieId);
								strList.add(aMovie.toString());
							}
							System.out.println(moviesOfActor.size() + " number of movies found." );
							askForm(strList, keyboard);
							
							if(DEBUG){
								for (int i = 0; i < strList.size(); i++) 
									System.out.println(strList.get(i));
								System.out.println("The number of movies is: " + moviesOfActor.size());
							}
						} else {
							System.out.println("Actor does not exist! Press any key to continue...");
							keyboard.nextLine();
						}
						break;
					case 6:
						System.out.print("\nEnter  name of director: ");
						flushKeyboard(keyboard);
						String userInputDirector = keyboard.nextLine();
						HashMap<String, Movie> moviesOfDirector = queryManager.searchByDirector(userInputDirector);
						if (moviesOfDirector != null) {
							ArrayList<String> strList = new ArrayList<String>();
							for (String movieId : moviesOfDirector.keySet()) {
								Movie aMovie = moviesOfDirector.get(movieId);
								strList.add(aMovie.toString());
							}
							System.out.println(moviesOfDirector.size() + " number of movies found." );
							askForm(strList, keyboard);
							
							if(DEBUG){
								for (int i = 0; i < strList.size(); i++) 
									System.out.println(strList.get(i));
								System.out.println("The number of movies is: " + moviesOfDirector.size());
							}
						} else {
							System.out.println("Director does not exist! Press any key to continue...");
							keyboard.nextLine();
						}
						break;
					case 7:
						break;
					default:
						System.out.println("Wrong choice. Press any key to continue...");
						flushKeyboard(keyboard);
						keyboard.nextLine();
						break;
					}
				}while (userInputQuery != 7 );
				break;
			case 3:
				break;
			default:
				System.out.println("Wrong choice. Press any key to continue...");
				flushKeyboard(keyboard);
				keyboard.nextLine();
				break;
			}
		} while (userInputMain != 3);
		keyboard.close();
	}

	// Asks the question about the form
	// Asks the question about the name of the file
	public static void askForm(ArrayList<String> strList, Scanner keyboard) {
		
		System.out.println("\nPresentation Menu:\n------------------------------\n\n" 
				+ " 1. Text file\n"
				+ " 2. Html file\n" 
				+ " 3. Markdown file\n" 
				+ " 4. Pdf file\n"
				+ " 5. Back");
		System.out.print("\nMake a choice: ");
		int userInput = 0;
		String userAnswerName = "";
		try {
			userInput = keyboard.nextInt();
			System.out.print("Enter file name (without extension): ");
			keyboard.nextLine();
			userAnswerName = keyboard.nextLine();			
		} catch (InputMismatchException e) {
			flushKeyboard(keyboard);
			userInput = 0;
		}
		
		PresentationManager presentationManager = new PresentationManager();
		String title = "Movie Library Application. Matches found : " + strList.size() + " movie(s)";
		switch(userInput){
		case 1:
			presentationManager.createTextFile(title, strList, PATH + "\\" + userAnswerName + ".txt");
			break;
		case 2:
			presentationManager.createHtmlFile(title, strList, PATH + "\\" + userAnswerName + ".html");
			break;
		case 3:
			presentationManager.createMarkdownFile(title, strList, PATH + "\\" + userAnswerName + ".md");
			break;
		case 4:
			presentationManager.createPdfFile(title, strList, PATH + "\\" + userAnswerName + ".pdf");
			break;
		case 5:
			break;
		default:
			System.out.println("Wrong choice. Press any key to continue...");
			keyboard.nextLine();
			break;
		}
	}
	
	private static void flushKeyboard(Scanner keyboard) {
		keyboard.nextLine();
	}

}

