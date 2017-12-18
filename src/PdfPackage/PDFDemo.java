package PdfPackage;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter {
	
	public int createPdfFile(List<String> strList, String fileName){		
		
		Document pdfDoc = null;
		PdfWriter writer = null;
		try{	
			pdfDoc = new Document(PageSize.A4);
			writer = PdfWriter.getInstance(pdfDoc, new FileOutputStream(fileName));
			pdfDoc.open();
			
			Font myfont = new Font();
	        	myfont.setStyle(Font.NORMAL);
	        	myfont.setSize(11);
	        
	        	pdfDoc.add(new Paragraph("\n"));
	        	for (String i : strList) {
	        		while(i != null){
	        			Paragraph para = new Paragraph(i  + "\n", myfont);
	                		para.setAlignment(Element.ALIGN_JUSTIFIED);
	                		pdfDoc.add(para);
	            		}
	        	}       
		}catch(Exception e){	
			return -1;			
		}
		 pdfDoc.close();
	     	writer.close();  	
	        	
		System.out.println("All good");
		return 1;
	}
}
