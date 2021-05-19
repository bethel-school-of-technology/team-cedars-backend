package com.cedarsbackend.auth;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MySQLUserDetailsService implements UserDetailsService {	
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
				
		@Override
		public UserDetails loadUserByUsername(String username) {
			UserLogin userLogin = userRepository.findByUsername(username);
			if (userLogin == null) {
			throw new UsernameNotFoundException(username);
			}
			return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), getAuthorities());
		}
		public UserDetails Save(UserLogin newUser) {
		    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		    UserLogin savedUser = userRepository.save(newUser);
		    return new org.springframework.security.core.userdetails.User(savedUser.getUsername(), savedUser.getPassword(), getAuthorities());
		  }

		private List<SimpleGrantedAuthority> getAuthorities() {
		    List<SimpleGrantedAuthority> authList = new ArrayList<>();
		    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		    return authList;
		  }
}

