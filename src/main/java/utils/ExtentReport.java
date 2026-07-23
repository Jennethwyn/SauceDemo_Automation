package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {

	public static ExtentReports extent;

	/**
	 * @author Jenneth
	 * description 
	 * 	Set the browser session name as Automation_Test_Report
	 */

	public static ExtentReports initializeReport() {
		String reportPath = System.getProperty("user.dir")+ "/ExtentReport.html";
		//Create empty HTML file named ExtentReport
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
}
