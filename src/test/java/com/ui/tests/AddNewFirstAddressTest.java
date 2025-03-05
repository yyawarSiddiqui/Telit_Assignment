package com.ui.tests;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccount;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccount myAccount;
	private AddressPage addressPage;
	private AddressPOJO addressPOJO;

	@BeforeMethod
	public void setup() {

		myAccount = homePage.goToLoginPage().doLoginWith("bakomam596@skrak.com", "password");
		addressPOJO = FakeAddressUtility.getFakeAddress();
	}

	@Test(description = "Test adding new Address", groups = { "e2e", "sanity" })
	public void addNewAddress() {

		String newAddress = myAccount.gotoAddressPage().saveAddress(addressPOJO);
		assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
	}
}
