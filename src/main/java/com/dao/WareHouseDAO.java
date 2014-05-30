package com.dao;

import java.util.List;

import com.entity.WareHouse;

public interface WareHouseDAO {
	public abstract void save(WareHouse wareHouse);
	public abstract List findByDocu_number(String docu_number);
	public abstract void updateFlag(WareHouse warreHouse);
	public abstract void update(WareHouse wareHouse);
	public abstract List<WareHouse> findAllByPaging(int firstIndex,int size);
}
