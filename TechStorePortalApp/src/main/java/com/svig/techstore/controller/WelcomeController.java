/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.svig.techstore.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.svig.techstore.config.Constants;
import com.svig.techstore.core.dao.CartRepository;
import com.svig.techstore.core.dao.OrderRepository;
import com.svig.techstore.core.dao.ProductRepository;
import com.svig.techstore.core.dao.UserRepository;
import com.svig.techstore.core.vo.CartItem;
import com.svig.techstore.core.vo.CartItemPK;
import com.svig.techstore.core.vo.Currency;
import com.svig.techstore.core.vo.Order;
import com.svig.techstore.core.vo.OrderItem;
import com.svig.techstore.core.vo.OrderStatus;
import com.svig.techstore.core.vo.Product;
import com.svig.techstore.core.vo.User;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private OrderRepository orderRepo;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message + "SVIG_TEST_MESSAGE");
		//return "welcome";
		return "login"; //this return value is the name of the jsp page that will be invoked
	}

	@RequestMapping(value="/login", method={RequestMethod.GET, RequestMethod.POST})
	public String login(Model model, HttpServletRequest request, HttpSession session ) {
		
		User currentUser = null;
		session.removeAttribute(Constants.CURRENT_USER); //logout existing user, if any
		
		String userId = request.getParameter(Constants.RequestParams.USERID);
		String password = request.getParameter(Constants.RequestParams.PASSWORD);
		
		if(userId!=null && password!=null) {
			model.addAttribute(Constants.ACTION, Constants.ACTION_LOGIN);
			
			currentUser = userRepo.findByEmailAndPassword(userId, password);
			System.out.println("User Found: " + currentUser);
			session.setAttribute(Constants.CURRENT_USER, currentUser);

			if(currentUser!=null) {
				loadUser(model, currentUser);
				loadCart(model, currentUser);
				loadProducts(model);
			}
		}
		
		return "view"; //this return value is the name of the jsp page that will be invoked
	}
	
	@RequestMapping(value="/cart", method={RequestMethod.GET, RequestMethod.POST})
	public String cart(Model model, HttpSession session) {
		model.addAttribute(Constants.ACTION, Constants.ACTION_CART);
		User currentUser = (User)session.getAttribute(Constants.CURRENT_USER);
		if(currentUser!=null) {
			loadUser(model, currentUser);
			loadCart(model, currentUser);
			loadProducts(model);			
		}

		return "view";
	}
	
	@RequestMapping(value="/orders", method= {RequestMethod.GET, RequestMethod.POST})
	public String orders(Model model, HttpSession session) {
		model.addAttribute(Constants.ACTION, Constants.ACTION_ORDERS);
		User currentUser = (User)session.getAttribute(Constants.CURRENT_USER);
		if(currentUser!=null) {
			loadOrders(model, currentUser);
		}
		return "view";
	}
	
	@Transactional
	@RequestMapping(value = "/removeFromCart" , method = RequestMethod.POST)
	public String removeFromCart(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute(Constants.ACTION, Constants.ACTION_REMOVEFROMCART);
		User currentUser = (User)session.getAttribute(Constants.CURRENT_USER);
		if(currentUser!=null) {
			String productID = request.getParameter(Constants.RequestParams.PRODUCT_ID);
			cartRepo.delete(new CartItemPK(currentUser.getEmail(), productID));
			
			loadUser(model, currentUser);
			loadCart(model, currentUser);
			loadProducts(model);
		}
		return "view";
	}
	
	@Transactional
	@RequestMapping(value = "/addToCart" , method = RequestMethod.POST)
	public String addToCart(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute(Constants.ACTION, Constants.ACTION_ADDTOCART);

		User currentUser = (User)session.getAttribute(Constants.CURRENT_USER);
		if(currentUser!=null) {
			String productID = request.getParameter(Constants.RequestParams.PRODUCT_ID);
			CartItem cartItem = cartRepo.findOne(new CartItemPK(currentUser.getEmail(), productID));
			if(cartItem!=null) {
				cartItem.setQuantity(cartItem.getQuantity()+1);
			}else {
				cartItem = new CartItem();
				cartItem.setUserID(currentUser.getEmail());
				cartItem.setProductID(productID);
				cartItem.setQuantity(1);
				cartRepo.save(cartItem);
				//cartRepo.findOne(new CartItemPK(currentUser.getEmail(), productID));
				//cartItem = null;
			}
			
			loadUser(model, currentUser);
			loadCart(model, currentUser);
			loadProducts(model);
		}

		return "view";
	}
	
	@Transactional
	@RequestMapping(value="/submitOrder" , method = RequestMethod.POST)
	public String submitOrder(Model model, HttpSession session) {
		model.addAttribute(Constants.ACTION, Constants.ACTION_SUBMITORDER);
		User currentUser = (User)session.getAttribute(Constants.CURRENT_USER);
		
		if(currentUser!=null) {
			Collection<CartItem> cart = cartRepo.findAllByUserID(currentUser.getEmail());
			Order order = new Order();
			order.setUserID(currentUser.getEmail());
			order.setOrderDate(Date.from(Instant.now()));
			order.setOrderTime(Date.from(Instant.now()));
			order.setStatus(OrderStatus.NEW.toString());
			order.setExpectedDeliveryDate(Date.from(Instant.now().plus(3, ChronoUnit.DAYS)));
			for (CartItem cartItem : cart) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder(order);
				orderItem.setPricePerItem(cartItem.getProduct().getPrice());
				orderItem.setProductID(cartItem.getProductID());
				//orderItem.setProduct(cartItem.getProduct());
				orderItem.setQuantity(cartItem.getQuantity());
				orderItem.setCcy(Currency.SGD.toString());
				
				cartRepo.delete(cartItem); //tried writing a deleteByUserID(), that needs a higher version of spring boot
			}
			System.out.println("Saving Order: " + order);
			orderRepo.save(order);
			System.out.println("Saved Order: " + order);
			
			//cartRepo.deleteByUserID(currentUser.getEmail()); //needs 1.5.1 version of spring boot
			
			//loadUser(model, currentUser);
			//loadCart(model, currentUser);
			//loadProducts(model);
			loadOrders(model, currentUser);			
		}

		return "view";
	}
	
	private void loadUser(Model model, User user) {
		model.addAttribute(Constants.CURRENT_USER, user);
	}
	
	private void loadCart(Model model, User user) {
		if(user!=null) {
			System.out.println("Loading cart for: " + user);
			Collection<CartItem> cart = cartRepo.findAllByUserID(user.getEmail());
			model.addAttribute(Constants.CART, cart);
			System.out.println("Loaded cart for: " + user + ", " + cart);
		}
	}
	
	private void loadOrders(Model model, User user) {
		if(user!=null) {
			Collection<Order> orders = (Collection<Order>)orderRepo.findAll();
			System.out.println("Orders Loaded: " + orders);
			model.addAttribute(Constants.ORDERS, orders);
		}
	}
	
	private void loadProducts(Model model) {
		Collection<Product> products = productRepo.findAll();
		System.out.println("Products Loaded: " + products);
		model.addAttribute(Constants.PRODUCTS, products);
	}

	private void createOrder() {
		
	}
}
