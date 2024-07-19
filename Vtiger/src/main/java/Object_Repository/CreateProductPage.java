package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css ="img[title='Create Product...']")
	private WebElement CreateProdButton;
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveButton;


	public WebElement getCreateProdButton() {
		return CreateProdButton;
	}


	public WebElement getProductName() {
		return ProductName;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void clickCreateProdButton() {
		CreateProdButton.click();
	}
	
	public void enterProdData(String prodName) {
		ProductName.sendKeys(prodName);
	}
	
	public void clickProdSaveButton() {
		SaveButton.click();
	}
	
	
}
