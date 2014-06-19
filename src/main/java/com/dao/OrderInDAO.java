/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.OrderIn;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public interface OrderInDAO {
	public void add(OrderIn orderIn);
	public void updateFlag(OrderIn orderIn);
	public void update(OrderIn orderIn);
	public OrderIn findById(int id);
	public List<OrderIn> findAllByPaging(int firstIndex,int size);
	
}
