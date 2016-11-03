package com.appdirect.spring.model;

public class Creator {
	private CreatorAddress address;
	private String email;
	private String firstName;
	private String language;
	private String lastName;
	private String locale;
	private String openId;
	private String uuid;
	public CreatorAddress getAddress() {
		return address;
	}
	public void setAddress(CreatorAddress address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "Creator [address=" + address + ", email=" + email + ", firstName=" + firstName + ", language="
				+ language + ", lastName=" + lastName + ", locale=" + locale + ", openId=" + openId + ", uuid=" + uuid
				+ "]";
	}
	
}
