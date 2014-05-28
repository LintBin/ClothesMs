package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.SuperAdminDAO;
import com.entity.SuperAdmin;

@Component
public class SuperAdminDAOImpl implements SuperAdminDAO {
	@Resource
	private HibernateTemplate hibernateTemplate ;

	@Override
	public List<SuperAdmin> findByUsernameAndPassword(String username,
			String password) {
		List<SuperAdmin> list = (List<SuperAdmin>) hibernateTemplate.find("from SuperAdmin as sa where username =? and password = ?", username,password);
		return list;
	}
}
