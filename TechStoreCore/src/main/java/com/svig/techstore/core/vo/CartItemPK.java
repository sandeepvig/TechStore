package com.svig.techstore.core.vo;

import java.io.Serializable;

public class CartItemPK implements Serializable{

	private String userID;
	
	private String productID;

	public CartItemPK() {
	}
	
	public CartItemPK(String userID, String productID) {
		this.userID = userID;
		this.productID = productID;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
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
		
		return this.getUserID().equals(((CartItemPK)other).getUserID()) && this.getProductID().equals(((CartItemPK)other).getProductID());
	}
	
}
