package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This Class Consists of all Basic Configuration Annotation
 * @author Soumya Mantur
 *
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println(" --- Database Connection Successful --- ");
	}
	
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuit","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launch successful --- ");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launch successful --- ");
		}
		else
		{
			System.out.println("Invalid Browser name in Property File");
		}
		
		sDriver=driver;
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"SmokeSuit","RegressionSuite"})
	public void bmConfif() throws IOException
	{
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println(" --- Login is Successful --- ");
		
	}
	
	@AfterMethod(groups = {"SmokeSuit","RegressionSuite"})
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.logOutOfApp(driver);
		System.out.println(" --- Logout is Successful --- ");
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuit","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println(" --- Browser Closed Successfully --- ");
	}
	
	@AfterSuite(groups = {"SmokeSuit","RegressionSuite"})
	public void asConfig()
	{
		System.out.println(" --- Database Connection Successful --- ");
	}

}
