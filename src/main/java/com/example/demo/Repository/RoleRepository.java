package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Role;
import com.example.demo.modal.RoleName;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long>{

	
	Optional<Role> findByRole(RoleName role);
	
	
}