package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {

	public static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> DesiredCapabilitieslocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initializeLambdaTestSession(String Browser, String testname) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", Browser);
		capabilities.setCapability("browserVersion", "127");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "yawarsdq");
		ltOptions.put("accessKey", "Txw4qQMJnxmloLGLCbz1c51znUdrs2S0tHhcYF8kMFov0GPjTV");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testname);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "4.23.0");
		capabilities.setCapability("LT:Options", ltOptions);
		DesiredCapabilitieslocal.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUBURL), DesiredCapabilitieslocal.get());

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		driverlocal.set(driver);
		return driverlocal.get();
	}

	public static void quitSession() {

		if (driverlocal.get() != null) {

			driverlocal.get().quit();
		}
	}

}
