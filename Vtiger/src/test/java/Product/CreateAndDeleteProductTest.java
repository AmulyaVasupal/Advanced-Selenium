package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.DeleteProd;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateAndDeleteProductTest extends BaseClass {
    @Test
	public void CreateAndDeleteProductTest() throws Throwable {
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		Thread.sleep(2000);
		
		int rnum = jlib.getRandomNum();
		
		String prodName = exe.getExcelData("Product", 0, 0)+rnum;
		
		
		CreateProductPage prod = new CreateProductPage(driver);
		prod.clickCreateProdButton();
		prod.enterProdData(prodName);
		prod.clickProdSaveButton();
		
		home.clickProductLink();
		Thread.sleep(3000);
		
		DeleteProd delPrd = new DeleteProd(driver);
		delPrd.selectTheProdToDelete(driver, prodName);
		delPrd.clickDelete();
		//handle popup
		wlib.alertAccept(driver);
		
		
      
	}

}
