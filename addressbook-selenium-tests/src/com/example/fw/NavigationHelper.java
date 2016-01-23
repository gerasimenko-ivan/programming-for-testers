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
		manager.clearTimeout();
		boolean isOnGroupsPage = driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new_group")).size() > 0;
		manager.setTimeout();
		return isOnGroupsPage;
	}

	public NavigationHelper addNewContact() {
		if (! isOnNewContactPage()) {
			click(By.linkText("add new"));
		}
		return this;
	}

	private boolean isOnNewContactPage() {
		manager.clearTimeout();
		boolean isOnNewContactPage = 
				driver.findElements(By.xpath("//*[@id='content']/form/input[@value='Enter']")).size() != 0;
		manager.setTimeout();
		return isOnNewContactPage;
	}

	public NavigationHelper homePage() {
		if (! isOnMainPage()) {
			click(By.linkText("home"));
		}
		return this;
	}

	public NavigationHelper mainPage() {
		if (! isOnMainPage())
			click(By.linkText("home"));
		return this;
	}

	private boolean isOnMainPage() {
		manager.clearTimeout();
		boolean isOnMainPage = driver.findElements(By.id("maintable")).size() != 0;
		manager.setTimeout();
		return isOnMainPage;
	}

}
