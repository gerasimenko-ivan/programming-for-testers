package com.example.tests;

import java.util.ArrayList;
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

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

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
}
