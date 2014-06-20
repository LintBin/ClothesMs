/**
 *@Copyright:Copyright (c) 2014
 */
package com.entity;

import java.util.Date;

/**实体类
 *@Auth  kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class OrderIn {
	private int orderId;
	private String docu_number;
	private WareHouse wareHouse;
	private Date in_time;
	private Admin manager;
	private String source;
	private int flag;
	
	public OrderIn(){
		this.in_time = new Date();
		in_time.getTime();
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDocu_number() {
		return docu_number;
	}
	public void setDocu_number(String docu_number) {
		this.docu_number = docu_number;
	}
	
	public Date getIn_time() {
		return in_time;
	}
	public void setIn_time(Date in_time) {
		this.in_time = in_time;
	}
	public WareHouse getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	public Admin getManager() {
		return manager;
	}
	public void setManager(Admin manager) {
		this.manager = manager;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
