package com.service;

import com.vo.LoginVo;
import com.vo.User;

public interface AdminService {
	public LoginVo login(User user);
	public String add();
}
