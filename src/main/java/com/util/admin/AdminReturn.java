package com.util.admin;

import org.springframework.stereotype.Component;

public class AdminReturn {
	public static String hasUserNameReturn = "此账号已被注册，请更换账号注册";
	public static String loginError = "该用户不存在或者密码错误";
	public static String noThisUsername = "找不到该用户名，请检查该用户名是否填写正确";
}
