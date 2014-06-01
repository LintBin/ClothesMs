package com.util;

import com.dao.LogDAO;
import com.entity.Admin;
import com.entity.Log;

public class LogSaveUtil {
	public static void save(String message,Admin operator,Object operated,LogDAO logDAOImpl){
		Log log = new Log();
		log.setAdmin(operator);
		log.setLog(message);
		logDAOImpl.save(log);
	}
}
