package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	@Id
	@Column(name = "address_id")
	private int addressId;
	
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	

}
