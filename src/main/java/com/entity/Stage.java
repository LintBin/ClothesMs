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
public class Stage {
	private int id;
	private WareHouse wareHouse;
	private Clothes clothes;
	private int stageNum;

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

	public int getStageNum() {
		return stageNum;
	}

	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}

}
