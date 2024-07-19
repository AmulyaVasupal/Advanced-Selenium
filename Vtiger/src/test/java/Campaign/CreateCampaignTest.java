package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
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

import com.mysql.cj.jdbc.Driver;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignTest extends BaseClass {
	
    @Test(groups = "smokeTest")
	public void createCampaignTest() throws Throwable {

		VtigerHomePage home = new VtigerHomePage(driver);
		WebElement more = home.getMoreLink();
		
		wlib.mouseHoverElement(driver, more);
		Thread.sleep(5000);
		
		home.clickCampaignLink();
		
		Thread.sleep(2000);
	
		int rnum = jlib.getRandomNum();
		
		String campName = exe.getExcelDataUsingDataFormatter("Campaign", 0, 0)+rnum;
		
		CreateCampaignPage camp = new CreateCampaignPage(driver);
		
		camp.clickCreateCampButton();
		camp.enterCampData(campName);
		camp.clickSaveButton();
		
		Thread.sleep(5000);
		
	}

}
