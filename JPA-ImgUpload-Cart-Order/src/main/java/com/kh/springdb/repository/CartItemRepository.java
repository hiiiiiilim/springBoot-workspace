package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;

public interface CartItemRepository extends JpaRepository<Cart, Integer>{

}
