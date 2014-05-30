package com.service;

import java.util.List;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.vo.User;
import com.vo.service.LoginVo;

public interface AdminService {
	public LoginVo login(User user);
	public String add(Admin admin , SuperAdmin operator);
	public String delete(String username,SuperAdmin operator);
	public String update(Admin admin,SuperAdmin operator);
	public List<Admin> findAllByPaging(int firstIndex,int size);
}
