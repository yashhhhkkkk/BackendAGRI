//package com.app.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
////@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class Wishlist {
//	
//	@Id
//	@Column(name = "wishlist_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private Customers customer;
//	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	@JoinColumn(name = "product_id")
//	private List<Product> product;
//	
//	
//	
//
//}
