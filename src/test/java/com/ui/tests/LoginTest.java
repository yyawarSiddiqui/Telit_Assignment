package com.ui.tests;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {

	/*
	 * 1. Test Script Small
	 *  2. Cann't have loops Conditional statement try catch in
	 * test scripts
	 *  3. Test Script should follow only Test steps 
	 *  4. Reduce the use of local variables 
	 * 5. Atleast one assertion
	 */

	//@Test(description = "Verify user is able to login with valid Creds", groups = { "e2e",
		//	"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
//	public void loginTest(User user) {
//
//		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
//				.getUsername();
//		assertEquals(userName, "Jatin Sharma");
//	}

	@Test(description = "Verify user is able to login with valid Creds", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVtest(User user) {
		
	
		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUsername();
		assertEquals(userName, "Jatin Sharma");
	}
//
//	@Test(description = "Verify user is able to login with valid Creds", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExceltest(User user) {
//
//		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
//				.getUsername();
//		assertEquals(userName, "Jatin Sharma");
//
//	}
}
