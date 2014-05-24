package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.service.AdminService;
import com.vo.LoginVo;
import com.vo.User;


@Component("adminServiceImpl")
@Transactional
public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAOImpl;

	public AdminDAO getAdminDAOImpl() {
		return adminDAOImpl;
	}
	@Resource(name="adminDAOImpl")
	public void setAdminDAOImpl(AdminDAO adminDAOImpl) {
		this.adminDAOImpl = adminDAOImpl;
	}
	
	@Override
	public LoginVo login(User user){
		LoginVo loginVo = new LoginVo();
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(list.size()>0){
			loginVo.setFlag(true);
		}else{
			loginVo.setFlag(false);
			loginVo.setErrorWords("该用户不存在或者密码错误");
		}
		return loginVo;
	}
	@Override
	public String add(Admin admin){
		
		adminDAOImpl.save(admin);
		
		return null;
	}
	
}
