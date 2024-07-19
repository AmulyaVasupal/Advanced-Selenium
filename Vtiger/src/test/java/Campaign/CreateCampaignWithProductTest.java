package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
import Object_Repository.CampWithWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void createCampaignWithProductTest() throws Throwable {
			
		//Create Products Page
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		Thread.sleep(2000);
		int rnum = jlib.getRandomNum();
		
		//get prod name
		String prodName = exe.getExcelData("Product", 0, 0)+rnum;
		
		//prod craete
		CreateProductPage prod = new CreateProductPage(driver);
		prod.clickCreateProdButton();
		prod.enterProdData(prodName);
		prod.clickProdSaveButton();
		
		//Create Campaign page
        WebElement more = home.getMoreLink();
		
		wlib.mouseHoverElement(driver, more);
		Thread.sleep(5000);
		
		home.clickCampaignLink();
		
		
		Thread.sleep(2000);
		
		
		//get cam name
		Excel_Utility exe1 = new Excel_Utility();
		String campName = exe1.getExcelData("Campaign", 0, 0)+rnum;
		
        CreateCampaignPage camp = new CreateCampaignPage(driver);
		
		camp.clickCreateCampButton();
		camp.enterCampData(campName);
		
        
		//adding product to campign
        CampWithWindowSwitching winSwitching = new CampWithWindowSwitching(driver);
        winSwitching.clickProdPlusButton();
   
        wlib.windowSwitching(driver, "Products&action");
        
        winSwitching.enterSearchText(prodName);
        winSwitching.clickSearchButton();
        winSwitching.clickDynamicProdName(driver, prodName);
      
        
        wlib.windowSwitching(driver, "Campaign&action"); 
		
		//save button
		camp.clickSaveButton();
       

	}

}
