package com.service;

import java.util.List;

import com.entity.Admin;
import com.entity.Clothes;

public interface ClothesService {
	public String save(Clothes clothes,Admin operator);
	public String update(Clothes clothes,Admin operator);
	public String delete(Clothes clothes ,Admin operator);
	public List<Clothes> findAllByPaging(int firstIndex,int size);
	public Clothes findClothesByDocuNum(String docuNum);
}
