package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import selenium.com.saucedemo.DriverFactory;
import utils.ExtentReport;
import utils.ScreenShot;


public class TestListner implements ITestListener {

	private static ExtentReports extent = ExtentReport.initializeReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest ExtentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(ExtentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.get().pass("Test Passed");
		String Path = ScreenShot.takeScreenShot(DriverFactory.getDriver(), 
				result.getMethod().getMethodName(),
				"Pass");
		test.get().addScreenCaptureFromPath(Path);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.get().fail("Test Failed");
		test.get().fail(result.getThrowable());
		String Path = ScreenShot.takeScreenShot(DriverFactory.getDriver(), 
				result.getMethod().getMethodName(),
				"Fail");
		test.get().addScreenCaptureFromPath(Path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.get().skip("Test Skipped");
		test.get().skip(result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
