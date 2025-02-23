package com.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setupSparkReporter(String reportname) {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "" + reportname + ".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

	}

	public static void createExtentTest(String testName) {

		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {

		return extentTest.get();
	}

	public static void flushReport() {

		extentReports.flush();
	}
}
