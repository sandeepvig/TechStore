package com.svig.techstore.core.vo;

import java.io.Serializable;

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
	private String productID;
	
	private int quantity;
	private double pricePerItem;
	private String ccy;

	@ManyToOne
	@JoinColumn(name = "orderID", insertable = false, updatable = false)
	private Order order;
	
	/**
	 * note: @OneToOne relationship has to be specified when using @JoinColumn
	 */
	@OneToOne
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

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
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
	public int hashCode() {
		return (orderID + "-" + productID).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("OrderItem[");
		buff.append("productID: " + productID);
		buff.append(", productName: " + product.getName());
		buff.append(", quantity: " + quantity);
		buff.append(", pricePerItem: " + pricePerItem);
		buff.append(", ccy: " + ccy);
		buff.append("]");
		
		return buff.toString();
	}
	
	
}
