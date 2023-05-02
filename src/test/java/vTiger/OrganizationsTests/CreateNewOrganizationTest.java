package vTiger.OrganizationsTests;

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
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateNewOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeSuit")
	public void CreateNewOrgTest() throws IOException {
		
		String ORGNAME = eUtil.readDatafromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		//Step 3: Navigate to organization Link
		HomePage hp = new HomePage(driver);
		hp.ClickonOrgLink();
		
		//Step 4: Click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();
		
		//Step 5: Create Organization with Mandatory fields
	    CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	    cnop.CreateNewOrg(ORGNAME);
		
		//Step 6: Save
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
	    }
	
	
	    @Test(groups = "RegressionSuite")
	    public void demoOrg()
	    {
	    	System.out.println("This is Demo");
	    }


	}
	

