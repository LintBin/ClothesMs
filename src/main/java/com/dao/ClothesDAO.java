package com.dao;

import java.util.List;

import com.entity.Clothes;

public interface ClothesDAO {
	public abstract List<Clothes> findClothesByDocuNum(String docuNum);
	public abstract void save(Clothes clothes);
	public abstract void update(Clothes clothes);
	public abstract void updateFlag(Clothes clothes);
	public abstract List<Clothes> findAllByPaging(int firstIndex,int size);
}
