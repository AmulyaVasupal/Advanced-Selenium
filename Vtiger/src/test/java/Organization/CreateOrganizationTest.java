package Organization;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utilities.ListenerImplementations.class)

public class CreateOrganizationTest extends BaseClass {
	
    //@Test(groups =  {"smokeTest","regressionTest"})
	//@Test(retryAnalyzer= Generic_Utilities.RetryAnalyserImp.class)
	@Test
	public void CreateOrganizationTest() throws Throwable {
	
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrganizationLink();
		
		Thread.sleep(2000);
		
		int rnum = jlib.getRandomNum();
		
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
		

	}
    
    //@Test(groups =  {"smokeTest","regressionTest"})
	@Test
	public void TestRegional() {
    	System.out.println("reginal test");
    }
    
    
    

}
