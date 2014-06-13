package com.vo.service;

import com.entity.Admin;

public class LoginVo {
	//从漫画数据库取出的管理员实体
	private Admin admin;
	//取出时遇到的错误信息，如果没有则为空
	private String errorWords;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getErrorWords() {
		return errorWords;
	}

	public void setErrorWords(String errorWords) {
		this.errorWords = errorWords;
	}

}
