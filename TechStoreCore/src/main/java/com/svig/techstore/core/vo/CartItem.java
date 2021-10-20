package com.svig.techstore.core.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "cart", schema = "techstore")
@IdClass(CartItemPK.class)
public class CartItem implements Serializable{
	
	@Id
	private String userID;
	
	@Id
	private String productID;

	private int quantity;
	
	/**
	 * note: @OneToOne relationship has to be specified when using @JoinColumn
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productID", insertable = false , updatable = false)
	private Product product;
	
	public CartItem() {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public int hashCode() {
		return (userID + "-" + productID).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("CartItem[");
		buff.append("userID: " + userID);
		buff.append(", productID: " + productID);
		buff.append(", productName: " + (product!=null?product.getName():null));
		buff.append(", quantity: " + quantity);
		buff.append("]");
		
		return buff.toString();
	}
}
