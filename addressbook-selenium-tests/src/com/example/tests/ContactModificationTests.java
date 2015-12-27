package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifyContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(1);
		ContactData contact = new ContactData();
		contact.firstName = "New first name";
		contact.lastName = "New last name";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdate();
		app.getContactHelper().returnToHomePage();
	}
}
