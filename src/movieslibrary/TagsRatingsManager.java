package movieslibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TagsRatingsManager {

	private String path;	
	private HashMap<String,Tag > tags;
	
	public TagsRatingsManager(String path, HashMap<String,Tag > tags){
		
		this.path = path;
		tags = new HashMap<String, Tag>();
		
	}
	
	public boolean connectFiles(){
		
		DataSetManager dManager = new DataSetManager(path);
		if(dManager.connect()){
			return true;
		}else{
			return false;
		}
		
	}
	
	@SuppressWarnings("unused")
	public void readTags(){
		
		Scanner irTag = null;
		Scanner irMovieTags = null;
		Scanner irUserTageT = null;
		Scanner irUserTagMovie = null;
		Scanner irRating = null;
		Scanner irRatingTimestamp = null;
		Scanner irMovie = null;
		try{

			irTag = new Scanner(new FileInputStream(path + "\\tags.dat"));

		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{
			irMovieTags = new Scanner(new FileInputStream(path + "\\movie_tags.dat")); 
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{
			irUserTageT = new Scanner(new FileInputStream(path + "\\user_taggedmovies-timestamps.dat")); 
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{
			irUserTagMovie = new Scanner(new FileInputStream(path + "\\user_taggedmovies.dat")); 
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{
			irRating = new Scanner(new FileInputStream(path + "\\user_ratedmovies.dat")); 
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{
			irRatingTimestamp = new Scanner(new FileInputStream(path + "\\user_ratedmovies-timestamps.dat")); 
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		try{//for movie

			irMovie = new Scanner(new FileInputStream(path + "\\movies.dat"));

		}catch(FileNotFoundException e){
			System.out.println("Movies.dat was not found!");
			System.exit(0);
		}
		while(irMovie.hasNextLine()){
			String[] tagData;
			String[] valueTagData;
			
			String line = irMovie.nextLine();
			String[] movieData =  line.split("\t");
			
			if(movieData[0] !=""){		     
				Movie movie = new Movie(movieData[0], movieData[1], movieData[5]);
				
				irUserTagMovie.nextLine();
				while(irUserTagMovie.hasNext(movie.getId())){
					
					String aLine = irUserTagMovie.nextLine();
					tagData = aLine.split("\t");
					if(tagData.length >= 1){
						Tag tag;
						String tLine = irTag.nextLine();
						valueTagData = tLine.split("\t");
						
						if(!tags.containsKey(tagData[2])){
							
							tag = new Tag(tagData[3], tagData[0], valueTagData[1]);
							tags.put(tagData[2], tag);
						}else{
							tag = tags.get(tagData[2]);		    		
						}	 		    			
					 } 

					}
				}
			}
	}		
				
}
