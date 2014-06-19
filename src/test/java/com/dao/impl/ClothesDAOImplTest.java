package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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
		clothes.setDocuNum("docu1");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		clothes.setColor("深蓝色");
		
		Admin admin = new Admin();
		admin.setId(1);
		admin.setUsername("username1");
		admin.setIntroduction("password1");
		admin.setName("name1");
		admin.setPassword("password1");
		admin.setFlag(1);
		
		clothes.setOperator(admin);
		clothesDAOImpl.update(clothes);
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("BR1703");
		
	}
	
	@Test
	public void findClothesByDocuNum(){
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("docu1");
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void findClothesPaging(){
		List<Clothes> result = clothesDAOImpl.findAllByPaging(0, 10);
		System.out.println(result.size());
	}
	
	@Test
	public void updataFlag(){
		Clothes clothes = new Clothes();
		clothes.setId(1);
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("docu1");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		clothes.setColor("深蓝色");
		
		Admin admin = new Admin();
		admin.setId(1);
		admin.setUsername("username1");
		admin.setIntroduction("password1");
		admin.setName("name1");
		admin.setPassword("password1");
		admin.setFlag(1);
		
		clothes.setOperator(admin);
		clothesDAOImpl.updateFlag(clothes);
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("docu1");
		assertThat(result.get(0).getFlag(),is(100));
	}
}
