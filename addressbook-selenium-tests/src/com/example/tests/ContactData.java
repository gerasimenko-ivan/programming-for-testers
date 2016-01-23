package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email_1;
	private String email_2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String contactGroup;
	private String addressSecondary;
	private String phoneSecondary;

	public ContactData() {
		this.id = Integer.MAX_VALUE;
	}
	
	public ContactData(int id, String firstName, String lastName, String address, String homePhone, String mobilePhone,
			String workPhone, String email_1, String email_2, String birthDay, String birthMonth, String birthYear,
			String contactGroup, String addressSecondary, String phoneSecondary) {
		this.id = id;
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

	@Override
	public int compareTo(ContactData contact) {
		String thisLastName = this.lastName == null ? "" : this.lastName;
		String thatLastName = contact.lastName == null ? "" : contact.lastName;
		int comparedLastName = thisLastName.toLowerCase().compareTo(thatLastName.toLowerCase());
		
		if (comparedLastName != 0) {
			return comparedLastName;
		} else {
			String thisFirstName = this.firstName == null ? "" : this.firstName;
			String thatFirstName = contact.firstName == null ? "" : contact.firstName;
			int comparedFirstName = thisFirstName.toLowerCase().compareTo(thatFirstName.toLowerCase());
			
			if (comparedFirstName != 0) {
				return comparedFirstName;
			} else {
				String thisEmail_1 = this.email_1 == null ? "" : this.email_1;
				String thatEmail_1 = contact.email_1 == null ? "" : contact.email_1;
				int comparedEmail_1 = thisEmail_1.toLowerCase().compareTo(thatEmail_1.toLowerCase());
				if (comparedEmail_1 != 0) {
					return comparedEmail_1;
				} else {
					String thisHomePhone = this.homePhone == null ? "" : this.homePhone;
					String thatHomePhone = contact.homePhone == null ? "" : contact.homePhone;
					return thisHomePhone.toLowerCase().compareTo(thatHomePhone.toLowerCase());
				}
			}
			
		}
	}

	

	@Override
	public String toString() {
		return "ContactData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", homePhone="
				+ homePhone + ", email_1=" + email_1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_1 == null) ? 0 : email_1.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email_1 == null) {
			if (other.email_1 != null)
				return false;
		} else if (!email_1.equals(other.email_1))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public void update(ContactData contact) {
		if (contact.firstName != null) {
			this.firstName = contact.firstName;			
		}
		if (contact.lastName != null) {
			this.lastName = contact.lastName;
		}
		if (contact.address != null) {
			this.address = contact.address;
		}
		if (contact.homePhone != null) {
			this.homePhone = contact.homePhone;
		}
		if (contact.mobilePhone != null) {
			this.mobilePhone = contact.mobilePhone;
		}
		if (contact.workPhone != null) {
			this.workPhone = contact.workPhone;
		}
		if (contact.email_1 != null) {
			this.email_1 = contact.email_1;
		}
		if (contact.email_2 != null) {
			this.email_2 = contact.email_2;
		}
		if (contact.birthDay != null) {
			this.birthDay = contact.birthDay;
		}
		if (contact.birthMonth != null) {
			this.birthMonth = contact.birthMonth;
		}
		if (contact.birthYear != null) {
			this.birthYear = contact.birthYear;
		}
		if (contact.contactGroup != null) {
			this.contactGroup = contact.contactGroup;
		}
		if (contact.addressSecondary != null) {
			this.addressSecondary = contact.addressSecondary;
		}
		if (contact.phoneSecondary != null) {
			this.phoneSecondary = contact.phoneSecondary;
		}
	}

	public ContactData withId(int id) {
		this.id = id;
		return this;
	}	
	
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName; 
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withEmail_1(String email) {
		this.email_1 = email;
		return this;
	}

	public ContactData withEmail_2(String email) {
		this.email_2 = email;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}

	public ContactData withGroup(String contactGroup) {
		this.contactGroup = contactGroup; 
		return this;
	}

	public ContactData withAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary; 
		return this;
	}

	public ContactData withPhoneSecondary(String phoneSecondary) {
		this.phoneSecondary = phoneSecondary; 
		return this;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail_1() {
		return email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getContactGroup() {
		return contactGroup;
	}

	public String getAddressSecondary() {
		return addressSecondary;
	}

	public String getPhoneSecondary() {
		return phoneSecondary;
	}

}