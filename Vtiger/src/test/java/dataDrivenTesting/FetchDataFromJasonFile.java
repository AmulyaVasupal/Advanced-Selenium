package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJasonFile {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/JosnFile.jason");
		
		ObjectMapper jasondata= new ObjectMapper();
		
		JsonNode data = jasondata.readTree(file);
		
		String URL = data.get("url").asText();
		String UN = data.get("username").asText();
		String PASS = data.get("password").asText();
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(UN);
		driver.findElement(By.id("password")).sendKeys(PASS);
		driver.findElement(By.className("btn_action")).click();
		

	}

}
