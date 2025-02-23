package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(Browser BrowserName, boolean isHeadless) {
		super(BrowserName, isHeadless);// To call the Parent class Constructor from the Child Class Constructor with
		// help of this
		maximizeWindow();
		// goToWebsite(ReadProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);// To call the Parent class Constructor from the Child Class Constructor with
						// help of this
		maximizeWindow();
		
		// goToWebsite(ReadProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public LoginPage goToLoginPage() {

		logger.info("Logging to page");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public void quit() {
	
		
	}

}
