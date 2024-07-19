package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet2");
		
		LinkedHashMap<String, String> map;
		map = new LinkedHashMap<String, String>();
		map.put("10","Shoba");
		map.put("20","amogh");
		map.put("30","anu");
		
		int rowNo = 0;
		
		for(Entry<String, String> m : map.entrySet())
		{
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(m.getKey());
			row.createCell(1).setCellValue(m.getValue());
			
		}
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\Test.xlsx");
		book.write(fos);
		book.close();

	}

}
