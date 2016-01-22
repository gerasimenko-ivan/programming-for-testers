package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
	
public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContact(ContactData contact) {
		// save initial contacts list
		SortedListOf<ContactData> initialContacts = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(initialContacts.size());

		app.getContactHelper().modifyContact(index, contact);

		// save new contact list
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		ContactData oldContact = initialContacts.get(index);
		initialContacts.remove(index);
		oldContact.update(contact);
		initialContacts.add(oldContact);
		assertEquals(newContacts, initialContacts);
	}
}
