package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public NavigationHelper groupsPage() {
		if (! isOnGroupsPage()) {
			click(By.linkText("groups"));
		}
		return this;
	}

	private boolean isOnGroupsPage() {
		/*return (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new_group")).size() > 0);*/
		return false;
	}

	public NavigationHelper addNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public NavigationHelper homePage() {
		click(By.linkText("home"));
		return this;
	}

	public NavigationHelper mainPage() {
		if (! isOnMainPage())
			click(By.linkText("home"));
		return this;
	}

	private boolean isOnMainPage() {
		/*return driver.findElements(By.id("maintable")).size() > 0;*/
		return false;
	}

}
