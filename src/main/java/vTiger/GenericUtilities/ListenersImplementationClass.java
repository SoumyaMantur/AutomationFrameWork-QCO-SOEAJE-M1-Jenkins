package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListner Interface of TestNG
 * @author Soumya Mantur
 *
 */
public class ListenersImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "-> "+methodName+ "Test Execution is Started <-");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "->" +methodName+ "Test Execution is Passed <-");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.WARNING, "->" +methodName+ " Test Execution is Failed <-");
		test.log(Status.WARNING, result.getThrowable());
		
		
		/*Take Screenshot for the failed test script*/
		
		String screenShotName = methodName+"-"+new JavaUtility().getSystemDateinFormat();
		WebDriverUtility wUtil = new WebDriverUtility();
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path); // Attach Screenshot to the Report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "-> " +methodName+ "Test Execution is Skipped <-" );
		test.log(Status.WARNING, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-> Suite Execution is Started <-");
		
		/*Configured the Extent Report here*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateinFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("QCO-SJEADD-M1-Automation Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		report.setSystemInfo("Base Flatform", "Windows 10");
		report.setSystemInfo("Reporter Name", "Soumya Mantur");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-> Suite Execution is Finished <-");
		
		/*Extent report should get generated*/
		report.flush();
	}
	
}
