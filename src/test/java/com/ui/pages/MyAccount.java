package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccount extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']");

	public MyAccount(WebDriver driver) {
		super(driver);

	}

	public String getUsername() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
