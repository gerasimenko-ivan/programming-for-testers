package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		app.navigateTo()
			.mainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.navigateTo()
			.gotoAddNewContact();
		app.getContactHelper()
			.fillContactForm(contact, CREATION)
			.submitContactForm();
		app.navigateTo()
			.gotoHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
