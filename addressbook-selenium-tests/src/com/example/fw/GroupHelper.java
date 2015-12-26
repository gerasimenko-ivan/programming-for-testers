package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitGroupForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	public void fillGroupForm(ApplicationManager applicationManager, TestBase testBase, GroupData group) {
	    type(By.name("group_name"), group.name);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);
	}

	public void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}
}
