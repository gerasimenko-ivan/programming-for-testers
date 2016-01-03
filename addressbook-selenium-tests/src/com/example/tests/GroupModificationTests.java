package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void renameGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    // save initial groups
	    List<GroupData> initialGroups = app.getGroupHelper().getGroups();
	    
	    // actions
	    GroupData group = new GroupData();
	    group.name = "new name";
	    app.getGroupHelper().initGroupModification(0);
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();
	    
	    // save new groups
	    List<GroupData> newGroups = app.getGroupHelper().getGroups();
	    
	    // compare states
	    initialGroups.remove(0);
	    initialGroups.add(group);
	    Collections.sort(initialGroups);
	    assertEquals(newGroups, initialGroups);
	}
}
