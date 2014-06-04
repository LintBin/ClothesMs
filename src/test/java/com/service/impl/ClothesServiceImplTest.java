package com.service.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.Clothes;
import com.service.ClothesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ClothesServiceImplTest {
	@Resource
	private ClothesService clothesServiceImpl;
	/*private Admin admin ;
	private Clothes clothes;*/
	
	
	@Test
	public void save(){
		Admin admin = new Admin();
		Clothes clothes = new Clothes();
		admin.setFlag(1);
		admin.setId(1);
		admin.setIntroduction("introduce1");
		admin.setName("name1");
		admin.setPassword("password1");
		admin.setUsername("username1");
		
		clothes.setColor("红色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1703");
		clothes.setEx_factory_price(500);
		clothes.setFlag(1);
		clothes.setIn_material("尼龙");
		clothes.setOperator(admin);
		clothes.setOut_material("布");
		clothes.setRetail_price(1000);
		clothes.setSize(200);
		
		String result = clothesServiceImpl.save(clothes,admin);
		assertThat(result,nullValue());
	}
	
	@Test
	public void update(){
		/*clothes.setColor("黑色");
		clothes.setOut_material("丝绸");
		try{
			String result = clothesServiceImpl.update(clothes,admin);
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	@Test
	public void findAllByPaging(){
		List<Clothes> result = clothesServiceImpl.findAllByPaging(0, 10);
		assertThat(result.size(),is(10));
	}
}
