package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    
	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir")+"//reports//index.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config()
                .setReportName("SauceDemo Automation Report");

        reporter.config()
                .setDocumentTitle("Test Results");

        ExtentReports extent =
                new ExtentReports();

        extent.attachReporter(reporter);

        return extent;
    }

	
	

}
