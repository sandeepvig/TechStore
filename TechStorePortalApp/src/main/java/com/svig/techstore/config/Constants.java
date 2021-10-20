package com.svig.techstore.config;

public interface Constants {

	public String CURRENT_USER = "CurrentUser";
	
	public String ACTION = "Action";
	public String ACTION_SIGNUP = "Signup";
	public String ACTION_LOGIN = "Login";
	public String ACTION_LOGOUT = "Logout";
	public String ACTION_CART = "Cart";
	public String ACTION_ADDTOCART = "AddToCart";
	public String ACTION_REMOVEFROMCART = "RemoveFromCart";
	public String ACTION_ORDERS = "Orders";
	public String ACTION_SUBMITORDER = "SubmitOrder";
	
	public String PRODUCTS = "Products";
	public String CART = "Cart";
	public String ORDERS = "Orders";
	
	
	public interface RequestParams{
		public String USERID = "userid";
		public String EMAIL = "email";
		public String PASSWORD = "password";
		public String FIRSTNAME = "firstName";
		public String LASTNAME = "lastName";
		public String PRODUCT_ID = "product_id";
	}
}
