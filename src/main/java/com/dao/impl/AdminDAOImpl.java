package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;

@Component("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List loadByUsernameAndPassword(String username,String password){
		List<Admin> list = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username=? and a.password =?",username,password);
		return list;
	}

	@Override
	public String save(Admin admin) {
		hibernateTemplate.save(admin);
		return null;
	}
	
	@Override
	public String delete(int adminId){

		return null;
	}

	@Override
	public List loadByUsername(String username) {
		List<Admin> list = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username = ?", username );
		return list;
	}
	
	
	
	
}
