package com.svig.techstore.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.svig.techstore.core.dao.ProductRepository;

@Controller
@RequestMapping
public class ProductsController {
	
	/***
	@Bean
	public String viewProducts(Model model, ProductRepository productRepo) {
		model.addAttribute("products", productRepo.findAll());
		return "products";
	}
	***/
}
