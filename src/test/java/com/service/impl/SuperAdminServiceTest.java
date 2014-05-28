package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.SuperAdmin;
import com.service.SuperAdminService;
import com.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SuperAdminServiceTest {
	@Resource
	private SuperAdminService superAdminServiceImpl;

	@Test
	public void login() {
		User user = new User();
		
		String username = "superAdmin";
		String password = "123";
		user.setUsername(username);
		user.setPassword(password);
		
		List<SuperAdmin> list = superAdminServiceImpl.login(user);
		assertEquals(list.size(),1);
	}
}
