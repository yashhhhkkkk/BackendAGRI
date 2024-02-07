package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20,name = "order_status")
	private OrderStatus orderStatus;

	@Column(name = "order_amount")
	private double orderAmount;

	@CreationTimestamp
	private LocalDate orderDate;
	
	//the date on which order was delivered!
	private LocalDate deliveryDate;	

	@Column(name = "shipping_fee")
	private double shippingFee;
	
	// Order *----->1 Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	//Order 1--->1 DeliveryAddress : uni dir association currently. : currently configured as embeddable
	@OneToOne
	@JoinColumn(name="adr_id")
	private Address address;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20,name = "payment_status")
	private PaymentStatus paymentStatus;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	// helper methods to add n remove the order item
	public void addOrderItem(OrderItem item)
	{
		orderItems.add(item);
		item.setOrder(this);
	}
	public void removeOrderItem(OrderItem item)
	{
		orderItems.remove(item);
		item.setOrder(null);
	}
	
}
