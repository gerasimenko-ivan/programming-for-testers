package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void removeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    // save initial groups
	    List<GroupData> initialGroups = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(initialGroups.size() - 1);
	    
	    // actions
	    app.getGroupHelper().selectGroup(index);
	    app.getGroupHelper().submitDeleteGroups();
	    app.getGroupHelper().returnToGroupsPage();
	    
	    // save new groups
	    List<GroupData> newGroups = app.getGroupHelper().getGroups();
	    
	    // compare states
	    initialGroups.remove(index);
	    Collections.sort(initialGroups);
	    assertEquals(newGroups, initialGroups);
	}

}
