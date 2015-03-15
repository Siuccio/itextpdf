/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package part1.chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
 
public class MyFirstTable {
 
    /** The resulting PDF file. */
    public static final String RESULT
        = "test.pdf";

    

    public static void main(String[] args)
        throws IOException, DocumentException {
    	List<String> headers=new ArrayList<String>();
    	headers.add("Nome");
    
    	List<List<String>> details=new ArrayList<List<String>>();
    	List<String> riga1=new ArrayList<String>();
    	riga1.add("test");
      	List<String> riga2=new ArrayList<String>();
    	riga1.add("alessio");
    	List<String> riga=new ArrayList<String>();
    	for(int i=0;i<100;i++)
    	{
    		riga=new ArrayList<String>();
    		riga.add(i+"");
    		details.add(riga);
    	}
    	details.add(riga1);
    	details.add(riga2);
    	String title="TEST TITLE";
        new MyFirstTable().createPdf(RESULT,title,headers,details);
        
    }
 

    public void createPdf(String filename,String title,List<String> headers,List<List<String>> details)
        throws IOException, DocumentException {
        Document document = new Document();
        document.open();
        Paragraph p
        = new Paragraph(title, new Font(FontFamily.HELVETICA, 22));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        p.setSpacingAfter(10);
        document.add(createTable(headers,details));

        document.close();
    }
 

    
    private PdfPTable createTable(List<String> headers,List<List<String>> details)
    {
    	PdfPTable table = new PdfPTable(headers.size());
    	table.setSpacingBefore(100);
    	setHeader(headers,table);
    	setDetails(details, table);
    	return table;
    }
    
    private void setHeader(List<String> headers,PdfPTable table){
    	PdfPCell cell;
    	for(String header:headers){
      
            cell = new PdfPCell(new Phrase(header));
            table.addCell(cell);
           
           
    	}
    	
    }
    
    
    private void setDetails(List<List<String>> details,PdfPTable table)
    {
    	PdfPCell cell;
    	for(List<String> riga:details)
    	{
    		for(String colonna:riga){
    			cell = new PdfPCell(new Phrase(colonna));
    	        table.addCell(cell);
    		}
    			
    	}
    }
    
    
    
    
}