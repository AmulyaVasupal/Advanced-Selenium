package Practice;

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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.VtigerLoginPage;

public class CreateCampDummy {

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
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		VtigerLoginPage vlp = new VtigerLoginPage(driver);		
		vlp.loginToVtigerApp(USERNAME, PASSWORD);
		
		//Create Products
        driver.findElement(By.linkText("Products")).click();
		
		
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		Thread.sleep(2000);
		//----------harcoding----------
		//Random ran = new Random();
		//int rnum = ran.nextInt(1000);
		//---------generic------------
		Java_Utility jlib = new Java_Utility();
		int rnum = jlib.getRandomNum();
		
		Excel_Utility exe = new Excel_Utility();
		String prodName = exe.getExcelData("Product", 0, 0)+rnum;
		
		
		driver.findElement(By.name("productname")).sendKeys(prodName);
		//save button
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Create Campaign
		Actions a = new Actions(driver);
		WebElement more = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
		a.moveToElement(more).perform();
		Thread.sleep(5000);
		WebElement camp = driver.findElement(By.name("Campaigns"));
		a.click(camp).perform();
		
		
		driver.findElement(By.cssSelector("img[title='Create Campaign...']")).click();
		Thread.sleep(2000);
		
		
		
		Excel_Utility exe1 = new Excel_Utility();
		String campName = exe1.getExcelData("Campaign", 0, 0)+rnum;
		
		driver.findElement(By.name("campaignname")).sendKeys("campName");
		
        
		//adding product to campign
        driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();
        
   
        wlib.windowSwitching(driver, "Products&action");
        
        
        
        driver.findElement(By.id("search_txt")).sendKeys(prodName);
        driver.findElement(By.name("search")).click();
      //a[text()='Marketing155-1681027917']
        driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
        
        //System.out.println(driver.getTitle());
        
        wlib.windowSwitching(driver, "Campaign&action"); 
		
		//save button
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
        
        //sign out
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement((By.linkText("Sign Out"))).click();
		

	}

}


