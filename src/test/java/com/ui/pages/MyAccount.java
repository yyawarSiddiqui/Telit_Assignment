package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccount extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']");
	private static final By SEARCH_NAME_LOCATOR = By.id("search_query_top");



	public MyAccount(WebDriver driver) {
		super(driver);

	}

	public String getUsername() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage searchforProduct(String ItemName) {

		enterText(SEARCH_NAME_LOCATOR, ItemName);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		enterTextbySpecialKey(SEARCH_NAME_LOCATOR, Keys.ENTER);
		return searchResultPage;

	}

}
