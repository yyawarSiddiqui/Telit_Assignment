package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EmailTextBoxLocator = By.id("email");
	private static final By PasswordTextBoxLocator = By.id("passwd");
	private static final By Submit = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyAccount doLoginWith(String emailAddress, String Password) {
		enterText(EmailTextBoxLocator, emailAddress);
		enterText(PasswordTextBoxLocator, Password);
		clickOn(Submit);
		MyAccount myAccount=new MyAccount(getDriver());
		return myAccount;
	}

}
