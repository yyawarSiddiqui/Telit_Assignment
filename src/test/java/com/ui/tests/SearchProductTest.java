package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccount;

@Listeners({ com.ui.listeners.TestListener.class })
public class SearchProductTest extends TestBase {

	private MyAccount myAccount;

	@BeforeMethod
	public void setup() {

		myAccount = homePage.goToLoginPage().doLoginWith("bakomam596@skrak.com", "password");
	}

	@Test(description = "Searching the Product page with Valid Credentials and Correct Products", groups = { "e2e",
			"sanity" })
	public void verifyProductSearch() {

		String data = myAccount.searchforProduct("Printed Summer Dress").getTitle();
		System.out.println(data);
	}

}
