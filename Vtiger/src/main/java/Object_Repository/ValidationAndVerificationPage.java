package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class ValidationAndVerificationPage {
	
	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public void orgValidation(WebDriver driver, String data) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actData.contains(data)){
			System.out.println("Org data validated");
		}
		else
		{
			System.out.println("Org data not validated");
		}
		/*Assertion a = new Assertion();
		a.assertEquals(data, "asdd");*/
	}

}
