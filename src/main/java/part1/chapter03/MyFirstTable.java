/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package part1.chapter03;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class MyFirstTable {
 
    /** The resulting PDF file. */
    public static final String RESULT
        = "C:\\Users\\Administrator\\Desktop\\test.pdf";
 
    /** The number of locations on our time table. */
    public static final int LOCATIONS = 9;
    /** The number of time slots on our time table. */
    public static final int TIMESLOTS = 32;
 
    /** The offset to the left of our time table. */
    public static final float OFFSET_LEFT = 76;
    /** The width of our time table. */
    public static final float WIDTH = 240;
    /** The offset from the bottom of our time table. */
    public static final float OFFSET_BOTTOM = 36;
    /** The height of our time table */
    public static final float HEIGHT = 10;
 
    /** The offset of the location bar next to our time table. */
    public static final float OFFSET_LOCATION = 26;
    /** The width of the location bar next to our time table. */
    public static final float WIDTH_LOCATION = 48;
 
    /** The height of a bar showing the movies at one specific location. */
    public static final float HEIGHT_LOCATION = HEIGHT / LOCATIONS;
    /** The width of a time slot. */
    public static final float WIDTH_TIMESLOT = WIDTH / TIMESLOTS;
    
    protected BaseFont bf;
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        new MyFirstTable().createPdf(RESULT);
        
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	bf = BaseFont.createFont();
    	Font f = new Font(bf, HEIGHT_LOCATION / 2);
        f.setColor(BaseColor.WHITE);

    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        Paragraph p
        = new Paragraph("TITOLO", new Font(FontFamily.HELVETICA, 22));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        p.setSpacingAfter(10);

        // step 4
        document.add(createFirstTable());
        


        // step 5
        document.close();
    }
 
    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(7);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
      /*  cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");*/
        
        
        cell = new PdfPCell(new Phrase("A"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("B"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("C"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("D"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("E"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("F"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("G"));
        table.addCell(cell);
        table.setSpacingBefore(100);
        return table;
    }
   
    protected void drawInfo(PdfContentByte directcontent) {
        directcontent.beginText();

        directcontent.setFontAndSize(bf, 18);
        directcontent.showTextAligned(Element.ALIGN_CENTER,
            "FOOBAR FILM FESTIVAL", 10, 10, 0);

        directcontent.endText();
    }
}