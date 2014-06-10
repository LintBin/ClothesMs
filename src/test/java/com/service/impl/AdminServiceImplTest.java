package com.service.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.service.AdminService;
import com.util.admin.AdminServiceMessage;
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
		user.setUsername("username1");
		user.setPassword("password1");
		LoginVo loginVo = adminServiceImpl.login(user);
		assertThat(loginVo.getErrorWords(),equalTo(AdminServiceMessage.loginError));
	}
	
	@Test
	public void save(){
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setIntroduction("haha");
		admin.setName("xiaolin");
		admin.setPassword("312132321313");
		admin.setUsername("xiaolin");
		
		SuperAdmin operator = new SuperAdmin();
		operator.setId(1);
		
		String returnStr = adminServiceImpl.add(admin,operator);
		assertThat(returnStr,nullValue());
	}
	@Test
	public void delete(){
		SuperAdmin operator = new SuperAdmin();
		operator.setId(1);
		
		String returnStr = adminServiceImpl.delete("hong",operator);
		assertThat(returnStr,null);
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
		admin.setUsername("username2");
		
		String str = adminServiceImpl.update(admin, operator);
		System.out.println(str);
	}
	
	@Test
	public void findAllByPaging(){
		List<Admin> list = adminServiceImpl.findAllByPaging(0, 10);
		assertThat(list.size(),is(10));
	}
}
