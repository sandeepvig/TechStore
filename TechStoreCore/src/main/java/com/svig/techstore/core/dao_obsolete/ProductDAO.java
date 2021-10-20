package com.svig.techstore.core.dao_obsolete;

import java.util.List;

import com.svig.techstore.core.exception.DataAccessException;
import com.svig.techstore.core.vo.Product;

public interface ProductDAO {

	public List<Product> getProducts() throws DataAccessException;
	
	public List<Product> getActiveProducts() throws DataAccessException;
	
}
