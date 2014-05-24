package com.service.impl;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.service.AdminService;
import com.vo.LoginVo;
import com.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AdminServiceImplTest {
	@Resource(name = "adminServiceImpl")
	private AdminService adminServiceImpl;

	@Test
	public void login() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("124");
		
		LoginVo loginVo = adminServiceImpl.login(user);
		assertEquals(loginVo.isFlag(), false);

	}
	
	@Test
	public void save(){
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setIntroduction("haha");
		admin.setName("bin");
		admin.setPassword("312132321313");
		admin.setUsername("bin");
		adminServiceImpl.add(admin);
	}

}
