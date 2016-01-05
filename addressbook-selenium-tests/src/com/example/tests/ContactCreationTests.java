package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getNavigationHelper().gotoAddNewContact();

		// contact form data
		ContactData contact = new ContactData();
		contact.firstName = "B New first name";
		contact.lastName = "New last name";
		contact.address = "Any Street name Building 1 app.123\n111023";
		contact.homePhone = "456789";
		contact.mobilePhone = "+123456787654";
		contact.workPhone = "345678(7823)";
		contact.email_1 = "test.mail1@mail.rn";
		contact.email_2 = "test.mail2@mail.rn";
		contact.birthDay = "4";
		contact.birthMonth = "September";
		contact.birthYear = "1956";
		contact.contactGroup = "test-group 1";
		contact.addressSecondary = "secondary address";
		contact.phoneSecondary = "1234567";

		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactForm();
		app.getNavigationHelper().gotoHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save initial contacts list
		List<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getNavigationHelper().gotoAddNewContact();

		// empty contact form data
		ContactData contact = new ContactData();
		contact.lastName = "";
		contact.firstName = "";
		contact.homePhone = "";
		contact.birthDay = "-";
		contact.birthMonth = "-";
		contact.contactGroup = "[none]";

		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactForm();
		app.getNavigationHelper().gotoHomePage();

		// save new contact list
		List<ContactData> newContacts = app.getContactHelper().getContacts();

		// compare states
		initialContacts.add(contact);
		Collections.sort(initialContacts);
		assertEquals(newContacts, initialContacts);
	}
}
