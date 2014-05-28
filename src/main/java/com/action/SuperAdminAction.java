package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SuperAdminService;
import com.vo.User;


@Component("superAdmin")
@Scope("prototype")
public class SuperAdminAction extends ActionSupport{
	public User user;
	public Admin admin;
	@Resource
	private SuperAdminService superAdminService;
	

	public String login() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
		List<SuperAdmin> list = superAdminService.login(user);
		if(list.size() == 1){
			actionContext.getSession().put("LoginSuperAdmin",list.get(0));
			return "admin_login_SUCCESS";
		}else{
			actionContext.put("error", "账号或者密码错误");
			return "admin_login_ERROR";
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
