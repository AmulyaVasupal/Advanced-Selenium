package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExamples1 {

	public static void main(String[] args) {

         WebDriver driver = new ChromeDriver();
         driver.get("https://www.flipkart.com/search?q=phone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
         String phoneName = driver.findElement(By.xpath("//div[text()='KARBONN K9']")).getText();
         
         String phonePrice = driver.findElement(By.xpath("//div[text()='KARBONN K9']/../following-sibling::div//div[@class='Nx9bqj _4b5DiR']")).getText();
         System.out.println(phoneName +" - "+phonePrice);
         
         driver.quit();

	}

}
