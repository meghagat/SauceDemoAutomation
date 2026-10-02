package tests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReporterNG;

public class Listeners implements ITestListener {

	    ExtentReports extent =
	            ExtentReporterNG.getReportObject();

	    ExtentTest test;


	    @Override
	    public void onTestStart(ITestResult result) {

	        test = extent.createTest(
	                result.getMethod().getMethodName()
	        );
	    }


	    @Override
	    public void onTestSuccess(ITestResult result) {

	        test.pass("Test Passed");
	    }


	    @Override
	    public void onTestFailure(ITestResult result) {

	        test.fail(result.getThrowable());

	        BaseTest baseTest =
	                (BaseTest) result.getInstance();

	        try {

	            String screenshotPath =
	                    baseTest.getScreenShot(
	                            result.getMethod().getMethodName()
	                    );

	            test.addScreenCaptureFromPath(screenshotPath);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
	    @Override
	    public void onFinish(ITestContext context) {

	        extent.flush();
	    }


}
