package com.myweather.repository;

import com.myweather.model.Privilege;

public interface PrivilegeRepository {
	
	public Privilege findByName(String name);
	
	public void save(Privilege privilege);

}
