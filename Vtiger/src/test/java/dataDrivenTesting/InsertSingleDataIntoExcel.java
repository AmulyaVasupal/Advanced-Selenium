package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		
        FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\Test.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet shet = book.getSheet("Sheet1");
		
		Row row = shet.createRow(3);
		
		Cell cell = row.createCell(4);
		
		cell.setCellValue("Bluetooth");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\Test.xlsx");
		book.write(fos);
		book.close();
		

	}

}
