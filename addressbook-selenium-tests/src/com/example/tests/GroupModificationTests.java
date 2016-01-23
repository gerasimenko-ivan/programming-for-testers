package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void renameGroup(GroupData group) {	    
	    // save initial groups
		SortedListOf<GroupData> initialGroups = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(initialGroups.size());
	    
	    // actions
	    app.getGroupHelper().modifyGroup(index, group);
	    
	    // save new groups
	    SortedListOf<GroupData> newGroups = app.getGroupHelper().getGroups();
	    
	    // compare states
	    assertThat(newGroups, equalTo(initialGroups.without(index).withAdded(group)));
	}
}
