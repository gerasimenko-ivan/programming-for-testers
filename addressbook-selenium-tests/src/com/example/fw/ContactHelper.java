package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		// name
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		// address
		type(By.name("address"), contact.address);
		// contacts
		type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email_1);
	    type(By.name("email2"), contact.email_2);
	    // birth date
		select(By.name("bday"), contact.birthDay);
	    select(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    // group
	    select(By.name("new_group"), contact.contactGroup);
	    // extra address
	    type(By.name("address2"), contact.addressSecondary);
	    // extra contact
	    type(By.name("phone2"), contact.phoneSecondary);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactEdit(int index) {
		String locator = "//table[@id='maintable']//tr[" + (index + 1) + "]/td/a/img[@title='Edit']";
		click(By.xpath(locator));
	}

	public void submitDeleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
	}

}
