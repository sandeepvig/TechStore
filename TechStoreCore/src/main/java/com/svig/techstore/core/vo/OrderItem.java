package com.svig.techstore.core.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem" , schema = "techstore")
@IdClass(value = OrderItemPK.class)
public class OrderItem implements Serializable{

	@Id
	private int orderID;
	
	@Id
	private int productID;
	
	private int quantity;
	private double pricePerUnit;
	private String ccy;

	@ManyToOne
	@JoinColumn(name = "orderID", insertable = false, updatable = false)
	private Order order;
	
	/**
	 * note: @OneToOne relationship has to be specified when using @JoinColumn
	 */
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "productID" , insertable = false, updatable = false)
	private Product product;
	
	public OrderItem() {
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object other) {
		if(other==null || !(other instanceof OrderItem)) {
			return false;
		}
		
		OrderItem obj = (OrderItem)other;
		
		return this.getOrderID()==obj.getOrderID() && this.getProductID()==obj.getProductID();
	}
	
	@Override
	public int hashCode() {
		return (orderID + "-" + productID).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("OrderItem[");
		buff.append("orderID: " + orderID);
		buff.append(", productID: " + productID);
		buff.append(", productName: " + (product!=null?product.getName():null));
		buff.append(", quantity: " + quantity);
		buff.append(", pricePerUnit: " + pricePerUnit);
		buff.append(", ccy: " + ccy);
		buff.append("]");
		
		return buff.toString();
	}
	
	
}
