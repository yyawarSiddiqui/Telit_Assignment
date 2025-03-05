package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class productCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs in to the application and search for product")
	public void setUp() {

		searchResultPage = homePage.goToLoginPage().doLoginWith("bakomam596@skrak.com", "password")
				.searchforProduct(SEARCH_TERM);
	}

	@Test(description = "Verify if the user is able to buy a dress", groups = { "e2e", "sanity" })
	public void CheckoutTest() {

	}

}
