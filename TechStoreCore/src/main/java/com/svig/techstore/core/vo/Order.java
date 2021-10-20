package com.svig.techstore.core.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order", schema = "techstore")
public class Order {

	@Id
	private int orderID;
	
	private String userID;
	private String status;
	
	@Column(name ="orderdate")
	private Date orderDate;
	@Column(name = "ordertime")
	private Date orderTime;
	private Date expectedDeliveryDate;
	
	@Column(name = "actualDeliveryDate")
	private Date deliveryDate;
	
	/**
	 * note: for OneToMany relationship to work, the datatype has to be java.util.Collection, java.util.ArrayList does not work
	 */
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER) //note: mappedBy refers to the field on OrderItem.class
	private Collection<OrderItem> orderItems;
	
	public Order() {
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Collection<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(orderID).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("Order[");
		buff.append("orderID: " + orderID);
		buff.append(", userID: " + userID);
		buff.append(", status: " + status);
		buff.append(", orderDate: " + orderDate);
		buff.append(", orderTime: " + orderTime);
		buff.append(", expectedDeliveryDate: " + expectedDeliveryDate);
		buff.append(", deliveryDate: " + deliveryDate);
		buff.append(", items: " + orderItems);
		buff.append("]");
		
		return buff.toString();
	}
}
