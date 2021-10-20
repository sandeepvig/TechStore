package com.svig.techstore.core.dao;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.svig.techstore.core.vo.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String>{
	
	public Collection<Order> findByUserID(int userID);

}
