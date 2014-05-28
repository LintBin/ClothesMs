package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.SuperAdminDAO;
import com.entity.SuperAdmin;
import com.service.SuperAdminService;
import com.vo.User;

@Component
public class SuperAdminServiceImpl implements SuperAdminService {
	@Resource
	private SuperAdminDAO superAdminDAOImpl;
	
	@Override
	public List<SuperAdmin> login(User user) {
		List<SuperAdmin> list = superAdminDAOImpl.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return list;
	}


	
	


}
