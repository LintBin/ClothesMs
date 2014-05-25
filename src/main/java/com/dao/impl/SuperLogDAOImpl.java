package com.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.SuperLogDAO;
import com.entity.SuperLog;

@Component
public class SuperLogDAOImpl implements SuperLogDAO {
	@Resource
	private HibernateTemplate hibernateTemplate ;
	
	@Override
	public void save(SuperLog superLog) {
		hibernateTemplate.save(superLog);
	}

}
