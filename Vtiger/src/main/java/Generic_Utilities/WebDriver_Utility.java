package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	
	/**
	 * Method for implicit wait
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * Method to maximize window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * Method to switch windows
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver,String partialTitle) {
		 Set<String> windows = driver.getWindowHandles();
	        Iterator<String> it = windows.iterator();
	        
	        while(it.hasNext())
	        {
	        	String win = it.next();
	        	driver.switchTo().window(win);
	        	String currentTitle = driver.getTitle();
	        	if(currentTitle.contains(partialTitle))
	        	{
	        		break;
	        	}
	        	
	        	
	        }
	}
	
	/**
	 * This Method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method is used to dismiss the alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This Method is used to mouse hover
	 * @param driver
	 */
	public void mouseHoverElement(WebDriver driver,WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public static String takeScreenShot(WebDriver sdriver,String screenshotName) throws Throwable {
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File des= new File("./Screenshots/failed"+screenshotName+".png");
		FileUtils.copyFile(src, des);
		return des.getAbsolutePath();
	}

}
