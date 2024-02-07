package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ProductDTO;
import com.app.dao.ProductDao;
import com.app.entity.Product;

@Service
public class ProductServiceimpl implements ProductService{
	private ModelMapper mapper=new ModelMapper();
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductDTO> products = productDao.findAll().stream()
				                    .map(product -> mapper.map(product,ProductDTO.class)).collect(Collectors.toList());
		return products ;
	}

}
