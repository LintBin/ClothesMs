package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.dao.LogDAO;
import com.dao.SuperLogDAO;
import com.entity.Admin;
import com.entity.Log;
import com.entity.SuperAdmin;
import com.entity.SuperLog;
import com.service.AdminService;
import com.util.admin.AdminLogMessage;
import com.util.admin.AdminReturn;
import com.vo.service.LoginVo;
import com.vo.User;

@Component("adminServiceImpl")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDAOImpl")
	private AdminDAO adminDAOImpl;
	
	@Resource
	private SuperLogDAO superLogDAOImpl;
	
	private SuperLog superLog = new SuperLog();
	
	//登陆操作
	@Override
	public LoginVo login(User user) {
		LoginVo loginVo = new LoginVo();
		List<Admin> list = adminDAOImpl.loadByUsernameAndPassword(
				user.getUsername(), user.getPassword());
		//检查查询到的list里面是否有Admin
		if (list.size() > 0 ) {
			//Admin中的flag是否为1,为1则返回要查询的Admin,否则返回错误信息
			if(list.get(0).getFlag() == 1){
				loginVo.setAdmin(list.get(0));
			}else{
				loginVo.setErrorWords(AdminReturn.has_been_deleted);
			}
		} else {
			//list没有对象，不能登陆，返回错误信息的
			loginVo.setErrorWords(AdminReturn.loginError);
		}
		return loginVo;
	}
	
	//添加管理员
	@Override
	public String add(Admin admin,SuperAdmin operator) {
		//检查是否存在这个Admin
		List<Admin> list = adminDAOImpl.loadByUsername(admin.getUsername());
		if (list.size() == 0) {
			//添加Admin
			adminDAOImpl.save(admin);
			
			//添加Log
			superLog.setSuperAdmin(operator);
			superLog.setLog(AdminLogMessage.saveAdmin_SUCCESS + admin.getUsername());
			superLogDAOImpl.save(superLog);
		} else {
			return AdminReturn.hasUserNameReturn;
		}
		return null;
	}

	//删除管理员
	@Override
	public String delete(String username ,SuperAdmin Operator) {
		//检测是否存在这个Admin
		List<Admin> list = adminDAOImpl.loadByUsername(username);
		if (list.size() < 1) {
			return AdminReturn.noThisUsername;
		}else {
			//删除dmin
			Admin admin = list.get(0);
			admin.setFlag(0);
			adminDAOImpl.updateFlag(admin);
			
			//添加Log
			superLog.setSuperAdmin(Operator);
			superLog.setLog(AdminLogMessage.deleteAmin_SUCCESS + admin.getUsername());
			superLogDAOImpl.save(superLog);
			return null;
		}
	}

	//修改管理员信息
	@Override
	public String update(Admin admin, SuperAdmin operator) {
		//检测是否存在这个Admin
		List<Admin> list = adminDAOImpl.loadByUsername(admin.getUsername());
		if (list.size() >0 ) {
			Admin was_found = list.get(0);
			//进行Id检查是否一致,若一致，则进行修改
			if(admin.getId() == was_found.getId()){
				//更新Admin
				was_found.setIntroduction(admin.getIntroduction());
				was_found.setFlag(admin.getFlag());
				was_found.setName(admin.getName());
				was_found.setPassword(admin.getPassword());
				adminDAOImpl.update(was_found);
				
				//添加Log记录
				SuperLog superLog = new SuperLog();
				superLog.setSuperAdmin(operator);
				superLog.setLog(AdminLogMessage.updateAdmin_SUCCESS + admin.getUsername());
				superLogDAOImpl.save(superLog);
				return null;
			}else{
				return AdminReturn.IdConfict;
			}
		}else {
			return AdminReturn.noThisUsername;
		}
		
	}

}
