package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
