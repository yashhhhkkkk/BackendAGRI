package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> , CrudRepository<Product, Long>{
	


}
