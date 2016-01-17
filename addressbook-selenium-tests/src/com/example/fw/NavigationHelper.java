package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public NavigationHelper gotoGroupsPage() {
		click(By.linkText("groups"));
		return this;
	}

	public NavigationHelper gotoAddNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public NavigationHelper gotoHomePage() {
		click(By.linkText("home"));
		return this;
	}

	public NavigationHelper openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		return this;
	}

}
