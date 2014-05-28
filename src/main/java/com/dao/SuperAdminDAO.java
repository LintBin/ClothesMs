package com.dao;

import java.util.List;

import com.entity.SuperAdmin;

public interface SuperAdminDAO {
	public List<SuperAdmin> findByUsernameAndPassword(String username,String password);
}
