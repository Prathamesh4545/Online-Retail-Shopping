package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderDB;
import com.example.entity.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer>{

}
