package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(initialContacts.size() - 1);

		// actions
		app.getContactHelper().initContactEdit(index);
		contact.contactGroup = null;
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdate();
		app.getContactHelper().returnToHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// move single email_2 to first position
		if (contact.email_1 == "") {
			contact.email_1 = contact.email_2;
			contact.email_2 = "";
		}

		// compare states
		ContactData oldContact = initialContacts.get(index);
		initialContacts.remove(index);
		oldContact.update(contact);
		initialContacts.add(oldContact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
