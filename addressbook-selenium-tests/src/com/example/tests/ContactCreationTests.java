package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper()
			.openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getNavigationHelper()
			.gotoAddNewContact();
		app.getContactHelper()
			.fillContactForm(contact, ContactHelper.CREATION)
			.submitContactForm();
		app.getNavigationHelper()
			.gotoHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
