package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;

import com.utility.*;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest = true;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod
	public void setup(@Optional("CHROME") String browser, 
			ITestResult result, 
			@Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless) {
		
		WebDriver remoteLambdadriver;

		this.isLambdaTest = isLambdaTest;
		if (isLambdaTest) {
			
			
			remoteLambdadriver = LambdaTestUtility.initializeLambdaTestSession(browser,
					result.getMethod().getMethodName());
			homePage = new HomePage(remoteLambdadriver);
		}

		else {

			// Running locally
			logger.info("Load the homepage");
			
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
			
		}

	}

	public BrowserUtility getInstance() { // BrowserUtility refrence can be use as return type homepage parent class is
											// BrowserUtility

		return homePage;
	}

	@AfterMethod
	public void tearDown() {

		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {

			homePage.quit();
		}
	}
}
