package com.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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

		Log log = new Log();
		Admin admin = new Admin();
		admin.setId(1);
		log.setAdmin(admin);
		log.setLog("保存信息");

		logDAOImpl.save(log);
	}
}
