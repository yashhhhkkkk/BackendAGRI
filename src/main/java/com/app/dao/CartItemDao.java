package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CartItems;

public interface CartItemDao extends JpaRepository<CartItems, Long> {

}
