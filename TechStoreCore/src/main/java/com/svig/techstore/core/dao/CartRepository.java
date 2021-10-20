package com.svig.techstore.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.svig.techstore.core.vo.CartItem;
import com.svig.techstore.core.vo.CartItemPK;

@Repository
public interface CartRepository extends CrudRepository<CartItem, CartItemPK>{

	public List<CartItem> findAllByUserID(String userID);
	
	/***
	 * needs 1.5.1.RELEASE version of spring boot
	@Modifying
	public List<CartItem> deleteByUserID(String userID);
	***/
}
