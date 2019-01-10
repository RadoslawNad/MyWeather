package com.myweather.service.impl;

import java.util.Arrays;
import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myweather.domain.User;
import com.myweather.domain.repository.RoleRepository;
import com.myweather.domain.repository.userDao.UserRepository;
import com.myweather.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void registerNewUserAccount(User registerUser) throws EntityExistsException {

		if (emailExist(registerUser.getEmail())) {
			throw new EntityExistsException("There is an account with that email adress: " + registerUser.getEmail());
		}

		User user = new User();
		user.setName(registerUser.getName());
		user.setPassword(registerUser.getPassword());
		user.setEmail(registerUser.getEmail());
		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
		userRepository.save(user);
	}

	private boolean emailExist(String email) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
