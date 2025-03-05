package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By POSTCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By OTHERINFO_TEXTAREA_LOCATOR = By.id("other");
	private static final By MOBILE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDRESSALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVEADDRESS_TEXTBOX_BUTTON = By.id("submitAddress");
	private static final By ADDRESS_HEADING=By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public String saveAddress(AddressPOJO addressPOJO) {

		enterText(COMPANY_TEXTBOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPOJO.getCity());
		enterText(POSTCODE_TEXTBOX_LOCATOR, addressPOJO.getPostCode());
		enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPOJO.getHomePhone());
		enterText(OTHERINFO_TEXTAREA_LOCATOR, addressPOJO.getOtherInfo());
		enterText(ADDRESSALIAS_TEXTBOX_LOCATOR, addressPOJO.getAddressAlias());
		enterText(MOBILE_TEXTBOX_LOCATOR, addressPOJO.getMobile());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		clickOn(SAVEADDRESS_TEXTBOX_BUTTON);
		return getVisibleText(ADDRESS_HEADING);

	}

}
