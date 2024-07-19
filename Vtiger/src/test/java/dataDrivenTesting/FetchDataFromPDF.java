package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataFromPDF {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/PDFDoc.pdf");
		
		PDDocument doc = PDDocument.load(file);
		
		int pg = doc.getNumberOfPages();
		System.out.println(pg);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		//all pages
		//String d = pdfData.getText(doc);
		//System.out.println(d);
		
		
		//pdfData.setStartPage(2);
		//String singlePageData = pdfData.getText(doc);
		//System.out.println(singlePageData);
		
		pdfData.setStartPage(1);
		pdfData.setEndPage(2);
		String multiplePageData = pdfData.getText(doc);
		System.out.println(multiplePageData);
		
		
	
		
	}

}
