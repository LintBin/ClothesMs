package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.dao.WareHouseDAO;
import com.entity.Admin;
import com.entity.WareHouse;
import com.service.WareHouseService;
import com.util.wareHouse.WareHouseReturn;

@Transactional
public class WareHouseServiceImpl implements WareHouseService{
	@Resource
	private WareHouseDAO wareHouseDAOImpl;
	
	@Override
	public String save(Admin operator, WareHouse wareHouse) {
		//检查仓库是否已被注册
		List<WareHouse> list = wareHouseDAOImpl.findByDocu_number(wareHouse.getDocu_number());
		if(list.size() == 0){
			wareHouseDAOImpl.save(wareHouse);
			return null;
		}else{
			return WareHouseReturn.hasThisWareHouse;
		}
	}

	@Override
	public String delete(Admin operator, String wareHouse_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Admin operator, WareHouse wareHouse) {
		// TODO Auto-generated method stub
		return null;
	}
}
