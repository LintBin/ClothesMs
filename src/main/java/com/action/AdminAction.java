package com.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.vo.jsp_between_action.User;


@Component("admin")
@Scope("prototype")
public class AdminAction extends ActionSupport{
	public User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(">>>>>>" + user.getUsername());
		System.out.println(">>>>>>" + user.getPassword());
		System.out.println("Action is running");
		return null;
	}
	
	public String login() throws Exception{
		System.out.println("login method is running ");
		System.out.println(">>>>>>" + user.getUsername());
		System.out.println(">>>>>>" + user.getPassword());
		System.out.println("Action is running");
		return null;
	}
	
}
