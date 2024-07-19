package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css ="img[title='Create Organization...']")
	private WebElement CreateButton;
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(id="phone")
	private WebElement PhoneNum;
	
	@FindBy(id="email1")
	private WebElement EmailId;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;

	public WebElement getCreateButton() {
		return CreateButton;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getPhoneNum() {
		return PhoneNum;
	}

	public WebElement getEmail() {
		return EmailId;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void clickCreateOragButton() {
		CreateButton.click();
	}
	
	public void enterOragData(String oragName, String phone, String email) {
		OrganizationName.sendKeys(oragName);
		PhoneNum.sendKeys(phone);
		EmailId.sendKeys(email);
	}
	
	public void clickSaveButton() {
		SaveButton.click();
	}

}
