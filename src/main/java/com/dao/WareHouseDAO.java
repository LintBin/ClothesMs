package com.dao;

import java.util.List;

import com.entity.WareHouse;

public interface WareHouseDAO {
	public void save(WareHouse wareHouse);
	public List findByDocu_number(String docu_number);
	public void updateFlag(WareHouse warreHouse);
	public void update(WareHouse wareHouse);
}
