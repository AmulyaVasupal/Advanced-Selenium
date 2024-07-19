package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataToPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		
		//---------------------WRITING-----------------------------------------------
		FileInputStream fis1 = new FileInputStream("./src/test/resources/PropertiesData.properties");
		Properties p1 = new Properties();
		p1.load(fis1);
		
		p1.setProperty("url", "https://www.saucedemo.com/v1/");
		p1.setProperty("username", "standard_user");
		p1.setProperty("password", "secret_sauce");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesData.properties");
		p1.store(fos, "CommonData");
		System.out.println("Data added");
		
		
		
		
		//----------------------------READING-----------------------------------------------------
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

	}

}
