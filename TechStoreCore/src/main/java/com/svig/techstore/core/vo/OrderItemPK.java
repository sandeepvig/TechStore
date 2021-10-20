package com.svig.techstore.core.vo;

import java.io.Serializable;

public class OrderItemPK implements Serializable{

	private int orderID;
	private String productID;
	
	public OrderItemPK() {
	}

	public OrderItemPK(int orderID, String productID) {
		this.orderID = orderID;
		this.productID = productID;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	@Override
	public boolean equals(Object other) {
		if(other==null || !(other instanceof OrderItemPK)) {
			return false;
		}
		
		OrderItemPK obj = (OrderItemPK)other;
		
		return this.getOrderID()==obj.getOrderID() && this.getProductID().equals(obj.getProductID());
	}
	
	@Override
	public int hashCode() {
		return (orderID+"-"+productID).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("OrderItemPK[");
		buff.append("orderID: " + orderID);
		buff.append(", productID: " + productID);
		buff.append("]");
		
		return buff.toString();
	}
}
