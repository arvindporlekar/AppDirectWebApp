package com.appdirect.spring.model;

public class NotificationPayload {
	private CompanyDetails company;
	private OrderDetails order;
	public CompanyDetails getCompany() {
		return company;
	}
	public void setCompany(CompanyDetails company) {
		this.company = company;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "NotificationPayload [company=" + company + ", order=" + order + "]";
	}
	
}