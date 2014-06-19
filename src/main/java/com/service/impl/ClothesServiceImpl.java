package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.dao.ClothesDAO;
import com.dao.LogDAO;
import com.entity.Admin;
import com.entity.Clothes;
import com.entity.Log;
import com.service.ClothesService;
import com.util.clothes.ClothesLogMessage;
import com.util.clothes.ClothesServiceMessage;

@SuppressWarnings("unchecked")
@Component
@Transactional
public class ClothesServiceImpl implements ClothesService {
	@Resource
	private ClothesDAO clothesDAOImpl;
	
	@Resource
	private AdminDAO adminDAOImpl;
	
	@Resource
	private LogDAO logDAOImpl;
	private Log log = new Log();
	
	@Override
	public String save(Clothes clothes, Admin operator) {
		//检查是否有这个货号
		List<Clothes> result = null ;
		try{
			result = (List<Clothes>) clothesDAOImpl.findClothesByDocuNum(clothes.getDocuNum());
		}catch(Exception e){
			System.out.println("<----------->");
			e.printStackTrace();
		}
		if(result.size()== 0){
			//货号中的管理员是否有这个权限
			Admin adminResult = adminDAOImpl.getAdminById(operator.getId());
			if(adminResult != null && adminResult.getFlag() != 0){
				clothesDAOImpl.save(clothes);
				log.setAdmin(operator);
				log.setLog(ClothesLogMessage.save_Clothes_SUCCESS+clothes.getDocuNum());
				logDAOImpl.save(log);
				return null;
			}else{
				return ClothesServiceMessage.no_this_Admin;
			}
		}else{
			return ClothesServiceMessage.has_this_clothes;
		}
	}
	
	@Override
	public String update(Clothes clothes, Admin operator) {
		List<Clothes> result = (List<Clothes>) clothesDAOImpl.findClothesByDocuNum(clothes.getDocuNum()); 
		if(result.size()==1){
			
			clothesDAOImpl.update(clothes);
			
			//添加日志记录
			log.setAdmin(operator);
			log.setLog(ClothesLogMessage.update_Clothes_SUCCESS+clothes.getDocuNum());
			logDAOImpl.save(log);
			return null;
		}else{
			return ClothesServiceMessage.no_this_clothes;
		}
	}
	
	@Override
	public String delete(Clothes clothes, Admin operator) {
		List<Clothes> result = (List<Clothes>) clothesDAOImpl.findClothesByDocuNum(clothes.getDocuNum()); 
		if(result.size()==1){
			if(result.get(0).getFlag() ==0){
				return ClothesServiceMessage.had_been_delete;
			}else{
				clothesDAOImpl.updateFlag(clothes);
				
				//添加日志
				log.setAdmin(operator);
				log.setLog(ClothesLogMessage.delete_Clothes_SUCCESS + clothes.getDocuNum());
				logDAOImpl.save(log);
			}
		}else{
			return ClothesServiceMessage.no_this_clothes;
		}
		return null;
	}
	
	@Override
	public List<Clothes> findAllByPaging(int firstIndex,int size) {
		List<Clothes> result = clothesDAOImpl.findAllByPaging(firstIndex, size);
		return result;
	}
	
	@Override
	public Clothes findClothesByDocuNum(String docuNum) {
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum(docuNum);
		if(result.size()==1){
			return result.get(0);
		}else{
			return null;
		}
	}
}

