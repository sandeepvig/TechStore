package com.svig.techstore.core.exception;

public class DataAccessException extends Exception{

	private static final long serialVersionUID = 1L;

	public DataAccessException(Exception ex) {
		super(ex);
	}
	
}
