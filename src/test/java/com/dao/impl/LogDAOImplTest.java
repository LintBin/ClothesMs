package com.dao.impl;


import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Admin;
import com.entity.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@Transactional(propagation=Propagation.REQUIRED)
@Transactional
public class LogDAOImplTest {
	@Resource
	private LogDAOImpl logDAOImpl ;
	
	@Test
	public void save(){
		
		Log log = new Log();
		Admin admin = new Admin();
		admin.setId(1);
		log.setAdmin(admin);
		/*Date date = new Date();
		date.getTime();*/
	//	log.setSaveTime(date);
		log.setLog("保存信息");
		
		logDAOImpl.save(log);
	}
}
