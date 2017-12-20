package pdfwriter;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter {

	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

	public int writePdfFile(String title, List<String> strList, String fileName) {

		Document document = null;
		PdfWriter writer = null;
		try {
			document = new Document(PageSize.A4);
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			PdfPTable table = createTable(document, title, strList);
			document.add(table);
		} catch (Exception e) {
			return -1;
		}
		document.close();
		writer.close();
		System.out.println("All good");
		return 1;

	}

	private static PdfPTable createTable(Document document, String title,
		List<String> list) throws BadElementException {
        
		PdfPTable table = new PdfPTable(new float[]{40, 10, 20, 30});
		table.setWidthPercentage(100);
		PdfPCell titleCell, cell;

		// Write title
		titleCell = new PdfPCell(new Paragraph(title, catFont));
		titleCell.setColspan(4);
		titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(titleCell);

		// Write Header of Table
		cell = new PdfPCell(new Paragraph("Title", subFont));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Year", subFont));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Country", subFont));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Directors", subFont));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		table.setHeaderRows(1);
		//Write rows of Table
		for (String phrase : list) {
			String[] chunks = phrase.split("\n");
			for (String chunk : chunks) {
				cell = new PdfPCell(new Paragraph(chunk, subFont));
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
			}
		}
		return table;
		
	}

}