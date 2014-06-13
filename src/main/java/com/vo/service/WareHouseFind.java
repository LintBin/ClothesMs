package com.vo.service;

import com.entity.WareHouse;

public class WareHouseFind {
	//从数据库中取出仓库实体时的错误信息，如果没有则为空
	private String error;
	//从数据库中取出的仓库实体，如果没有则为空
	private WareHouse wareHouse;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}

}
