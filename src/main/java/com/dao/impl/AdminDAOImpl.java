package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;

@Component("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	private HibernateTemplate hibernateTemplate;
	
	
	public List loadByUsernameAndPassword(String username,String password){
		
		List<Admin> list = (List<Admin>) hibernateTemplate.find("from Admin a where a.username=" + username +" and a.password=" + password);
		
		return list;
	}
	
	
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	
}
