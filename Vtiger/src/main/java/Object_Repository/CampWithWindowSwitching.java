package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampWithWindowSwitching {
	
	public CampWithWindowSwitching(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css ="img[src='themes/softed/images/select.gif']")
	private WebElement ProdPlusButton;
	
	@FindBy(id ="search_txt")
	private WebElement SearchTextField;
	
	@FindBy(name ="search")
	private WebElement SearchButton;

	public WebElement getProdPlusButton() {
		return ProdPlusButton;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	public void clickProdPlusButton() {
		ProdPlusButton.click();
	}
	
	public void enterSearchText(String name) {
		SearchTextField.sendKeys(name);
	}
	
	public void clickSearchButton() {
		SearchButton.click();
	}	
	
	public void clickDynamicProdName(WebDriver driver, String prodName) {
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
	}

}
