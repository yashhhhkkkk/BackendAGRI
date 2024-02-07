package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Customers;

public interface CustomerDao extends JpaRepository<Customers, Long>{

}
