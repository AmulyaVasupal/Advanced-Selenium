package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css ="img[title='Create Campaign...']")
	private WebElement CreateButton;
	
	@FindBy(name="campaignname")
	private WebElement CampaignName;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveButton;


	public WebElement getCreateButton() {
		return CreateButton;
	}


	public WebElement getCampaignName() {
		return CampaignName;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void clickCreateCampButton() {
		CreateButton.click();
	}
	
	public void enterCampData(String campName) {
		CampaignName.sendKeys(campName);
	}
	
	public void clickSaveButton() {
		SaveButton.click();
	}

}
