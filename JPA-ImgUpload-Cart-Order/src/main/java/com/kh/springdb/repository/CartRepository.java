package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
