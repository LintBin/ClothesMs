package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Admin;
import com.entity.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
// @Transactional(propagation=Propagation.REQUIRED)
@Transactional
public class LogDAOImplTest {
	@Resource
	private LogDAOImpl logDAOImpl;

	@Test
	public void save() {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setUsername("username50");
		admin.setIntroduction("password50");
		admin.setName("name50");
		admin.setPassword("password50");
		admin.setFlag(1);
		
		Log log = new Log();
		log.setAdmin(admin);
		log.setLog("保存信息");

		logDAOImpl.save(log);
		
		List<Log> result = logDAOImpl.findAll();
		System.out.println(result.size());
	}
	
	@Test
	public void findAll(){
		List<Log> result = logDAOImpl.findAll();
		
	}
	
}
