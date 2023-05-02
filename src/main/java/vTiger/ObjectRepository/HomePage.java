package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration 
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	//Intialization
	public HomePage(WebDriver driver) 
	{
	     PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationsLink()
	{
		return OrganizationsLink;
	}
	
	public WebElement getContactsLink()
	{
		return ContactsLink;
	}
	
	public WebElement getOpportunitiesLink()
	{
		return opportunitiesLink;
	}
	
	public WebElement getAdministratorImg()
	{
		return AdministratorImg;
	}
	
	public WebElement getSignOutLink()
	{
		return AdministratorImg;
	}
	
	//Business Library
	/**
	 * This method will click on organization link
	 */
	public void ClickonOrgLink()
	{
		OrganizationsLink.click();
	}
	
	/**
	 * This method will click on contact link
	 */
	public void ClickOnContactLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will perform Signout operation
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		MouseHoverAction(driver, AdministratorImg);
		SignOutLink.click();
	}
	
}
