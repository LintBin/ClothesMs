package com.util.admin;

import org.springframework.stereotype.Component;

public class AdminServiceMessage {
	public static String hasUserNameReturn = "此账号已被注册，请更换账号注册";
	public static String has_been_deleted = "此账号已被删除，若有疑问，请联系账号管理员";
	public static String loginError = "该用户不存在或者密码错误";
	public static String noThisUsername = "找不到该用户名，请检查该用户名是否填写正确";
	public static String IdConfict = "Id不一致，请检查Id";
}
