package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Intializations
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt()
	{
		return OrgNameEdt;
	}
	
	public WebElement getIndustryDropDown()
	{
		return IndustryDropDown;
	}
	
	//Business Libraries
	/**
	 * This method will create a new org with mandatory fields
	 * @param ORGNAME
	 */
	public void CreateNewOrg(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create a new Org With industry fields and save
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void CreateNewOrg(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		SaveBtn.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
