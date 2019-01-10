package com.myweather.repository;

import com.myweather.model.Role;

public interface RoleRepository {
	
	public Role findByName(String name);
	
	public void save(Role role);
}
