package com.myweather.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
import com.myweather.model.WeatherObject;
import com.myweather.repository.HistoryDao;
import com.myweather.repository.RoleRepository;
import com.myweather.repository.UserRepository;
import com.myweather.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private HistoryDao historyDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findUser(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userRepository.findUser(username);
	}

	@Override
	@Transactional
	public boolean saveUser(User registerUser) {

		if (isUsernameExist(registerUser.getUsername())) {
//			throw new EntityExistsException(
//					"There is an account with that email adress: " + registerUser.getUsername());
			return false;
		}

		User user = new User();
		user.setName(registerUser.getName());
		user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
		user.setUsername(registerUser.getUsername());
		user.setRoles(Arrays.asList(roleRepository.findByRole("ROLE_USER")));
		user.setEnabled(true);
		userRepository.saveUser(user);
		
		return true;
	}


	@Override
	@Transactional
	public void saveHistory(String currentlyUsername, WeatherObject weatherData) {	
		historyDao.saveHistory(currentlyUsername,weatherData);	
	}

	@Override
	@Transactional
	public List<User> getAllHistory() {
		return historyDao.getAllHistory();
	}

	@Override
	@Transactional
	public List<User> getUserHistory(String currentlyUsername) {
		return historyDao.getUserHistory(currentlyUsername);
	}
	
	@Transactional
	private boolean isUsernameExist(String username) {
		User user = userRepository.findUser(username);
		if (user != null) {
			return true;
		}
		return false;
	}
}
