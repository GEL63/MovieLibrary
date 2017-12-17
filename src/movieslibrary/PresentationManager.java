package movieslibrary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PresentationManager{ 
	//creates the files

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
	
	public int creatHtmlFile(List<String> strList, String fileName, String title, int numRows, int numCols ){
		//String[][] raster,
		String header = new String("");
		header.concat("<!doctype html>");
		header.concat("\n");
		header.concat("<html>");
		header.concat("\n");
		header.concat("<head>");
		header.concat("\n");
		header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
		header.concat("\n");
		header.concat(title);
		header.concat("\n");
		header.concat("</head>");
		header.concat("\n");
		header.concat("<body>");
		header.concat("\n");
		
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName)); // APPEND would be .... (new FileOutputStream(outputFileName, true));
			outputStream.println(header);

			outputStream.println("<table>");

			for(int i =0; i < numRows; i++){
				outputStream.println("<tr>");
				for(int j =0; j < numCols; j++){
					outputStream.print("<td>"+/*raster[i][j]+*/"</td>");
				}
				outputStream.println("\n</tr>");
			}
			outputStream.println("</table>");
			outputStream.println("</body>\n</html>");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			return -1;
		}
		return 1;
	}
	
	public int createMarkdownFile(List<String> strList, String fileName, int lineWidth){
	
		 if (strList == null)
		      return -1;      // Should we return an empty string?
		    
		    final String lineEndings;
		    if ( strList.get(0).endsWith ("\r\n") )
		      lineEndings = "\r\n";
		    else if ( strList.get(0).endsWith ("\r") )
		      lineEndings = "\r";
		    else
		      lineEndings = StrUtils.LINEEND;
		    
		    final StringBuilder buf = new StringBuilder();
		    for (String line : strList) {
		      buf.append (line);
		      buf.append (' ');     // We can add extra spaces with impunity, and this
		                            // makes sure our lines don't run together.
		    }
		return format ( buf.toString(), lineWidth, lineEndings )
		
	}
	public static String format ( final String text, final int lineWidth)
	  {
	    return format(text, lineWidth, StrUtils.LINEEND);
	}
	
}
