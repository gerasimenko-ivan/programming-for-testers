package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactEdit(0);
		app.getContactHelper().submitDeleteContact();
		app.getContactHelper().returnToHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		initialContacts.remove(0);
		assertEquals(newContacts, initialContacts);
	}
}
