package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifyContact() {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactEdit(0);
		ContactData contact = new ContactData();
		contact.firstName = "New first name";
		contact.lastName = "New last name";
		contact.email_1 = "new@new.nw";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdate();
		app.getContactHelper().returnToHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		ContactData oldContact = initialContacts.get(0);
		initialContacts.remove(0);
		oldContact.update(contact);
		initialContacts.add(oldContact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
