package com.appdirect.spring.model;

public class ItemDetails {
	private String quantity;
	private String unit;
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "ItemDetails [quantity=" + quantity + ", unit=" + unit + "]";
	}
}
