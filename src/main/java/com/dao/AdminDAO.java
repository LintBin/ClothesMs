package com.dao;

import java.util.List;

import com.entity.Admin;

public interface AdminDAO {
	public List loadByUsernameAndPassword(String username,String password);
	public void save(Admin admin);
	public void updateFlag(Admin admin);
	public void update(Admin admin);
	public List loadByUsername(String name);
}

 