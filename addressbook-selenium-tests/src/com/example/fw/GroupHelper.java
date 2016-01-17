package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupForm();
		returnToGroupsPage();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
    	fillGroupForm(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroup(index);
		submitDeleteGroups();
		returnToGroupsPage();
		return this;
	}
	
	public GroupHelper deleteGroups(List<Integer> indexes) {
		for (int j = indexes.size() - 1; j >= 0; j--) {
			selectGroup(indexes.get(j));
		}
		submitDeleteGroups();
		returnToGroupsPage();
		return this;
	}
	
	// --------------------------------------------------------------------

	public GroupHelper submitGroupForm() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper selectGroup(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper submitDeleteGroups() {
		click(By.name("delete"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroup(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}

	public void removeGroups(List<Integer> indexes, List<GroupData> initialGroups) {
		for (int j = indexes.size() - 1; j >= 0; j--) {
			initialGroups.remove(indexes.get(j).intValue());
		}
	}

}
