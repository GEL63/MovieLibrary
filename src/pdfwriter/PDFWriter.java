package pdfwriter;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter {
	
	public int writePdfFile(String title, List<String> strList, String fileName){		
		
		Document document = null;
		PdfWriter writer = null;
		try{	
			document = new Document(PageSize.A4);
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			
			Font myfont = new Font();
	        myfont.setStyle(Font.NORMAL);
	        myfont.setSize(11);
	        addTitlePage(document, title);
	        document.add(new Paragraph("\n"));
	        
	        Section subCatPart = null;
			//createTable(subCatPart, strList);   
			//document.add(subCatPart);
		}catch(Exception e){
			return -1;			
		}
		document.close();
	    writer.close();  	
		System.out.println("All good");
		return 1;
	}

	private static void addTitlePage(Document document, String title)throws DocumentException{
		
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph,1);
		Font myFont = new Font(); myFont.setStyle(Font.NORMAL); myFont.setSize(11);
		paragraph.add(new Paragraph(title, myFont));
		addEmptyLine(paragraph,1);
		document.add(paragraph);
		document.newPage();
		
	}
	
	private static void addEmptyLine(Paragraph paragraph, int number) {
		
		for(int i = 0; i < number; i++){
			paragraph.add(new Paragraph(" "));
		}
		
	}
	private static void createTable(Section subCatPart, List<String> strList)throws BadElementException{
		PdfPTable table = new PdfPTable(4);
				
		PdfPCell c1 = new PdfPCell(new Phrase("Title"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Year"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Country"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Directors"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
		
		for(String str:strList){
			String[] arStr = str.split("/n");
			for(String s:arStr){
				table.addCell(s);
			}
		}
		subCatPart.add(table);
	}
}
