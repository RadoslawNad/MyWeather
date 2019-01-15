package com.myweather.configuration.registration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;
		
		createRoleIfNotFound("ROLE_ADMIN");
		createRoleIfNotFound("ROLE_USER");
		createRoleIfNotFound("ROLE_GUEST");

		Role adminRole = roleRepository.findByRole("ROLE_ADMIN");
		User user = new User();
		user.setName("Test");
		// user.setPassword(passwordEncoder.encode("test"));
		user.setPassword("test");
		user.setUsername("test@test.com");
		user.setRoles(Arrays.asList(adminRole));
		user.setEnabled(true);
		userRepository.save(user);

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
	
}
