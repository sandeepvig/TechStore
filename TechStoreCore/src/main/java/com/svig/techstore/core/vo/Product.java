package com.svig.techstore.core.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "product", schema = "techstore")
public class Product{

	@Id
	private int productID;
	private String name;
	private String description;
	private double price;
	private String ccy;
	
	public Product() {
	}

	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	@Override
	public boolean equals(Object other) {
		if(other==null || !(other instanceof Product)) {
			return false;
		}
		
		return this.getProductID()== ((Product)other).getProductID();
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(productID);
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("Product[");
		buff.append("productID: " + productID);
		buff.append(", name: " + name);
		buff.append(", desc: " + description);
		buff.append(", price: " + price);
		buff.append(", ccy: " + ccy);
		buff.append("]");
		
		return buff.toString();
	}
}
