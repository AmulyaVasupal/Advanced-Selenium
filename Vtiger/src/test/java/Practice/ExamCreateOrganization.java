package Practice;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class ExamCreateOrganization {

	public static void main(String[] args) throws Throwable {
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
		
		//driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		Thread.sleep(2000);
		
		
		Java_Utility jlib = new Java_Utility();
		int rnum = jlib.getRandomNum();
		
		Excel_Utility exe = new Excel_Utility();
		String orgName = exe.getExcelDataUsingDataFormatter("Organization", 0, 0)+rnum;
		String email = exe.getExcelDataUsingDataFormatter("Organization", 0, 1);
		String phoneNum = exe.getExcelDataUsingDataFormatter("Organization", 0, 2);
				
		CreateOrganizationPage org = new CreateOrganizationPage(driver);
		org.clickCreateOragButton();
		org.enterOragData(orgName, phoneNum, email);
		org.clickSaveButton();
		
		ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
		validate.orgValidation(driver, orgName);
		
		Thread.sleep(2000);
		home.clickAdmLink();
		home.clickSignOut();
		
		driver.close();
		

	}

}

