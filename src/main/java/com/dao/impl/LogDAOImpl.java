package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import com.dao.LogDAO;
import com.entity.Log;

@Component("logDAOImpl")
public class LogDAOImpl implements LogDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Log log) {
		hibernateTemplate.save(log);
	}

	@Override
	public List<Log> findAll() {
		List<Log> result = (List<Log>) hibernateTemplate.find("from Log ");
		return result;
	}
}
