package com.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.entity.SuperAdmin;
import com.entity.SuperLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@Transactional(propagation=Propagation.REQUIRED)
@Transactional
public class SuperLogDAOImplTest {
	@Resource
	private SuperLogDAOImpl superLogDAOImpl;
	
	@Test
	public void save(){
		//新建SuperLog
		SuperLog superLog = new SuperLog();
		superLog.setLog("has save");
		
		//新建SuperAdmin(SuperLog中需要用到)
		SuperAdmin superAdmin = new SuperAdmin();
		superAdmin.setId(1);
		superLog.setSuperAdmin(superAdmin);
		
		superLogDAOImpl.save(superLog);
	}
}
