package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email_1;
	public String email_2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String contactGroup;
	public String addressSecondary;
	public String phoneSecondary;

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address, String homePhone, String mobilePhone,
			String workPhone, String email_1, String email_2, String birthDay, String birthMonth, String birthYear,
			String contactGroup, String addressSecondary, String phoneSecondary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.contactGroup = contactGroup;
		this.addressSecondary = addressSecondary;
		this.phoneSecondary = phoneSecondary;
	}
}