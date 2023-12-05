package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;
import com.kh.springdb.model.vo.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
}
