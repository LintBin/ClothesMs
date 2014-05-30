package com.util;

import com.dao.LogDAO;
import com.entity.Admin;
import com.entity.Log;

public class LogSaveUtil {
	public static void save(String message,Admin Operator,Object operated,LogDAO logDAOImpl){
		Log log = new Log();
		logDAOImpl.save(log);
	}
}
