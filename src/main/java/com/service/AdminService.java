package com.service;

import com.vo.LoginVo;
import com.vo.jsp_between_action.User;

public interface AdminService {
	public LoginVo login(User user);
	public String add();
}
