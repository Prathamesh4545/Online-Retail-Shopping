package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.services.CategoryService;


@RestController
@RequestMapping(name="category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("addCategory")
	public Category createCategeory(@RequestBody Category category){
		return categoryService.createCategeory(category);
	}

	@GetMapping("getAllCategory") 
	public ResponseEntity<List<Category>> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping("/allProduct/{name}")
	public Optional<Category> findByName(@PathVariable String name) {
		return categoryService.findByName(name);
	}

}
