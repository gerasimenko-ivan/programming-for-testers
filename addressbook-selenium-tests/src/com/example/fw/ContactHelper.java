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
		click(By.name("submit"));
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
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

}
