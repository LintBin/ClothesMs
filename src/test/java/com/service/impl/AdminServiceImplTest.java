package com.service.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.service.AdminService;
import com.util.admin.AdminReturn;
import com.vo.service.LoginVo;
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
		assertEquals(loginVo.getErrorWords(),AdminReturn.loginError);
	}
	
	@Test
	public void save(){
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setIntroduction("haha");
		admin.setName("bin");
		admin.setPassword("312132321313");
		admin.setUsername("hong");
		
		SuperAdmin operator = new SuperAdmin();
		operator.setId(1);
		
		String returnStr = adminServiceImpl.add(admin,operator);
		
	}
	@Test
	public void delete(){
		SuperAdmin operator = new SuperAdmin();
		operator.setId(1);
		
		String returnStr = adminServiceImpl.delete("hong",operator);
		assertEquals(returnStr,null);
	//	assertEquals(returnStr,AdminReturn.noThisUsername);
	}
	
	@Test
	public void update(){
		SuperAdmin operator = new SuperAdmin();
		operator.setId(1);
		
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setId(2);
		admin.setIntroduction("update");
		admin.setName("bin");
		admin.setPassword("000");
		admin.setUsername("hong");
		
		String str = adminServiceImpl.update(admin, operator);
		System.out.println(str);
	}
}
