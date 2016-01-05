package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public int id;
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
				return this.id - contact.id;
			}
			
		}
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_1 == null) ? 0 : email_1.hashCode());
		result = prime * result + ((email_2 == null) ? 0 : email_2.hashCode());
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
		if (email_2 == null) {
			if (other.email_2 != null)
				return false;
		} else if (!email_2.equals(other.email_2))
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
}