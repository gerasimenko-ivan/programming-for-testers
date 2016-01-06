package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(initialContacts.size() - 1);

		// actions
		app.getContactHelper().initContactEdit(index);
		app.getContactHelper().submitDeleteContact();
		app.getContactHelper().returnToHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		initialContacts.remove(index);
		assertEquals(newContacts, initialContacts);
	}
}
