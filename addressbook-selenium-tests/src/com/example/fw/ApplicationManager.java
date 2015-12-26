package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {
	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void stop() {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	public void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupForm() {
	    driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	public void gotoGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	public void gotoAddNewContact() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void gotoHomePage() {
		driver.findElement(By.linkText("home")).click();
	}

	public void submitContactForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void fillContactForm(TestBase testBase, ContactData contact) {
		// name
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstName);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.lastName);
	    // address
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.address);
	    // contacts
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.homePhone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mobilePhone);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contact.workPhone);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.email_1);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contact.email_2);
	    // birth date
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthDay);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthMonth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.birthYear);
	    // group
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.contactGroup);
	    // extra address
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.addressSecondary);
	    // extra contact
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contact.phoneSecondary);
	}

	

}
