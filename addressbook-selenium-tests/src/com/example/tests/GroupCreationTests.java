package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testValidGroupCreation(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> initialGroups = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// get new state
		SortedListOf<GroupData> newGroups = app.getGroupHelper().getGroups();

		// compare states
		assertThat(newGroups, equalTo(initialGroups.withAdded(group)));
	}
}
