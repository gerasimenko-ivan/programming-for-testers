package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
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
