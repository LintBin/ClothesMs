package com.vo.service;

import com.entity.Admin;

public class LoginVo {
	private Admin admin;
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
