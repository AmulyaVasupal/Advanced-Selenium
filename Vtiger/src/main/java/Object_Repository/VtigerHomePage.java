package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class VtigerHomePage {
	
	
	public VtigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
	@FindBy(name = "Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "More")
	private WebElement MoreLink;

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}


	
	public WebElement getMoreLink() {
		return MoreLink;
	}
	
	
	
	/**
	 * To click Product Link
	 */
	public void clickProductLink() {
		ProductLink.click();
	}
	
	/**
	 * To click Campaign Link
	 */
	public void clickCampaignLink() {
		CampaignLink.click();
	}
	
	/**
	 * To click Organization Link
	 */
	public void clickOrganizationLink() {
		OrganizationLink.click();
	}
	
	/**
	 * To click More Link
	 */
	public void clickMoreLink() {
		MoreLink.click();
	}
	
	public void clickAdmLink()
	{
		admLink.click();
	}
	public void clickSignOut()
	{
		signOutLink.click();
	}

}
