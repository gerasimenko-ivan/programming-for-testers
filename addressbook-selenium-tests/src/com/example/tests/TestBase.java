package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	// ==========================================================================
	// Data Providers
	// ==========================================================================

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(15)).iterator();
	}
	
	protected static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[] { group });
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
	}
	
	protected static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[] { contact });
		}
		return list;
	}
	
	// ==========================================================================
	// test data generators
	// ==========================================================================

	protected List<Integer> generateRandomIntegersList(int numberOfElements, int boundaryValue) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listAll = new ArrayList<Integer>();
		Random rnd = new Random();
		
		for (int i = 0; i < boundaryValue; i++) {
			listAll.add(i);
		}
		for (int i = 0; i < numberOfElements; i++) {
			int index = rnd.nextInt(listAll.size());
			list.add(listAll.get(index));
			listAll.remove(index);
		}
		Collections.sort(list);
		
		return list;
	}
}
