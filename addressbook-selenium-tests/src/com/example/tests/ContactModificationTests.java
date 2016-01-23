package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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

		int modifiedContactId = initialContacts.get(index).getId();
		app.getContactHelper().modifyContactById(modifiedContactId, contact);

		// save new contact list
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		ContactData oldContact = initialContacts.get(index);
		oldContact.update(contact);
		assertThat(newContacts, equalTo(initialContacts.without(index).withAdded(oldContact)));
	}
}
