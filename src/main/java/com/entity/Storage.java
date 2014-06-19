/**
 *@Copyright:Copyright (c) 2014
 */
package com.entity;

/**
 * 实体辅助类
 * 
 * @Author kklt21cn
 * @Since 2014年6月13日
 * @Version 1.0
 */
public class Storage {
	private int id;
	private WareHouse wareHouse;
	private Clothes clothes;
	private int storage_Number;
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public int getStorage_Number() {
		return storage_Number;
	}

	public void setStorage_Number(int storage_Number) {
		this.storage_Number = storage_Number;
	}

	

}
