package com.cedarsbackend.signup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, Long>{
	SignUp findById(String id);
}
