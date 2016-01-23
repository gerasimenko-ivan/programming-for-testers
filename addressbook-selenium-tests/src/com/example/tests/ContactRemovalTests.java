package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		// save initial contacts list
		SortedListOf<ContactData> initialContacts = app.getContactHelper().getContacts();

		for (int i = 0; i < 25 && initialContacts.size() > 20; i++) {
			Random rnd = new Random();
			int index = rnd.nextInt(initialContacts.size());

			int removedContactId = initialContacts.get(index).getId();
			app.getContactHelper().removeContactById(removedContactId);
			initialContacts.remove(index);

			// save new contact list
			SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();

			// compare states
			assertEquals(newContacts, initialContacts);
		}
	}
}
