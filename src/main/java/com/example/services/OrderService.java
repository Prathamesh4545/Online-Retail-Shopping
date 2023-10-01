package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dao.OrderDAO;
import com.example.entity.OrderDB;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;

	public OrderDB createOrder(OrderDB orderDB) {
		return orderDAO.save(orderDB);
	}

	public Optional<OrderDB> getOrderById(int orderId) {
		return orderDAO.findById(orderId);
	}

	public List<OrderDB> getOrderByCustomerMobileNumber(long customerMobileNumber) {
		return orderDAO.getOrderByCustomerMobileNumber(customerMobileNumber);
	}

}
