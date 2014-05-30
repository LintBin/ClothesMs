package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ClothesDAO;
import com.entity.Admin;
import com.entity.Clothes;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class ClothesDAOImplTest {
	@Resource
	private ClothesDAO clothesDAOImpl;
	
	@Test
	public void save(){
		Clothes clothes = new Clothes();
		clothes.setColor("蓝色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1703");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		Admin admin = new Admin();
		admin.setFlag(1);
		admin.setId(1);
		admin.setIntroduction("ja");
		admin.setName("lin");
		admin.setPassword("1212");
		admin.setUsername("asd");
		
		clothes.setOperator(admin);
		clothesDAOImpl.save(clothes);
	}
	
	@Test
	public void update(){
		Clothes clothes = new Clothes();
		clothes.setId(1);
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1001");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		clothes.setColor("深蓝色");
		clothesDAOImpl.update(clothes);
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("BR1703");
	}
}
