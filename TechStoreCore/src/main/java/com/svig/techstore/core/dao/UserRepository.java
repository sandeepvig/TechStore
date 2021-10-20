package com.svig.techstore.core.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.svig.techstore.core.vo.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	public User findByEmailAndPassword(String email, String password);
}
