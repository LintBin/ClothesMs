package com.dao.impl;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.LogDAO;

@Component("loginDAOImpl")
public class LogDAOimpl implements LogDAO {
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save() {
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
