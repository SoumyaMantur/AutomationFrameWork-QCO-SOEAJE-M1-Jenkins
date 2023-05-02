package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement CreateContcactLookUpImg;

		//Intialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		

		//Utilization
		public WebElement getCreateContactLookUpImg()
		{
			return CreateContcactLookUpImg;	
		}
		
		//Business Library
		/**
		 * This method will click on the look up image
		 */
		public void ClickOnCreateContactLookUpImg()
		{
	        CreateContcactLookUpImg.click();
		}

}
