package com.appdirect.spring.model;

public class CompanyDetails {
	private String country;
	private String name;
	private String phoneNumber;
	private String uuid;
	private String website;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "CompanyDetails [country=" + country + ", name=" + name + ", phoneNumber=" + phoneNumber + ", uuid="
				+ uuid + ", website=" + website + "]";
	}
}
