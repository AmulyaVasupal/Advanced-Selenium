package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDateFromExcel {

	public static void main(String[] args) throws Throwable {
		
        FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\CampaignName.xlsx");
		

		Workbook book = WorkbookFactory.create(fis);
		
		Sheet shet = book.getSheet("Sheet1");
		
		Row row = shet.getRow(0);
		
		Cell cell = row.getCell(0);
		
		String campName = cell.getStringCellValue();
		System.out.println(campName);

	}

}
