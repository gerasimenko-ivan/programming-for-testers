package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
	
public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContact(ContactData contact) {
		app.navigateTo().mainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(initialContacts.size() - 1);

		// actions
		//contact.withGroup(null);
		app.getContactHelper()
			.initContactEdit(index)
			.fillContactForm(contact, MODIFICATION)
			.submitUpdate()
			.returnToHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		ContactData oldContact = initialContacts.get(index);
		initialContacts.remove(index);
		oldContact.update(contact);
		initialContacts.add(oldContact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
