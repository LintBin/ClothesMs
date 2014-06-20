/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.OrderInDAO;
import com.entity.Admin;
import com.entity.OrderIn;
import com.entity.WareHouse;
/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class OrderInDAOImplTest {
	@Resource
	private OrderInDAO orderInDAOImpl ;
	private OrderIn orderIn;
	
	@Before
	public void before(){
		orderIn = new OrderIn();
		orderIn.setDocu_number("docu2");
		orderIn.setFlag(1);
		orderIn.setSource("以纯制衣厂");
		
		Admin manager = new Admin();
		manager.setId(1);
		manager.setIntroduction("123");
		manager.setName("bin");
		manager.setPassword("123344445");
		manager.setUsername("bin");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(1);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);

		
		orderIn.setManager(manager);
		orderIn.setWareHouse(wareHouse);
		
		
	}
	
	@Test
	public void add(){
		orderInDAOImpl.add(orderIn);
	}
	
	@Test
	public void update(){
		orderIn.setOrderId(1);
		orderIn.setDocu_number("sadsdasddasd");
		orderInDAOImpl.update(orderIn);
		
	}
	
	@Test
	public void findById(){
		OrderIn result  = orderInDAOImpl.findById(1);
		assertThat(result.getDocu_number(),is("docu2"));
	}
	
	@Test
	public void updateFlag(){
		orderIn.setOrderId(1);
		orderIn.setFlag(0);
		orderInDAOImpl.updateFlag(orderIn);
		OrderIn result  = orderInDAOImpl.findById(1);
		assertThat(result.getFlag(),is(0));
	}
	
	@Test
	public void findAllByPaging(){
		List<OrderIn> result = orderInDAOImpl.findAllByPaging(0, 5);
		assertThat(result.size(),is(5));
	}
	
}
