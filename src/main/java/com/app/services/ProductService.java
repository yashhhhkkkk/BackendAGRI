package com.app.services;

import java.util.List;

import com.app.DTO.ProductDTO;
import com.app.entity.Product;

public interface ProductService {

	List<ProductDTO> getAllProducts();

}
