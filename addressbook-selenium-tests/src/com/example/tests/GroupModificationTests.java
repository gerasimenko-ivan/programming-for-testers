package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void renameGroup(GroupData group) {
		app.getNavigationHelper()
			.openMainPage()
			.gotoGroupsPage();
	    
	    // save initial groups
	    List<GroupData> initialGroups = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(initialGroups.size() - 1);
	    
	    // actions
	    app.getGroupHelper()
	    	.initGroupModification(index)
	    	.fillGroupForm(group)
	    	.submitGroupModification()
	    	.returnToGroupsPage();
	    
	    // save new groups
	    List<GroupData> newGroups = app.getGroupHelper().getGroups();
	    
	    // compare states
	    initialGroups.remove(index);
	    initialGroups.add(group);
	    Collections.sort(initialGroups);
	    assertEquals(newGroups, initialGroups);
	}
}
