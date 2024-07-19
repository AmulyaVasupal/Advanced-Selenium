package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateContactWithOranganisation {

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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
	}

}
