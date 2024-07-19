package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * Reading Single data from excel 
	 * @param SheetName
	 * @param RowNum
	 * @param CellName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 * @author Amulya
	 */
	public String getExcelData(String SheetName,int RowNum,int CellName) throws Throwable, IOException {
		
        FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\TestExcelProject.xlsx");
		

		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet(SheetName);
		
		Row row = sheet.getRow(RowNum);
		
		Cell cell = row.getCell(CellName);
		
		String excelValue = cell.getStringCellValue();
		return excelValue;
	}
	
	/**
	 * Reading Single data from excel using DataFormatter
	 * @param SheetName
	 * @param RowNum
	 * @param CellName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 * @author Amulya
	 */
	public String getExcelDataUsingDataFormatter(String SheetName,int RowNum,int CellName) throws Throwable, IOException {
		
        FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\TestExcelProject.xlsx");
		

		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet(SheetName);
		
		Row row = sheet.getRow(RowNum);
		
		Cell cell = row.getCell(CellName);
		
	    DataFormatter d = new DataFormatter();
	    String excelValue = d.formatCellValue(cell);
	    return excelValue;
	}
	
	
	public Object[][] getExcelDataUsingDataProvider(String SheetName) throws Throwable {
        FileInputStream fis = new FileInputStream("C:\\Users\\scrap\\Documents\\Amulya\\Java\\Advanced\\TestExcelProject.xlsx");
		

		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet(SheetName);
		
		int lastRow = sheet.getLastRowNum()+1;
		
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object [lastRow][lastCell];
		
		for (int i = 0 ;i< lastRow;i++) {
			for (int j = 0; j<lastCell;j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}

}
