package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("test-input\\contacts.txt"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testValidContactCreation(ContactData contact) throws Exception {
		// save initial contacts list
		SortedListOf<ContactData> initialContacts = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contact);

		// save new contact list
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContacts();
		
		// compare states
		assertThat(newContacts, equalTo(initialContacts.withAdded(contact)));
	}
}
