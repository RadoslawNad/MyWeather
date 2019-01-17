package com.myweather.initial;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myweather.model.Role;
import com.myweather.model.User;
import com.myweather.repository.RoleRepository;
import com.myweather.repository.UserRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	@Lazy 
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		createRoleIfNotFound("ROLE_ADMIN");
		createRoleIfNotFound("ROLE_USER");
		
		createUserIfNotFound("user","USER");
		createUserIfNotFound("admin","ADMIN");

		alreadySetup = true;
	}

	@Transactional
	private Role createRoleIfNotFound(String name) {

		Role role = roleRepository.findByRole(name);
		if (role == null) {
			role = new Role(name);
			roleRepository.save(role);
		}
		return role;
	}
	
	@Transactional
	private User createUserIfNotFound(String name,String role) {
		
		User user = userRepository.findByUsername(name);
		if (user == null) {
			Role userRole = roleRepository.findByRole("ROLE_"+role);
			user=new User();
			user.setName(name);
			user.setPassword(passwordEncoder.encode(name));
			user.setUsername(name);
			user.setRoles(Arrays.asList(userRole));
			user.setEnabled(true);
			userRepository.save(user);
		}
		return user;
	}
}
