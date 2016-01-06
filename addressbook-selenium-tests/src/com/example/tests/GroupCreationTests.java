package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
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
