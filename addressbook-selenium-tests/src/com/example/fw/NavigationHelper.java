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
		return driver.getCurrentUrl().contains("/group.php") 
				&& hasElementsNoWait(By.name("new_group")); 
	}

	public NavigationHelper addNewContact() {
		if (! isOnNewContactPage()) {
			click(By.linkText("add new"));
		}
		return this;
	}

	private boolean isOnNewContactPage() {
		return hasElementsNoWait(By.xpath("//*[@id='content']/form/input[@value='Enter']"));
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
		return hasElementsNoWait(By.id("maintable"));
	}
	
	private boolean hasElementsNoWait(By locator) {
		manager.clearTimeout();
		boolean isOnPage = driver.findElements(locator).size() != 0;
		manager.setTimeout();
		return isOnPage;
	}

}
