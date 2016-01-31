package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public static int TIMEOUT = 30;
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
		} else {
			throw new Error("Unsupported browser: " + browser);
		}
	    baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	}
	
	public void clearTimeout() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	public void setTimeout() {
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}

	public void stop() {
		driver.quit();
	}
	
	// lazy initialization
	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
}
