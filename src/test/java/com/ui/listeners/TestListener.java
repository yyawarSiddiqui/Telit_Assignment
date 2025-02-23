package com.ui.listeners;

import java.io.File;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;// Functionality to create HTML File(Looks, Styling)
	ExtentReports extentReports;// Dump data in HTML file(Heavy lifting)
	ExtentTest extentTest;// To store info abt test

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

	}

	public void onTestFailure(ITestResult result) {

		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testClass = result.getInstance();
		BrowserUtility browserUtility=((TestBase) testClass).getInstance();
		String ScreenShotPath=browserUtility.takesScreenshot(result.getMethod().getMethodName());
		
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(ScreenShotPath);
		
	}

	public void onTestSkipped(ITestResult result) {

		logger.warn(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onStart(ITestContext context) {

		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("Report");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
		ExtentReporterUtility.flushReport();
	}
}
