package com.entity;

import java.util.Date;

/**实体类
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class SuperLog {
	private int Id;
	private String log;
	private Date saveTime;
	private SuperAdmin superAdmin;
	
	public SuperLog(){
		this.saveTime = new Date();
		this.saveTime.getTime();
	}

	public SuperAdmin getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(SuperAdmin superAdmin) {
		this.superAdmin = superAdmin;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
}
