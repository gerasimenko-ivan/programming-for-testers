package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testValidGroupCreation(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();

		// save old state
		List<GroupData> initialGroups = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupForm();
		app.getGroupHelper().returnToGroupsPage();

		// get new state
		List<GroupData> newGroups = app.getGroupHelper().getGroups();

		// compare states
		initialGroups.add(group);
		Collections.sort(initialGroups);
		assertEquals(newGroups, initialGroups);
	}
}
