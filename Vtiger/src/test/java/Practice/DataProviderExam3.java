package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class DataProviderExam3 {
	
	@Test(dataProvider = "getReadData")
	public void createOrganization(String orgName,String email, String phnNum) throws Throwable {
		
		WebDriver driver;
		File_Utility flib =new File_Utility();
		String URL = flib.getKeyAndValuePair("url");
	    String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		
        String BROWSER = flib.getKeyAndValuePair("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else
		{
			if(BROWSER.equalsIgnoreCase("edge")) {
				 driver= new EdgeDriver();
			}
			else
			{
				driver = new ChromeDriver();
			}
		}
		driver.get(URL);
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximiseWindow(driver);
		wlib.implicitWait(driver);
		
		VtigerLoginPage vlp = new VtigerLoginPage(driver);		
		vlp.loginToVtigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrganizationLink();
		
		Thread.sleep(2000);
		
		Java_Utility jlib = new Java_Utility();
		int rnum = jlib.getRandomNum();
		
		orgName = orgName +rnum;
		
		CreateOrganizationPage org = new CreateOrganizationPage(driver);
		org.clickCreateOragButton();
		org.enterOragData(orgName, phnNum, email);
		org.clickSaveButton();
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	
	@DataProvider
	public Object[][] getReadData() throws Throwable{
		
		Excel_Utility elib = new Excel_Utility();
		Object[][] obj = elib.getExcelDataUsingDataProvider("DataProvider");
		return obj;
	}
}


