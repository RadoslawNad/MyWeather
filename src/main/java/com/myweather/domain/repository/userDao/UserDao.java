package com.myweather.domain.repository.userDao;

import com.myweather.domain.User;

public interface UserDao {
	
	public void saveUser(User user);
	
	public User findEmail(String email);
	
	public User getUserDetailsByEmailAndPassword(String email, String password);

}
