package com.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.WareHouse;
import com.service.WareHouseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class WareHouseServiceImplTest {
	@Resource
	private WareHouseService wareHouseServiceImpl;
	
	@Test
	public void save(){
		Admin operator = new Admin();
		operator.setFlag(1);
		operator.setId(1);
		operator.setIntroduction("asd");
		operator.setName("bin");
		operator.setPassword("123");
		operator.setUsername("admin");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		
		wareHouseServiceImpl.save(operator, wareHouse);
	}
	

	@Test
	public void update(){
		Admin operator = new Admin();
		operator.setFlag(1);
		operator.setId(1);
		operator.setIntroduction("asd");
		operator.setName("bin");
		operator.setPassword("123");
		operator.setUsername("admin");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(2);
		wareHouse.setContact("张三");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		
		String result = wareHouseServiceImpl.update(operator, wareHouse);
		System.out.println(result);
	}
	

	@Test
	public void delete(){
		Admin operator = new Admin();
		operator.setFlag(1);
		operator.setId(1);
		operator.setIntroduction("asd");
		operator.setName("bin");
		operator.setPassword("123");
		operator.setUsername("admin");
		
		wareHouseServiceImpl.delete(operator, "do1");
	}
	
	@Test
	public void findAllByPaging(){
		List<WareHouse> result = wareHouseServiceImpl.findAllByPaging(0, 10);
		assertEquals(result.size(),10);
	}
}
