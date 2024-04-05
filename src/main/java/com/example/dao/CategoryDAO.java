package com.example.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Category;


public interface CategoryDAO extends JpaRepository<Category, Integer>{

	@Query("select product from product inner join category on product.categoryId = category.id where category.name=?")
	Optional<Category> findByName(String name);

}
