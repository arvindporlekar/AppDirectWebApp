package com.appdirect.spring.model;

public class NotificationStatus {
	private String type;
	private Marketplace marketPlace;
	private Creator creator;
	private NotificationPayload payload;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Marketplace getMarketPlace() {
		return marketPlace;
	}
	public void setMarketPlace(Marketplace marketPlace) {
		this.marketPlace = marketPlace;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	public NotificationPayload getPayload() {
		return payload;
	}
	public void setPayload(NotificationPayload payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "NotificationStatus [type=" + type + ", marketPlace=" + marketPlace + ", creator=" + creator
				+ ", payload=" + payload + "]";
	}
}
