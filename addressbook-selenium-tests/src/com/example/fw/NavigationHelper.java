package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	public void gotoAddNewContact() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void gotoHomePage() {
		driver.findElement(By.linkText("home")).click();
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

}
