package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[contains(@class,'lighter') ]");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getTitle() {

		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
}
