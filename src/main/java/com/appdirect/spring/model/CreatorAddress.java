package com.appdirect.spring.model;

public class CreatorAddress {
	private String firstName;
	private String fullName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "CreatorAddress [firstName=" + firstName + ", fullName=" + fullName + ", lastName=" + lastName + "]";
	}
}
