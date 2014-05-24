package com.dao;

import java.util.List;

import com.entity.Admin;

public interface AdminDAO {
	public List loadByUsernameAndPassword(String username,String password);
	public String save(Admin admin);
}

