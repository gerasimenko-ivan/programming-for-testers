package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNewContact();
    
    // contact form data
    ContactData contact = new ContactData();
    contact.firstName ="Test-First-Name-1";
    contact.lastName = "Test-Last-Name-1";
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
    
	fillContactForm(contact);
    submitContactForm();
    gotoHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNewContact();
    ContactData contact = new ContactData();
    contact.birthDay = "-";
    contact.birthMonth = "-";
    contact.contactGroup = "test-group 1";
	fillContactForm(contact);
    submitContactForm();
    gotoHomePage();
  }
}
