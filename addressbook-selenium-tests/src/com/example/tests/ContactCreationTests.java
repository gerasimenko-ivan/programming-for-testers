package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		// save initial contacts list
		SortedListOf<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contact);

		// save new contact list
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		initialContacts.add(contact);
		assertEquals(newContacts, initialContacts);
	}
}
