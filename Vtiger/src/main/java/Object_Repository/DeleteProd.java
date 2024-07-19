package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProd {
	
	public DeleteProd(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deletePrd;

	public WebElement getDeletePrd() {
		return deletePrd;
	}
	
	public void clickDelete() {
		deletePrd.click();
	}
	
	public void selectTheProdToDelete(WebDriver driver, String prodName) {
		//traversing through, first table->product name header->checkbox header
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+prodName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
		
	}
	

}
