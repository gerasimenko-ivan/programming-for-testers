package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(1);
		app.getContactHelper().submitDeleteContact();
		app.getContactHelper().returnToHomePage();
	}
}
