package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDAO;
import com.example.dao.OrderItemsDAO;
import com.example.dao.ProductDAO;
import com.example.entity.OrderDB;
import com.example.entity.OrderItem;
import com.example.entity.Product;

@Service
public class OrderItemsService {

	@Autowired
	OrderItemsDAO orderItemsDAO;

	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	ProductDAO productDAO;
	

	public OrderItem addItems(OrderItem orderItem, int orderId, int productId) {
		
		Product product = productDAO.findById(productId).get();
		OrderDB orderDB = orderDAO.findById(orderId).get();
		
		orderItem.setProduct(product);
		orderItem.setOrderDB(orderDB);
		if (product.getQuantityInStock() != 0) {
			long price = product.getPrice();
			orderItem.setUnitPrice(price);
			orderDB.setTotalAmount(price * orderItem.getQuantity());
			orderDAO.save(orderDB);
			int reservedQuantity = product.getReservedQuantity();
			int quantityInStock = product.getQuantityInStock();
			
			product.setReservedQuantity(reservedQuantity + orderItem.getQuantity());
			product.setQuantityInStock(quantityInStock - orderItem.getQuantity());
			
			
		}
		return orderItemsDAO.save(orderItem);
	}

}
