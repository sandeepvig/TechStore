package com.svig.techstore.core.vo;

import java.io.Serializable;

public class CartItemPK implements Serializable{

	private int userID;
	
	private int productID;

	public CartItemPK() {
	}
	
	public CartItemPK(int userID, int productID) {
		this.userID = userID;
		this.productID = productID;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public int hashCode() {
		return (userID + "-" + productID).hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other==null || !(other instanceof CartItemPK)) {
			return false;
		}
		
		CartItemPK obj = (CartItemPK)other;
		return this.getUserID()==obj.getUserID() && this.getProductID()== obj.getProductID();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("CartItemPK[");
		buff.append("userID: " + userID);
		buff.append(", productID: " + productID);
		buff.append("]");
		
		return buff.toString();
	}
	
}
