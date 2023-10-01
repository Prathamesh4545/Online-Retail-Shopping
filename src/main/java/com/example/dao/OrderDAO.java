package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.OrderDB;

public interface OrderDAO extends JpaRepository<OrderDB, Integer> {

	@Query("select * from orderdb where orderdb.customer_mobile_number = ")
	List<OrderDB> getOrderByCustomerMobileNumber(long customerMobileNumber);

}
