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
import com.util.wareHouse.WareHouseServiceMessage;


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
			
			 //添加Log记录
			 log.setAdmin(operator);
			 log.setLog(WareHouseLogMessage.save_WareHouse_SUCCESS);
			 logDAOImpl.save(log);
			
			return null;
		}else{
			return WareHouseServiceMessage.hasThisWareHouse;
		}
	}

	@Override
	public String delete(Admin operator, String wareHouse_number) {
		//检查仓库是否已经存在
		List<WareHouse> result = wareHouseDAOImpl.findByDocu_number(wareHouse_number);
		
		if(result.size() == 1){
			 WareHouse deleted = result.get(0);
			 if(deleted.getFlag() ==1){
				 wareHouseDAOImpl.updateFlag(result.get(0));
				 
				 //添加Log记录
				 log.setAdmin(operator);
				 log.setLog(WareHouseLogMessage.delete_WareHouse_SUCCESS);
				 logDAOImpl.save(log);
				 return null;
			 }else{
				 return WareHouseServiceMessage.has_been_deleted;
			 }
			
		}else{
			return WareHouseServiceMessage.no_this_WareHouse;
		}
		
	}

	@Override
	public String update(Admin operator, WareHouse wareHouse) {
		//检查仓库是否已经存在
		List<WareHouse> result = wareHouseDAOImpl.findByDocu_number(wareHouse.getDocu_number());
		WareHouse was_found = result.get(0);
		if(result.size() == 1){
			//检查Id是否会冲突
			if(result.get(0).getId() == wareHouse.getId()){
				
				was_found.setContact(wareHouse.getContact());
				was_found.setContact_phone(wareHouse.getContact_phone());
				was_found.setFlag(wareHouse.getFlag());
				was_found.setName(wareHouse.getName());
				was_found.setTotal_storage(wareHouse.getTotal_storage());
				
				wareHouseDAOImpl.update(was_found);
				
				 //添加Log记录
				log.setAdmin(operator);
				log.setLog(WareHouseLogMessage.update_WareHouse_SUCCESS);
				logDAOImpl.save(log);
				
				return null;
			}else{
				return WareHouseServiceMessage.id_confict;
			}
		}else{
			return WareHouseServiceMessage.no_this_WareHouse;
		}
	}


	@Override
	public WareHouse findWareHouseByDocuNum(String docuNum) {
		List<WareHouse> result = wareHouseDAOImpl.findByDocu_number(docuNum);
		
		if(result.size()==1){
			return result.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<WareHouse> findAllByPaging(int firstIndex,int size) {
		List<WareHouse> result = wareHouseDAOImpl.findAllByPaging(firstIndex, size);
		return result;
	}
}
