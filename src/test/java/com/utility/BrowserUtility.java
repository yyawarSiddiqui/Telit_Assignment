package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);

	}

	public BrowserUtility(Browser BrowserName, boolean iSHeadless) {

		if (BrowserName == Browser.CHROME) {

			if (iSHeadless) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("disable-gpu");

				driver.set(new ChromeDriver(chromeOptions));
			} else {

				driver.set(new ChromeDriver());
			}

		} else if (BrowserName == Browser.EDGE) {

			if (iSHeadless) {
				EdgeOptions EdgeOptions = new EdgeOptions();
				EdgeOptions.addArguments("--headless=new");
				EdgeOptions.addArguments("--window-size=1920,1080");
				EdgeOptions.addArguments("disable-gpu");

				driver.set(new EdgeDriver(EdgeOptions));
			} else {

				driver.set(new EdgeDriver());
			}
		}

		else if (BrowserName == Browser.FIREFOX) {

			if (iSHeadless) {
				FirefoxOptions FireOptions = new FirefoxOptions();
				FireOptions.addArguments("--headless=new");
				FireOptions.addArguments("--window-size=1920,1080");
				FireOptions.addArguments("disable-gpu");

				driver.set(new FirefoxDriver(FireOptions));
			} else {

				driver.set(new FirefoxDriver());
			}

		} else {
			System.err.println("Wrong browser");
		}
	}

	public void goToWebsite(String url) {

		driver.get().get(url);

	}

	public void maximizeWindow() {

		driver.get().manage().window().maximize();

	}

	public void quit() {

		driver.get().quit();
	}

	public void clickOn(By Locator) {

		WebElement Elem = driver.get().findElement(Locator);
		Elem.click();
	}

	public void enterText(By Locator, String Text) {

		driver.get().findElement(Locator).sendKeys(Text);
	}

	public void enterTextbySpecialKey(By Locator, Keys keyToEnter) {

		driver.get().findElement(Locator).sendKeys(keyToEnter);
	}

	public String getVisibleText(By Locator) {

		return driver.get().findElement(Locator).getText();
	}
	
	public String getAllVisibleText(By Locator) {

		List<WebElement> elements =driver.get().findElements(Locator);
		
		for(WebElement elem:elements) {
			
		return getVisibleText(elem);
			
		}
		return "";
	}
	
	
	public String getVisibleText(WebElement element) {

		return element.getText();
	}

	public String takesScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File ScreenShot = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-SS");
		String Timestamp = dateFormat.format(date);

		String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + name + "-"
				+ Timestamp + ".png";

		File screenShotFile = new File(path);

		try {
			FileUtils.copyFile(ScreenShot, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
