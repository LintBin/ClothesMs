package com.dao.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.SuperAdminDAO;
import com.entity.SuperAdmin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SuperAdminDAOImplTest {
	@Resource
	private SuperAdminDAO superAdminDAOImpl;
	
	@Test
	public void findByUsernameAndPassword(){
		String username = "lin";
		String password = "lin";
		List<SuperAdmin> list = superAdminDAOImpl.findByUsernameAndPassword(username, password);
		assertThat(list.size(),is(1));
	}
}
