package com.springboot.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.products.entity.Role;
import com.springboot.products.entity.User;
import com.springboot.products.repository.RoleRepository;
import com.springboot.products.repository.UserRepository;
import com.springboot.products.security.SecurityService;

@Controller
public class UserController {
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/showReg")
	public String showRegisterUser(Model model) {
		List<Role> roles = roleRepo.findAll();
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "showRegisterUser";
	}

	@PostMapping("/register")
	public String registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("user details" + user);
		userRepo.save(user);
		return "login";
	}

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("login submitted");
		boolean result = securityService.login(email, password);
		System.out.println("result :" + result);
		if (result) {
			return "index";
		}
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
