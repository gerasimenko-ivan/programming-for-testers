package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
		assertThat(newContacts, equalTo(initialContacts.withAdded(contact)));
	}
}
