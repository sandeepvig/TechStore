package com.svig.techstore.core.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.svig.techstore.core.vo.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String>{

	List<Product> findAll();
}
