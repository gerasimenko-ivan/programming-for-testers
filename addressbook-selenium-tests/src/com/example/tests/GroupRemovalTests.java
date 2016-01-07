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
		
		Random rnd = new Random();
		
		for (int i = 0; i < 50; i++) {
			// save initial groups
			List<GroupData> initialGroups = app.getGroupHelper().getGroups();

			if (i == 0 && initialGroups.size() > 15) {
				// test several groups deletion at once
				List<Integer> indexes = generateRandomIntegersList(5 + rnd.nextInt(5), initialGroups.size());
				for (int j = indexes.size() - 1; j >= 0; j--) {
					app.getGroupHelper().selectGroup(indexes.get(j));
					initialGroups.remove(indexes.get(j).intValue());
				}
				app.getGroupHelper().submitDeleteGroups();
				app.getGroupHelper().returnToGroupsPage();
			} else {
				// delete one group
				if (initialGroups.size() < 20) break;
				
				int index = rnd.nextInt(initialGroups.size() - 1);

				// actions
				app.getGroupHelper().selectGroup(index);
				app.getGroupHelper().submitDeleteGroups();
				app.getGroupHelper().returnToGroupsPage();
				initialGroups.remove(index);
			}
						
			// save new groups
			List<GroupData> newGroups = app.getGroupHelper().getGroups();

			// compare states
			Collections.sort(initialGroups);
			assertEquals(newGroups, initialGroups);
		}
		
	}

}
