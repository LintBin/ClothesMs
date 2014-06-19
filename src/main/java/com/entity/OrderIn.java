/**
 *@Copyright:Copyright (c) 2014
 */
package com.entity;

import java.sql.Date;

/**实体类
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class OrderIn {
	private int orderId;
	private String docu_number;
	private int warehouseId;
	private Date in_time;
	private int managerId;
	private String source;
	private int flag;
	
	
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
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Date getIn_time() {
		return in_time;
	}
	public void setIn_time(Date in_time) {
		this.in_time = in_time;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
