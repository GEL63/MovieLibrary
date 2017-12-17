package movieslibrary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class PresentationManager {
	// creates the files

	public int createTextFile(List<String> strList, String fileName) {

		PrintWriter outputWriter = null;

		try {
			outputWriter = new PrintWriter(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			return -1;
		}
		System.out.print("Writing to file... ");
		for(String movieString:strList){
			String[] arMovie = movieString.split("\n");
			for(String str:arMovie)
				outputWriter.println(str);
			outputWriter.println();
		}
		outputWriter.close();

		System.out.println("End of writing!");
		return 1;// all good
	}

	public void creatHtmlFile(List<String> strList, String fileName) {

	}

	public void createMarkdownFile(List<String> strList, String fileName) {

	}

}
