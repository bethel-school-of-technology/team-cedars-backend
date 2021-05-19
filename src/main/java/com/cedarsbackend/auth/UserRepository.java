package com.cedarsbackend.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, Long> {
	UserLogin findByUsername(String username);
}
