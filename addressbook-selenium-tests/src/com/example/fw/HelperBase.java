package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {
	// abstract class can not have instances; it's just for code storage 
	protected ApplicationManager manager;
	protected WebDriver driver;
	
	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      manager.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	    	manager.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = manager.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (manager.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	manager.acceptNextAlert = true;
	    }
	  }

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	protected void select(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
}
