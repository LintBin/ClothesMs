package com.dao;

import java.util.List;

import com.entity.Admin;

public interface AdminDAO {
	public abstract List loadByUsernameAndPassword(String username,String password);
	public abstract void save(Admin admin);
	public abstract void updateFlag(Admin admin);
	public abstract void update(Admin admin);
	public abstract List loadByUsername(String name);
	public abstract List findAllByPaking(int num);
}

 