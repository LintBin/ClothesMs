package com.service.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.service.AdminService;
import com.util.admin.AdminReturn;
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
		admin.setUsername("hong");
		
		String returnStr = adminServiceImpl.add(admin);
		
	}
	@Test
	public void delete(){
		String returnStr = adminServiceImpl.delete("asdad");
		assertEquals(returnStr,AdminReturn.noThisUsername);
	}
	
}
