package com.example.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartItemsDAO;
import com.example.dao.ProductDAO;
import com.example.dao.ShoppingCartDAO;
import com.example.entity.CartItem;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.entity.ShoppingCart;

@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartDAO shoppingCartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemsDAO cartItemsDAO;
	
	public ShoppingCart addData(ShoppingCart shoppingCart) {
		
		return shoppingCartDAO.save(shoppingCart);
	}
	

	public List<ShoppingCart> getAllShopping() {
		return shoppingCartDAO.findAll();
	}

	public Optional<ShoppingCart> currentUserShoppingCart(int id) {
		return shoppingCartDAO.findById(id);
	}
	
	





}
