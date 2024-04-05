package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.OrderDB;
import com.example.services.OrderService;

@RestController
@RequestMapping(name = "order")
public class OrderController {

	final
	OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("createOrder")
	public OrderDB createOrderDB(@RequestBody OrderDB orderDB) {
		return orderService.createOrder(orderDB);
	}

	@GetMapping("order/{orderId}")
	public Optional<OrderDB> getOrderById(@PathVariable int orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@GetMapping("orders/{customerMobileNumber}")
	public List<OrderDB> getOrderByCustomerMobileNumber(@PathVariable long customerMobileNumber){
		return orderService.getOrderByCustomerMobileNumber(customerMobileNumber);
	}
}
