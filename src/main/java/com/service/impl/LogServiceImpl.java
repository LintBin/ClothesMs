package com.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.impl.LogDAOImpl;
import com.entity.Log;
import com.service.LogService;

@Component
@Transactional
public class LogServiceImpl implements LogService{
	
	@Resource
	private LogDAOImpl logDAoImpl ;
	
	@Override
	public String add(Log log) {
		logDAoImpl.save(log);
		return null;
	}
	
}
