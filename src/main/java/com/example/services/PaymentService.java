package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDAO;
import com.example.dao.PaymentDAO;
import com.example.entity.Category;
import com.example.entity.OrderDB;
import com.example.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@Autowired
	OrderDAO orderDAO;

	public Payment checkout(Payment payment,int orderId) {
		OrderDB orderDB = orderDAO.findById(orderId).get();
		payment.setOrderDB(orderDB);
		payment.setAmount(orderDB.getTotalAmount());
		return paymentDAO.save(payment);
	}	
	public List<Payment> history() {
		return paymentDAO.findAll();
	}
	
	

}
