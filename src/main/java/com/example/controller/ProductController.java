package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.services.ProductService;

@RestController
@RequestMapping(name = "product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("addProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/{productId}/products/{categoryId}")
	public Product assignProductToCategory(@PathVariable int categoryId,@PathVariable int productId) {
		return productService.assignProductToCategory(categoryId,productId);
	}
	
	@PutMapping("/productUpdate/{id}")
	public Product productUpdate(@PathVariable int id,@RequestBody Product product) {
		product.setId(id);
		return productService.productUpdate(product);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteProduct(id);
	}

	@GetMapping("product")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> findById(@PathVariable Integer id) {
		return productService.findById(id);
	}
	

}
