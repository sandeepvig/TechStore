package com.svig.techstore.core.dao_obsolete.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import com.svig.techstore.core.dao_obsolete.ProductDAO;
import com.svig.techstore.core.exception.DataAccessException;
import com.svig.techstore.core.vo.Product;

public class ProductDAOImpl implements ProductDAO{

	private static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";
	private static final String GET_ALL_ACTIVE_PRODUCTS = "SELECT * FROM PRODUCT WHERE ACTIVE='Y'";
	
	private static final String PRODUCT_ID = "productid";
	private static final String PRODUCT_NAME = "name";
	private static final String PRODUCT_DESC = "description";
	private static final String PRODUCT_PRICE = "price";
	
	private PreparedStatement stmtGetAllActiveProducts;
	
	private DataSource dataSource;
	
	
	public ProductDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private void initialize() throws DataAccessException{
		Connection conn = null;
		try {
			conn = this.dataSource.getConnection();
		stmtGetAllActiveProducts = conn.prepareStatement(GET_ALL_ACTIVE_PRODUCTS);
		}catch(Exception ex) {
			throw new DataAccessException(ex);
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			}
		}
	}

	public List<Product> getProducts() throws DataAccessException{
		try{
			ResultSet rs = stmtGetAllActiveProducts.executeQuery();
			while(rs.next()) {
				String productID = rs.getString(PRODUCT_ID);
				String name = rs.getString(PRODUCT_NAME);
				String description = rs.getString(PRODUCT_DESC);
				Double price = rs.getDouble(PRODUCT_PRICE);
				
				//Product product = new Product();
			}
			
			
		}catch(Exception ex) {
			throw new DataAccessException(ex);
		}
		return null;
	}

	public List<Product> getActiveProducts() throws DataAccessException{
		return null;
	}
	
	
}
