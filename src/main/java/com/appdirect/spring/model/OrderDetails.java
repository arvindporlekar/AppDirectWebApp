package com.appdirect.spring.model;

public class OrderDetails {
	private String editionCode;
	private String pricingDuration;
	private ItemDetails item;
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public ItemDetails getItem() {
		return item;
	}
	public void setItem(ItemDetails item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "OrderDetails [editionCode=" + editionCode + ", pricingDuration=" + pricingDuration + ", item=" + item
				+ "]";
	}
}
