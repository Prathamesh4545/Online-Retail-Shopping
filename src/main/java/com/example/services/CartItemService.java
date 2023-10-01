package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartItemsDAO;
import com.example.dao.ProductDAO;
import com.example.dao.ShoppingCartDAO;
import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCart;

@Service
public class CartItemService {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartItemsDAO cartItemsDAO;

	@Autowired
	ShoppingCartDAO shoppingCartDAO;

	public List<CartItem> allItems() {
		return cartItemsDAO.findAll();
	}

	public Optional<CartItem> specificProduct(int id) {
		return cartItemsDAO.findById(id);
	}

	public CartItem addCardItem(CartItem cartItem , int cartId, int productId) {
		Product product = productDAO.findById(productId).get();
		ShoppingCart shoppingCart = shoppingCartDAO.findById(cartId).get();
		cartItem.setProduct(product);
		cartItem.setShoppingCart(shoppingCart);
		return cartItemsDAO.save(cartItem);
	}

	public CartItem addProduct(int cartId, int productId) {
		Product product = productDAO.findById(productId).get();
		CartItem cartItem = cartItemsDAO.findById(cartId).get();
		cartItem.setProduct(product);
		return cartItemsDAO.save(cartItem);
	}

	public String deleteCartProduct(int id) {
		cartItemsDAO.deleteById(id);
		return "Delete Successfully";
	}

	public String deleteAllCartItem() {
		cartItemsDAO.deleteAll();
		return "Cart Clear Successfully";
	}

}
