package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.OrderItem;
import com.example.services.OrderItemsService;

@RestController
@RequestMapping(name="orderItem")
public class OrderItemsController {
	
	@Autowired
	OrderItemsService orderItemsService;
	
	@PostMapping("addItem/{orderId}/add/{productId}")
	public OrderItem addItems(@RequestBody OrderItem orderItem,@PathVariable int orderId,@PathVariable int productId) {
		return orderItemsService.addItems(orderItem, orderId, productId);
	}

}
