package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().addNewContact();
		fillContactForm(contact, CREATION);
		submitContactForm();
		manager.navigateTo().homePage();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactEdit(index);
		fillContactForm(contact, MODIFICATION);
		submitUpdate();
		returnToHomePage();
		return this;
	}

	public ContactHelper removeContact(int index) {
		initContactEdit(index);
		submitDeleteContact();
		returnToHomePage();
		return this;
	}
	
	// --------------------------------------------------------------------------

	public ContactHelper submitContactForm() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
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
	    // extra address
	    type(By.name("address2"), contact.getAddressSecondary());
	    // extra contact
	    type(By.name("phone2"), contact.getPhoneSecondary());
	    // group
	    if (formType == CREATION){
	    	select(By.name("new_group"), contact.getContactGroup());
	    } else {
	    	/*if (driver.findElements(By.name("new_group")).size() != 0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}*/
	    }
	    
	    return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactEdit(int index) {
		// (index + 2) - numiration from 1 and 1 is for table header
		String locator = "//table[@id='maintable']//tr[" + (index + 2) + "]/td/a/img[@title='Edit']";
		click(By.xpath(locator));
		return this;
	}

	public ContactHelper submitDeleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}

	public ContactHelper submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		
		manager.navigateTo().mainPage();
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
