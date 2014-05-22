package com.service.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.impl.AdminServiceImpl;
import com.vo.LoginVo;
import com.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AdminServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{
	private AdminServiceImpl adminServiceImpl;

	public AdminServiceImpl getAdminServiceImpl() {
		return adminServiceImpl;
	}

	@Resource(name = "adminServiceImpl")
	public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	@Test
	public void login(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("124");
		LoginVo loginVo = adminServiceImpl.login(user);
		assertEquals(loginVo.isFlag(),false);
		
	}
}
