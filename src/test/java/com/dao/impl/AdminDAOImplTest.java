package com.dao.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.AdminDAO;
import com.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class AdminDAOImplTest {
	@Resource(name = "adminDAOImpl")
	private AdminDAO adminDAOImpl;

	@Test
	public void loadByUsernameAndPassword(){
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword("admin","123");
		assertEquals(list.get(0).getName(),"lin");
	}
	
	@Test
	public void save(){
		Admin admin = new Admin();
		admin.setIntroduction("123");
		admin.setName("bin");
		admin.setPassword("123344445");
		admin.setUsername("bin");
		adminDAOImpl.save(admin);
	}
	
	@Test
	public void updateFlag(){
		
		Admin admin = new Admin();
		admin.setUsername("hong");
		admin.setId(2);
		admin.setIntroduction("updateFlag");
		admin.setName("lll");
		admin.setPassword("binllll");

		adminDAOImpl.updateFlag(admin);
		List<Admin> list = adminDAOImpl.loadByUsername("hong");
		assertEquals(list.get(0).getFlag(),0);
	}
	
	@Test
	public void findByUsername(){
		List<Admin> list = adminDAOImpl.loadByUsername("admin");
		assertEquals(list.get(0).getId(),1);
	}
	
	@Test 
	public void update(){
		//Admin创建
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setId(2);
		admin.setIntroduction("00000000000");
		admin.setName("bin");
		admin.setPassword("123");
		admin.setUsername("admin");
		
		adminDAOImpl.update(admin);
		List<Admin> list = adminDAOImpl.loadByUsername("admin");
	}
}
