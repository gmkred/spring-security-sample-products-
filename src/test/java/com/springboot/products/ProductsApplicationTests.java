package com.springboot.products;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.products.entity.Product;
import com.springboot.products.entity.Role;
import com.springboot.products.repository.ProductRepository;
import com.springboot.products.repository.RoleRepository;

@SpringBootTest
class ProductsApplicationTests {
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private ProductRepository productRepo;

	@Test
	void saveRoles() {
		Role admin = new Role();
		admin.setName("ROLE_ADMIN");
		Role user = new Role();
		user.setName("ROLE_USER");
		List<Role> roles = Arrays.asList(admin, user);
		roleRepo.saveAll(roles);
	}
	@Test
	void saveProduct() {
		Product product = new Product();
		product.setName("SAMSUNG");
		product.setPrice(new BigDecimal(17000.00));
		productRepo.save(product);
	}
	

}
