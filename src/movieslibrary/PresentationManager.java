package movieslibrary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import pdfwriter.PDFWriter;

public class PresentationManager{ 

	public int createTextFile(String title, List<String> strList, String fileName) {

		PrintWriter outputWriter = null;
		try {
			outputWriter = new PrintWriter(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			return -1;
		}
		System.out.print("Writing to file... ");
		
		outputWriter.println(title);
		for(String movieString:strList){
			String[] arMovie = movieString.split("\n");
			outputWriter.println("\nTitle: \t\t\t" + arMovie[0]); 
			outputWriter.println("\nYear of Prodution: \t" + arMovie[1]); 
			outputWriter.println("\nCountry of Origin: \t" + arMovie[2]);
			outputWriter.println("\nDirectors: \t\t" + arMovie[3]);
			outputWriter.println();
		}
		outputWriter.close();
		System.out.println("End of writing!");
		return 1;// all good
		
	}
	
	public int createHtmlFile(String title, List<String> strList, String fileName){
		
		String header = new String("");
		header = header.concat("<!DOCTYPE html>\n");
		header = header.concat("<html>\n");
		header = header.concat("<head>"+ title + "</head>\n");
		header = header.concat("<body>\n");
		
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
			outputStream.println(header);

			outputStream.println("<table>\n");
			outputStream.println("<tr>\n");
			outputStream.println("<td>Title</td><td>Year</td><td>Country</td><td>Director</td>");
			outputStream.println("</tr>\n");
			outputStream.println("<tr>\n");
			outputStream.println("<td>--------</td><td>--------</td><td>--------</td><td>--------</td>");
			outputStream.println("</tr>\n");
			for(String str:strList){
				String[] aStr = str.split("\n");
				outputStream.println("<tr>\n");
				for(String s:aStr){
					outputStream.print("<td>"+ s + "</td>");
				}
				outputStream.println("\n</tr>");
			}
			outputStream.println("</table>\n</body>\n</html>");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			return -1;
		}
		return 1;
	}
	
	public int createMarkdownFile(String title, List<String> strList, String fileName){
		  
		  try {
		   PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
		   outputStream.println(title);
		   outputStream.println("-------------------");
		   outputStream.println("Title | Year | Country | Director");
		   outputStream.println("----- | ----- |-------- | --------");
		   
		   for(String str:strList){
		    
		    String[] aStr = str.split("\n");
		    outputStream.println(aStr[0] + " | " + aStr[1] + " | " + aStr[2] + " | " +aStr[3]);
		    
		   }
		   outputStream.close();
		  } catch (FileNotFoundException e) {
		   System.out.println("Problem opening files.");
		   return -1;
		  }
		  return 1;
		    
		 }
	
	public int createPdfFile(String title, List<String> strList, String fileName){
		PDFWriter pdfWriter= new PDFWriter();
		pdfWriter.writePdfFile(title, strList, fileName);
		return 1;
		
	}
	
}
