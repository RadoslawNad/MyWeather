package com.myweather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweather.domain.User;
import com.myweather.domain.repository.userDao.UserDao;
import com.myweather.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public boolean saveUser(User user) {
		if (emailExist(user.getEmail())) {
			return true;
		}
		userDao.saveUser(user);
		return false;
	}

	private boolean emailExist(String email) {
		User user = userDao.findEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public User validateUserCredential(String email, String password) {
		return userDao.getUserDetailsByEmailAndPassword(email, password);
	}

}
