package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCart;
import com.example.services.ShoppingCartService;

@RestController
@RequestMapping(name = "shopping_cart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@PostMapping("shoppingCart")
	public ShoppingCart addData(@RequestBody ShoppingCart shoppingCart) {
		return shoppingCartService.addData(shoppingCart);
	}

	@GetMapping("cart")
	public List<ShoppingCart> getAllShopping() {
		return shoppingCartService.getAllShopping();
	}

	@GetMapping("cart/{id}")
	public Optional<ShoppingCart> currentUserShoppingCart(@PathVariable int id) {
		return shoppingCartService.currentUserShoppingCart(id);
	}

}
