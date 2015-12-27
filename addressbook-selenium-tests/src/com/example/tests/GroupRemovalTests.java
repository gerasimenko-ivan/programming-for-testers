package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void removeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    app.getGroupHelper().selectGroup(1);
	    app.getGroupHelper().submitDeleteGroups();
	    app.getGroupHelper().returnToGroupsPage();
	}

}
