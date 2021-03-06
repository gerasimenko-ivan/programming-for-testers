package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: \"" + file + "\"");
		}
		
		List<ContactData> groups = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(groups, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(groups, file);
		} else {
			System.out.println("Unknown format <" + format + ">");
		}
	}
	
	// ==========================================================================
	// data savers
	// ==========================================================================

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(
					contact.getId() + "," +
					contact.getFirstName() + "," +
					contact.getLastName() + "," +
					contact.getAddress() + "," +
					contact.getHomePhone() + "," +
					contact.getMobilePhone() + "," +
					contact.getWorkPhone() + "," +
					contact.getEmail_1() + "," +
					contact.getEmail_2() + "," +
					contact.getBirthDay() + "," +
					contact.getBirthMonth() + "," +
					contact.getBirthYear() + "," +
					contact.getContactGroup() + "," +
					contact.getAddressSecondary() + "," +
					contact.getPhoneSecondary()  + ",!\n"
					);
		}
		writer.close();
	}
	
	// ==========================================================================
	// data loaders
	// ==========================================================================
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>)xstream.fromXML(file); 
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null && line.length() > 0) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withFirstName(part[1])
					.withLastName(part[2])
					.withAddress(part[3])
					.withHomePhone(part[4])
					.withMobilePhone(part[5])
					.withWorkPhone(part[6])
					.withEmail_1(part[7])
					.withEmail_2(part[8])
					.withBirthDay(part[9])
					.withBirthMonth(part[10])
					.withBirthYear(part[11])
					.withGroup(part[12])
					.withAddressSecondary(part[13])
					.withPhoneSecondary(part[14]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}


	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		Random rnd = new Random();
		for (int i = 0; i < amount; i++) {
			// prepare data
			String from0to31 = Integer.toString(rnd.nextInt(32));
			
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAddress(generateRandomString() + " " + generateRandomString())
					.withHomePhone(generateValidPhoneNumber())
					.withMobilePhone(generateValidPhoneNumber())
					.withWorkPhone(generateValidPhoneNumber())
					.withEmail_1(generateValidEmail(33))
					.withEmail_2(generateValidEmail(66))
					.withBirthDay(from0to31.equals("0") ? "-" : from0to31)
					.withBirthMonth(generateRandomMonth(true, "-"))
					.withBirthYear(Integer.toString(1900 + rnd.nextInt(115)))
					.withGroup("[none]")
					.withAddressSecondary(generateRandomString() + " " + generateRandomString())
					.withPhoneSecondary(generateValidPhoneNumber());
			
			// move single email_2 to first position
			if (contact.getEmail_1() == "") {
				contact
					.withEmail_1(contact.getEmail_2())
					.withEmail_2("");
			}
			
			list.add(contact);
		}
		return list;
	}
	
	public static String generateValidPhoneNumber() {
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
	
	public static String generateValidEmail() {
		Random rnd = new Random();
		String email = "";
		email += rnd.nextInt(Integer.MAX_VALUE);
		email += "@";
		email += rnd.nextInt(Integer.MAX_VALUE);
		email += ".tst";
		return email;
	}
	
	public static String generateValidEmail(int emptyEmailProbability) {
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
	
	public static String generateRandomMonth(boolean withEmptyValue, String emptyValue) {
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

}
