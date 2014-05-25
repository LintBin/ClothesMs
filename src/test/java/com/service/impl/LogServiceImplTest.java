package com.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.Log;
import com.service.LogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LogServiceImplTest {
	@Resource
	private LogService logServiceImpl;
	
	@Test
	public void add(){
		Log log = new Log();
		Admin admin = new Admin();
		admin.setId(1);
		/*admin.setFlag(1);
		admin.setIntroduction("haha");
		admin.setName("bin");
		admin.setPassword("312132321313");
		admin.setUsername("bin");*/
		log.setAdmin(admin);
		Date date = new Date();
		date.getTime();
		log.setId(13);
		log.setSaveTime(date);
		log.setLog("保存信息");
		logServiceImpl.add(log);
		
	}
}
