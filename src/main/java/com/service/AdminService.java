package com.service;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.vo.LoginVo;
import com.vo.User;

public interface AdminService {
	public LoginVo login(User user);
	public String add(Admin admin , SuperAdmin operator);
	public String delete(String username,SuperAdmin operator);
	public String update(Admin admin,SuperAdmin operator);
}
