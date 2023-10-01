package com.example.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryDAO;
import com.example.dao.ProductDAO;
import com.example.entity.Category;
import com.example.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	public Product createProduct(Product product) {
		return productDAO.save(product);
	}

	public Product assignProductToCategory(int categoryId, int productId) {
		Product product = productDAO.findById(productId).get();
		Category category = categoryDAO.findById(categoryId).get();

		product.assignTo(category);
		return productDAO.save(product);
	}

	public Product productUpdate(Product product) {
		return productDAO.save(product);
	}

	public String deleteProduct(int id) {
		productDAO.deleteById(id);
		return "Delete Successfully";
	}

	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	public Optional<Product> findById(int id) {
		return productDAO.findById(id);
	}

}
