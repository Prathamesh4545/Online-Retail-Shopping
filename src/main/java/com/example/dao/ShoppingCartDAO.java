package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCart;

public interface ShoppingCartDAO extends JpaRepository<ShoppingCart, Integer>{


}
