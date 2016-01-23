package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		// save initial contacts list
		SortedListOf<ContactData> initialContacts = app.getContactHelper().getContacts();

		for (int i = 0; i < 25 && initialContacts.size() > 20; i++) {
			initialContacts = app.getContactHelper().getContacts();
			
			Random rnd = new Random();
			int index = rnd.nextInt(initialContacts.size());

			int removedContactId = initialContacts.get(index).getId();
			app.getContactHelper().removeContactById(removedContactId);

			// save new contact list
			SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();

			// compare states
			assertThat(newContacts, equalTo(initialContacts.without(index)));
		}
	}
}
