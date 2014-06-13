package com.dao.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.AdminDAO;
import com.entity.Admin;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class AdminDAOImplTest {
	@Resource(name = "adminDAOImpl")
	private AdminDAO adminDAOImpl;
	/**
	 * 前置条件:数据库中的t_admin表中 select * from admin where username="username1" and password="password1"返回不是空
	 */
	@Test
	public void loadByUsernameAndPassword(){
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword("username1","password1");
		assertThat(list.get(0).getName(),equalTo("name1"));
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
		admin.setUsername("username1");
		admin.setId(1);
		admin.setIntroduction("updateFlag");
		admin.setName("lll");
		admin.setPassword("binllll");
		admin.setFlag(0);
		
		adminDAOImpl.updateFlag(admin);
		List<Admin> list = adminDAOImpl.loadByUsername("username1");
		assertThat(list.get(0).getFlag(),is(0));
	}
	
	@Test
	public void findByUsername(){
		List<Admin> list = adminDAOImpl.loadByUsername("username1");
		assertThat(list.get(0).getId(),is(1));
	}
	
	@SuppressWarnings("unused")
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
	
	@Test
	public void finAllByPaging(){
		List<Admin> list = adminDAOImpl.findAllByPaging(0,10);
		assertThat(list.size(),is(10));
	}
	
	@Test
	public void getAdminById(){
		Admin admin = adminDAOImpl.getAdminById(1);
		assertThat(admin,notNullValue());
		assertThat(admin.getName(),equalTo("name1"));
	}
}
