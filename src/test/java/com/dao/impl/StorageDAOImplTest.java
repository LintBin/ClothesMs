/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.dao.StorageDAO;
import com.entity.Clothes;
import com.entity.Storage;
import com.entity.WareHouse;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class StorageDAOImplTest {
	@Resource
	private StorageDAO storageDAOImpl ;
	private Storage storage;
	private Clothes clothes = new Clothes();
	private WareHouse wareHouse = new WareHouse();
	@Before
	public void before(){
		storage = new Storage();
		
		clothes.setId(7);
		clothes.setColor("蓝色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1703");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		wareHouse.setId(6);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10000");
		wareHouse.setFlag(0);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		
		storage.setClothes(clothes);
		storage.setWareHouse(wareHouse);
		storage.setFlag(1);
	}
	
	
	
	@Test
	public void add(){
		storageDAOImpl.add(storage);
	}
	
	@Test
	public void updateFlag(){
		wareHouse.setId(1);
		clothes.setId(2);
		storage.setId(1);
		storage.setFlag(0);
		storageDAOImpl.updateFlag(storage);
		Storage result = storageDAOImpl.findById(1);
		assertThat(result.getFlag(),is(0));
		
	}
	@Test
	public void findByPaging(){
		List<Storage> result = storageDAOImpl.findByPaging(5, 5);
		assertThat(result.size(),is(5));
	}
	
	@Test
	public void findById(){
		Storage result = storageDAOImpl.findById(1);
		assertThat(result,notNullValue());
	}
	
	@Test
	public void update(){
		wareHouse.setId(1);
		clothes.setId(2);
		storage.setId(1);
		storage.setStorage_Number(99999);
		storageDAOImpl.update(storage);
		Storage result = storageDAOImpl.findById(1);
		assertThat(result.getStorage_Number(),is(99999));
	}
	
	
	
}
