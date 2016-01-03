package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void removeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    // save initial groups
	    List<GroupData> initialGroups = app.getGroupHelper().getGroups();
	    
	    // actions
	    app.getGroupHelper().selectGroup(0);
	    app.getGroupHelper().submitDeleteGroups();
	    app.getGroupHelper().returnToGroupsPage();
	    
	    // save new groups
	    List<GroupData> newGroups = app.getGroupHelper().getGroups();
	    
	    // compare states
	    initialGroups.remove(0);
	    Collections.sort(initialGroups);
	    assertEquals(newGroups, initialGroups);
	}

}
