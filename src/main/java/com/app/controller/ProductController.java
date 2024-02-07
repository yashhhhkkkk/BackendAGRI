package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ProductDTO;
import com.app.entity.Product;
import com.app.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping("/all")
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products =  productServ.getAllProducts();
		
		return products;
	}

}
