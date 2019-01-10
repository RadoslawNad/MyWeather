package com.myweather.domain.repository;

import com.myweather.domain.Privilege;

public interface PrivilegeRepository {
	
	public Privilege findByName(String name);
	
	public void save(Privilege privilege);

}
