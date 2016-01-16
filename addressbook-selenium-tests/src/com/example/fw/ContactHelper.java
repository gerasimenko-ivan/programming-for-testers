package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		// name
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		// address
		type(By.name("address"), contact.getAddress());
		// contacts
		type(By.name("home"), contact.getHomePhone());
	    type(By.name("mobile"), contact.getMobilePhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getEmail_1());
	    type(By.name("email2"), contact.getEmail_2());
	    // birth date
		select(By.name("bday"), contact.getBirthDay());
	    select(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    // group
	    select(By.name("new_group"), contact.getContactGroup());
	    // extra address
	    type(By.name("address2"), contact.getAddressSecondary());
	    // extra contact
	    type(By.name("phone2"), contact.getPhoneSecondary());
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
			// prepare data
			String displayEmail = tableRow.findElement(By.xpath("td[4]")).getText();
			
			ContactData contact = new ContactData()
					.withId(Integer.parseInt(tableRow.findElement(By.xpath("td/input")).getAttribute("value")))
					.withLastName(tableRow.findElement(By.xpath("td[2]")).getText())
					.withFirstName(tableRow.findElement(By.xpath("td[3]")).getText())
					.withEmail_1(displayEmail)
					.withHomePhone(tableRow.findElement(By.xpath("td[5]")).getText());
			
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
