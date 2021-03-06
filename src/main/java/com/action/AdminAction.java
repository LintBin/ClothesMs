package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;
import com.vo.User;
import com.vo.service.LoginVo;


@Component("admin")
@Scope("prototype")
public class AdminAction extends ActionSupport{
	public User user;
	public Admin admin;
	@Resource
	private AdminService adminService;
	

	public String login() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
		LoginVo loginVo = adminService.login(user);
		if(loginVo.getErrorWords() == null){
			actionContext.getSession().put("LoginAdmin",loginVo.getAdmin());
			return "admin_login_SUCCESS";
		}else{
			actionContext.put("error", loginVo.getErrorWords());
			return "admin_login_ERROR";
		}
	}
	
	public String add(){
		
		
		return null;
	}
	
	
	
	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
