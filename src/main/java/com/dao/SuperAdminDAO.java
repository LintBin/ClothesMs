package com.dao;

import java.util.List;

import com.entity.SuperAdmin;

public interface SuperAdminDAO {
	public abstract List<SuperAdmin> findByUsernameAndPassword(String username,String password);
}
