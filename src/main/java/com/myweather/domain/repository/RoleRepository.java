package com.myweather.domain.repository;

import com.myweather.domain.Role;

public interface RoleRepository {
	
	public Role findByName(String name);
	
	public void save(Role role);
}
