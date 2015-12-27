package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitGroupForm() {
		click(By.name("submit"));
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.name);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public void selectGroup(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void pressDeleteGroups() {
		click(By.name("delete"));
	}
}
