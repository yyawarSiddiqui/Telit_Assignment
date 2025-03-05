package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[contains(@class,'lighter') ]");
	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop='name']//a");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getTitle() {

		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public Boolean isSearchTermPresentInProductList(String Keyword) {

		List<String> keywordList = Arrays.asList(Keyword.toLowerCase().split(" "));
		List<String> productnamesList = getAllVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);

		Boolean result = productnamesList.stream()
				.anyMatch(name -> (keywordList.stream().anyMatch(name.toLowerCase()::contains)));
		return result;

	}
	
	public void getProductList() {
		
		getAllElement(ALL_PRODUCT_LIST_NAME);
		
	}
}
