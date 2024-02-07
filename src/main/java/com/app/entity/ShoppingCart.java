package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "carts")
@Getter
@Setter
@ToString(exclude = {"cartOwner","cartItems"})
public class ShoppingCart {
	
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total_cart_price")
	private double totalCartPrice;
	
	
	// Cart HAS-A Customer : uni dir asso between Cart 1----->1 Customer (owning side) : so LAZY should work ! I confirmed : using debugger : show User proxy
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id") // FK constraint
	private Customers customer;

	// Cart HAS-A CartItems : bi dir asso between Cart 1---->* CartItem
	@OneToMany(mappedBy = "myCart", cascade = {CascadeType.ALL}, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<CartItems> cartItems = new ArrayList<>();
	
	@Column(name = "total_items")
	private int totalItems;

	//helper method
//	public void addItem(CartItems shoppingCartItem) {
//		cartItems.add(shoppingCartItem);
//		shoppingCartItem.setMyCart(this);		
//	}
//	public void removeItem(CartItems shoppingCartItem) {
//		cartItems.remove(shoppingCartItem);
//		shoppingCartItem.setMyCart(null);		
//	}
}
