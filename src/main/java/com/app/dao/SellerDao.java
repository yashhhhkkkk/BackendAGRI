package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Seller;

public interface SellerDao extends JpaRepository<Seller, Long>{

}
