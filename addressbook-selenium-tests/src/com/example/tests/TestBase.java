package com.example.tests;

import java.time.Month;
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
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 15; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(new Object[] { group });
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoAddNewContact();
		
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			// prepare data
			String from0to31 = Integer.toString(rnd.nextInt(32));
			// group selection
			ArrayList<String> groupSelectOptions = app.getContactHelper().getGroupSelectOptions();
			int groupIndex = rnd.nextInt(groupSelectOptions.size() - 1);
			
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAddress(generateRandomString() + "\n" + generateRandomString())
					.withHomePhone(generateValidPhoneNumber())
					.withMobilePhone(generateValidPhoneNumber())
					.withWorkPhone(generateValidPhoneNumber())
					.withEmail_1(generateValidEmail(33))
					.withEmail_2(generateValidEmail(66))
					.withBirthDay(from0to31.equals("0") ? "-" : from0to31)
					.withBirthMonth(generateRandomMonth(true, "-"))
					.withBirthYear(Integer.toString(1900 + rnd.nextInt(115)))
					.withGroup(groupSelectOptions.get(groupIndex))
					.withAddressSecondary(generateRandomString() + "\n" + generateRandomString())
					.withPhoneSecondary(generateValidPhoneNumber());
			
			// move single email_2 to first position
			if (contact.getEmail_1() == "") {
				contact
					.withEmail_1(contact.getEmail_2())
					.withEmail_2("");
			}
			
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	// ==========================================================================
	// test data generators
	// ==========================================================================

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test " + rnd.nextInt();
		}
	}

	public String generateValidPhoneNumber() {
		Random rnd = new Random();
		String phone = "";
		if (rnd.nextBoolean() == true)
			phone += "+";
		phone += rnd.nextInt(10);
		if (rnd.nextInt(5) == 0) {
			phone += rnd.nextInt(Integer.MAX_VALUE);
		} else {
			if (rnd.nextBoolean() == true) {
				phone += "(";
				phone += (100 + rnd.nextInt(900)); 
				phone += ")";
			} else {
				phone += (100 + rnd.nextInt(900));
				phone += "-";
			}
			phone += (100 + rnd.nextInt(900));
			phone += "-";
			phone += (10 + rnd.nextInt(90));
			phone += "-";
			phone += (10 + rnd.nextInt(90));
		}

		return phone;
	}
	
	public String generateValidEmail() {
		Random rnd = new Random();
		String email = "";
		email += rnd.nextInt(Integer.MAX_VALUE);
		email += "@";
		email += rnd.nextInt(Integer.MAX_VALUE);
		email += ".tst";
		return email;
	}
	
	public String generateValidEmail(int emptyEmailProbability) {
		Random rnd = new Random();
		
		// normalize input data
		if (emptyEmailProbability >= 100)
			emptyEmailProbability = 99;
		if (emptyEmailProbability < 1)
			emptyEmailProbability = 1;
		
		if (emptyEmailProbability - 1 > rnd.nextInt(100))
			return "";
		else
			return generateValidEmail();
	}
	
	public String generateRandomMonth(boolean withEmptyValue, String emptyValue) {
		Random rnd = new Random();
		String month = Month.of(1 + rnd.nextInt(12)).toString().toLowerCase();
		month = month.substring(0, 1).toUpperCase() + month.substring(1);
		if (withEmptyValue == true) {
			if (rnd.nextInt(13) == 0) {
				return emptyValue;
			} else {
				return month;
			}
		} else {
			return month; 
		}
	}

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
