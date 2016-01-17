package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		for (int i = 0; i < 25 && initialContacts.size() > 20; i++) {
			Random rnd = new Random();
			int index = rnd.nextInt(initialContacts.size() - 1);

			app.getContactHelper().removeContact(index);
			initialContacts.remove(index);

			// save new contact list
			List<ContactData> newContacts = app.getContactHelper().getContacts();

			// compare states
			assertEquals(newContacts, initialContacts);
			
			// prepare for next iteration
			initialContacts = app.getContactHelper().getContacts();
		}
	}
}
