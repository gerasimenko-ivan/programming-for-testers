package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	protected void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupForm() {
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void gotoGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
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

	protected void gotoAddNewContact() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void gotoHomePage() {
		driver.findElement(By.linkText("home")).click();
	}

	protected void submitContactForm() {
		driver.findElement(By.name("submit")).click();
	}

	protected void fillContactForm() {
		driver.findElement(By.name("firstname")).sendKeys("Test-First-Name-1");
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys("Test-Last-Name-1");
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys("Any Street name Building 1 app.123\n111023");
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys("456789");
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys("+123456787654");
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys("345678(7823)");
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("test.mail1@mail.rn");
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys("test.mail2@mail.rn");
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("4");
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("September");
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys("1956");
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("test-group 1");
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys("secondary address");
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys("1234567");
	}

}
