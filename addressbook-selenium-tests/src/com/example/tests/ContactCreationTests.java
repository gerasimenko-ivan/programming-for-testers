package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contact);

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
