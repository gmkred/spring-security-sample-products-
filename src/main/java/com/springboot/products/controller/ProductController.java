package com.springboot.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.products.entity.Product;
import com.springboot.products.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/showCreateProduct")
	public String showCreateProduct(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		return "createProduct";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(Product product, Model model) {
		productRepo.save(product);
		String message = "Product details saved";
		model.addAttribute("message", message);
		return "success";
	}

	@GetMapping("/getProducts")
	public String getProdects(Model model) {
		List<Product> products = productRepo.findAll();
		model.addAttribute("products", products);
		return "getProducts";
	}

	@GetMapping("/getProductByName")
	public String getProductByName(String name, Model model) {
		Product product = productRepo.getProductByName(name);
		model.addAttribute("product", product);
		return "getProduct";
	}

	@PostMapping("/deleteProductByName")
	public String deleteProduct(String name, Model model) {
		productRepo.delete(productRepo.getProductByName(name));
		System.out.println(name + " deleted from product list");
		String message = "Product details deleted";
		model.addAttribute("message", message);
		return "success";
	}

	@GetMapping("/productByName")
	public String productByNamePageFS() {
		return "productByName";
	}

	@GetMapping("/delete")
	public String deleteProductPage() {
		return "deleteProduct";
	}
}
