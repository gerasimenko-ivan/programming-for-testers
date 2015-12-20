package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testUntitled() throws Exception {
	openMainPage();
    gotoAddNewContact();
    fillContactForm();
    submitContactForm();
    gotoHomePage();
  }
}
