package com.service;

import com.entity.Admin;
import com.entity.WareHouse;

public interface WareHouseService {
	public String save(Admin operator,WareHouse wareHouse);
	public String delete(Admin operator,String wareHouse_number);
	public String update(Admin operator,WareHouse wareHouse);
	public WareHouse findWareHouseByDocuNum(String docuNum);
}
