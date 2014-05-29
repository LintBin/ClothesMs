package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.LogDAO;
import com.dao.WareHouseDAO;
import com.entity.Admin;
import com.entity.Log;
import com.entity.WareHouse;
import com.service.WareHouseService;
import com.util.wareHouse.WareHouseLogMessage;
import com.util.wareHouse.WareHouseReturn;


@SuppressWarnings("unchecked")
@Component
@Transactional
public class WareHouseServiceImpl implements WareHouseService{
	@Resource
	private WareHouseDAO wareHouseDAOImpl;
	@Resource
	private LogDAO logDAOImpl;
	private Log log = new Log();
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
		//检查仓库是否已经存在
		List<WareHouse> list = wareHouseDAOImpl.findByDocu_number(wareHouse_number);
		
		if(list.size()==1){
			 wareHouseDAOImpl.updateFlag(list.get(0));
			 
			 //添加Log类
			 log.setAdmin(operator);
			 log.setLog(WareHouseLogMessage.delete_WareHouse_SUCCESS);
			 logDAOImpl.save(log);
			 return null;
		}else{
			return WareHouseReturn.no_this_WareHouse;
		}
		
	}

	@Override
	public String update(Admin operator, WareHouse wareHouse) {
		//检查仓库是否已经存在
		List<WareHouse> list = wareHouseDAOImpl.findByDocu_number(wareHouse.getDocu_number());
		
		if(list.size() == 1){
			//检查Id是否会冲突
			if(list.get(0).getId() == wareHouse.getId()){
				wareHouseDAOImpl.update(wareHouse);
				return null;
			}else{
				return WareHouseReturn.id_confict;
			}
		}else{
			return WareHouseReturn.no_this_WareHouse;
		}
	}


	@Override
	public WareHouse findWareHouseByDocuNum(String docuNum) {
		List<WareHouse> list = wareHouseDAOImpl.findByDocu_number(docuNum);
		
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}
}
