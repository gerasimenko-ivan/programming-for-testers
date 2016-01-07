package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

import static org.testng.Assert.assertEquals;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		// name
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		// address
		type(By.name("address"), contact.address);
		// contacts
		type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email_1);
	    type(By.name("email2"), contact.email_2);
	    // birth date
		select(By.name("bday"), contact.birthDay);
	    select(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    // group
	    select(By.name("new_group"), contact.contactGroup);
	    // extra address
	    type(By.name("address2"), contact.addressSecondary);
	    // extra contact
	    type(By.name("phone2"), contact.phoneSecondary);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactEdit(int index) {
		// (index + 2) - numiration from 1 and 1 is for table header
		String locator = "//table[@id='maintable']//tr[" + (index + 2) + "]/td/a/img[@title='Edit']";
		click(By.xpath(locator));
	}

	public void submitDeleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
		for (WebElement tableRow : tableRows) {
			ContactData contact = new ContactData();
			contact.id = Integer.parseInt(tableRow.findElement(By.xpath("td/input")).getAttribute("value"));
			contact.lastName = tableRow.findElement(By.xpath("td[2]")).getText();
			contact.firstName = tableRow.findElement(By.xpath("td[3]")).getText();
			// emails from attribute
			String[] emails = tableRow.findElement(By.xpath("td/input")).getAttribute("accept").split(";");
			contact.email_1 = (emails.length > 0 && emails[0].length() > 0) ? emails[0] : "";
			contact.email_2 = emails.length > 1 ? emails[1] : "";
			// display email
			String displayEmail = tableRow.findElement(By.xpath("td[4]")).getText();
			// check displayEmail is the same with email_1
			assertEquals(displayEmail, contact.email_1);
			contact.homePhone = tableRow.findElement(By.xpath("td[5]")).getText();
			contacts.add(contact);
		}
		return contacts;
	}

	public ArrayList<String> getGroupSelectOptions() {
		ArrayList<String> optionsList = new ArrayList<String>();
		List<WebElement> optionsWebElements = driver.findElements(By.xpath("//select[@name='new_group']/option"));
		for (WebElement option : optionsWebElements) {
			optionsList.add(option.getText());
		}
		return optionsList;
	}

}
