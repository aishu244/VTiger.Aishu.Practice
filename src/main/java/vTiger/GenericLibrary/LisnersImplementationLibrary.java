package vTiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class will all abstarac method to implement by liseners
 * @author HP
 *
 */
public class LisnersImplementationLibrary implements ITestListener
{
	//ExtentReports report;(we can global it here also and use directly variable like 'report')
	//ExtentTest test;(we can global it here also and use directly variable like 'test')

	public void onTestStart(ITestResult result) {
		String METHODNAME = result.getMethod().getMethodName();
		//System.out.println("test execution started--> "+METHODNAME);
		
		ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest(METHODNAME);
		test.log(Status.INFO,"execution test is started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String METHODNAME = result.getMethod().getMethodName();
		//System.out.println("test is passed --> "+METHODNAME);
		
		ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest(METHODNAME);
		test.log(Status.PASS, "execution is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wlib = new WebDriverLibrary();
		JavaLibrary jlib = new JavaLibrary();
		
		String METHODNAME = result.getMethod().getMethodName()+jlib.getSystemDateInFormat();
		System.out.println("test is failed --> "+METHODNAME);
		ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest(METHODNAME);
		test.log(Status.FAIL, "failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try 
		{
			String path = wlib.takeScreenShot(BaseClass.sdriver, METHODNAME);
			//ExtentReports report1 = new ExtentReports();
		//	ExtentTest test1 = report.createTest(METHODNAME);
			//test.addScreenCaptureFromPath(path);
			test.addScreenCaptureFromPath(path);
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String METHODNAME = result.getMethod().getMethodName();
		//System.out.println("test is skipped --> "+METHODNAME);
		
		ExtentReports report = new ExtentReports();
		ExtentTest test = report.createTest(METHODNAME);
		test.log(Status.SKIP, "execution is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	  
		Reporter.log("Execution of suite started",true);
		// executing suite here hence configuration extent report-19-4-2023-3-25.html
       ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\extentReports\\Report-"+new JavaLibrary().getSystemDateInFormat()+".html");
       htmlReport.config().setDocumentTitle("Execution report for Vtiger");
       htmlReport.config().setReportName("Vtiger Report");
       htmlReport.config().setTheme(Theme.DARK);
       
       //attach the extent Report
       ExtentReports report = new ExtentReports();
       report.attachReporter(htmlReport);
       report.setSystemInfo("Base browser", "chrome");
       report.setSystemInfo("Base invironment","testing");
       report.setSystemInfo("Base URL","http://localhost:8888");
       report.setSystemInfo("Base platform","windows");
       report.setSystemInfo("Report Name", "Aishwarya");
       
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution of suite finished");
		//flush the report. here execution is finished
		ExtentReports report = new ExtentReports();
		report.flush();
		
	}
	

}
