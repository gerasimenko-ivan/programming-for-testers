package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getNavigationHelper().gotoAddNewContact();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactForm();
		app.getNavigationHelper().gotoHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
