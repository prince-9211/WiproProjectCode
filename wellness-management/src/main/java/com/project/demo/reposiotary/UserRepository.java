package com.project.demo.reposiotary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	boolean existsByEmail(String email);
    User findByEmail(String email);
		
}