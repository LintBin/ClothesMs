package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.dao.LogDAO;
import com.entity.Admin;
import com.entity.Log;
import com.service.AdminService;
import com.util.admin.AdminReturn;
import com.vo.LoginVo;
import com.vo.User;

@Component("adminServiceImpl")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDAOImpl")
	private AdminDAO adminDAOImpl;
	
	@Resource
	private LogDAO logDAOimpl;
	
	private Log log = new Log();
	@Override
	public LoginVo login(User user) {
		LoginVo loginVo = new LoginVo();
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword(
				user.getUsername(), user.getPassword());
		if (list.size() > 0) {
			loginVo.setFlag(true);
		} else {
			loginVo.setFlag(false);
			loginVo.setErrorWords(AdminReturn.loginError);
		}
		return loginVo;
	}

	@Override
	public String add(Admin admin,Admin operator) {
		List<Admin> list = adminDAOImpl.loadByUsername(admin.getUsername());
		if (list.size() == 0) {
			adminDAOImpl.save(admin);
		} else {
			return AdminReturn.hasUserNameReturn;
		}
		return null;
	}

	@Override
	public String delete(String username ,Admin Operator) {
		List<Admin> list = adminDAOImpl.loadByUsername(username);
		if (list.size() < 1) {
			return AdminReturn.noThisUsername;
		}else {
			Admin admin = list.get(0);
			admin.setFlag(0);
			adminDAOImpl.updateFlag(admin);
			log.setAdmin(admin);
			log.setLog(log);
			logDAOimpl.save(log);
			return null;
		}
	}

}
