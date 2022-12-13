package com.springboot.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.products.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
