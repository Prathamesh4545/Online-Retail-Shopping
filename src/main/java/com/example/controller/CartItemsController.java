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
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CartItem;
import com.example.services.CartItemService;

@RestController
@RequestMapping(name="cart_item")
public class CartItemsController {
	
	@Autowired
	CartItemService cartItemService;
	
	@GetMapping("carts")
	public List<CartItem> allItems(){
		return cartItemService.allItems();
	}
	
	@GetMapping("carts/{id}")
	public Optional<CartItem> specificProduct(@PathVariable int id) {
		return cartItemService.specificProduct(id);
	}
	
	@PostMapping("cart/{cartId}/add/{productId}")
	public CartItem addCardItem(
			@RequestBody CartItem cartItem,@PathVariable int cartId, @PathVariable int productId) {
		return cartItemService.addCardItem(cartItem,cartId,productId);
	}
	
	
	@PutMapping("cart/{cartId}/update/{productId}")
	public CartItem addProduct(@PathVariable int cartId, @PathVariable int productId) {
		return cartItemService.addProduct(cartId, productId);
	}
	
	@DeleteMapping("cartItem/delete/{id}")
	public String deleteCartProduct(@PathVariable Integer id) {
		return cartItemService.deleteCartProduct(id);
	}
	
	@DeleteMapping("deleteAllCartItem")
	public String deleteAllCartItem() {
		return cartItemService.deleteAllCartItem();
	}

	

}
