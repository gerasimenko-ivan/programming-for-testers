package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testUntitled() throws Exception {
	openMainPage();
    gotoAddNewContact();
    ContactData contact = new ContactData("Test-First-Name-1", "Test-Last-Name-1", "Any Street name Building 1 app.123\n111023", "456789", "+123456787654", "345678(7823)", "test.mail1@mail.rn", "test.mail2@mail.rn", "4", "September", "1956", "test-group 1", "secondary address", "1234567");
	fillContactForm(contact);
    submitContactForm();
    gotoHomePage();
  }
}
