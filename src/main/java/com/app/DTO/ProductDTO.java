package com.app.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	

	private String productName;
	
	private String description;
	
	private int price;
	

	private int stockQuantity;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "category_id", nullable = false) 
// 	private Category productCategory;
	
	
	private String imgURL;
	
	
	private LocalDate dateAdded;
}
