package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void removeGroup() {

		Random rnd = new Random();

		for (int i = 0; i < 50; i++) {
			// save initial groups
			List<GroupData> initialGroups = app.getGroupHelper().getGroups();

			// delete one group
			if (initialGroups.size() < 20)
				break;

			int index = rnd.nextInt(initialGroups.size() - 1);

			app.getGroupHelper().deleteGroup(index);
			initialGroups.remove(index);

			// save new groups
			List<GroupData> newGroups = app.getGroupHelper().getGroups();

			// compare states
			Collections.sort(initialGroups);
			assertEquals(newGroups, initialGroups);
		}

	}

	@Test
	public void removeSeveralGroups() {

		Random rnd = new Random();

		// save initial groups
		List<GroupData> initialGroups = app.getGroupHelper().getGroups();

		if (initialGroups.size() > 15) {
			// test several groups deletion at once
			List<Integer> indexes = 
					generateRandomIntegersList(5 + rnd.nextInt(5), initialGroups.size());
			app.getGroupHelper().deleteGroups(indexes);
			app.getGroupHelper().removeGroups(indexes, initialGroups);
		}

		// save new groups
		List<GroupData> newGroups = app.getGroupHelper().getGroups();

		// compare states
		Collections.sort(initialGroups);
		assertEquals(newGroups, initialGroups);

	}

}
