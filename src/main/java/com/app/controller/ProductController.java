package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductByCategory(@PathVariable Long productId) {
		String status = productServ.deleteProduct(productId);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
