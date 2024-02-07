package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ShoppingCart;

public interface CartDao extends JpaRepository<ShoppingCart, Long>{

}
