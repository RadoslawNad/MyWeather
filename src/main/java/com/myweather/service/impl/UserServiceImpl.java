package com.myweather.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweather.model.Role;
import com.myweather.model.User;
import com.myweather.repository.RoleRepository;
import com.myweather.repository.UserRepository;
import com.myweather.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		if (user == null) {
		throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new
		org.springframework.security.core.userdetails.User(user.getUsername(),
		user.getPassword(),
		mapRolesToAuthorities(user.getRoles()));
		}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public void save(User registerUser) {

		if (emailExist(registerUser.getUsername())) {
			throw new EntityExistsException("There is an account with that email adress: " + registerUser.getUsername());
		}
		
		User user = new User();
		user.setName(registerUser.getName());
		user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
		user.setUsername(registerUser.getUsername());
		user.setRoles(Arrays.asList(roleRepository.findByRole("ROLE_USER")));
		user.setEnabled(true);
		userRepository.save(user);
	}

	private boolean emailExist(String email) {
		User user = userRepository.findByUsername(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
