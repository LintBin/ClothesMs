package com.service;

import java.util.List;

import com.entity.SuperAdmin;
import com.vo.User;

public interface SuperAdminService {
	public List<SuperAdmin> login(User user);
}
