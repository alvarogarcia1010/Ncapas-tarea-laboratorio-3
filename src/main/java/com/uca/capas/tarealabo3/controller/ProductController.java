package com.uca.capas.tarealabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarealabo3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> products = new ArrayList<Product>();

	public ProductController() {
		super();
		this.products.add(new Product(0, "Churritos", 10));
		this.products.add(new Product(1, "Jalapeños", 20));
		this.products.add(new Product(2, "Quesitos", 30));
		this.products.add(new Product(3, "Pachanga mix",25));
		this.products.add(new Product(4, "Tostecas",15));
		this.products.add(new Product(5, "Nachos", 5));
		this.products.add(new Product(6, "Palitos", 1));
		this.products.add(new Product(7, "Alborotos", 40));
		this.products.add(new Product(8, "Korchips", 15));
	}
	
	@GetMapping("/productos")
	public ModelAndView Products() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("products", this.products);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		String view = "compra";
		
		if((product.getCantidad()) > this.products.get(product.getId()).getCantidad()) {
			view = "error";
		}
		
		mav.setViewName(view);
		mav.addObject("productName", this.products.get(product.getId()).getNombre());
		
		return mav;
	}

}
