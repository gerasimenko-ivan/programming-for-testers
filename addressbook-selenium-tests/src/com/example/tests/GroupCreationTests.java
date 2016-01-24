package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("test-input\\groups.txt"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
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
