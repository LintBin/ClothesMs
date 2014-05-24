package com.service;

import com.entity.Admin;
import com.vo.LoginVo;
import com.vo.User;

public interface AdminService {
	public LoginVo login(User user);
	public String add(Admin admin);
}
