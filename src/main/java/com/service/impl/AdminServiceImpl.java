package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.service.AdminService;
import com.util.AdminReturn;
import com.vo.LoginVo;
import com.vo.User;


@Component("adminServiceImpl")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Resource(name="adminDAOImpl")
	private AdminDAO adminDAOImpl;
	
	
	@Override
	public LoginVo login(User user){
		LoginVo loginVo = new LoginVo();
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(list.size()>0){
			loginVo.setFlag(true);
		}else{
			loginVo.setFlag(false);
			loginVo.setErrorWords(AdminReturn.loginError);
		}
		return loginVo;
	}
	
	@Override
	public String add(Admin admin){
		List<Admin> list = adminDAOImpl.loadByUsername(admin.getUsername());
		if(list.size() == 0){
			adminDAOImpl.save(admin);
		}else{
			return AdminReturn.hasUserNameReturn;
		}
		return null;
	}
	
	@Override
	public String delete(String username) {
		List<Admin> list = adminDAOImpl.loadByUsername(username);
		if(list.size()<1){
			return AdminReturn.noThisUsername; 
		}else{
			adminDAOImpl.delete(list.get(0).getId());
			return null;
		}
	}
	
}
