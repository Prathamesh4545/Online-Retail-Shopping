package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryDAO;
import com.example.entity.Category;
import com.example.entity.Product;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO categoryDAO;

	public Category createCategeory(Category category) {
		return categoryDAO.save(category);
	}
	
	public ResponseEntity<List<Category>> getAllCategory() {
		try {
			return ResponseEntity.ok(categoryDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public Optional<Category> findByName(String name) {
		return categoryDAO.findByName(name);
	}
}
