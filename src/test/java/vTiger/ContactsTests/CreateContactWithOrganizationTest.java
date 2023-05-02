package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test
    public void CreateContactWithOrgTest() throws IOException {
		
		String LASTNAME = eUtil.readDatafromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDatafromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		//Step 3: Navigate to organization Link
		HomePage hp = new HomePage(driver);
		hp.ClickonOrgLink();
		
		//Step 4: Click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();
		
		//Step 5: Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrg(ORGNAME);
		
		//Step 7: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		//Step 9: Navigate to Create Contact Look up Image
		hp.ClickOnContactLink();
		
		//Step 10: Create Contact 
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnCreateContactLookUpImg();
		
		//Step 11: Click On Organization Look up image
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
		//wUtil.takeScreenShot(driver, "Contact");
		
		//Step 17: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		
	}

}
