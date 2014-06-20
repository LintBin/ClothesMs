/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import java.util.List;

import com.entity.OrderIn;

/**
 *@Author kklt21cn
 *@Since 2014年6月20日
 *@Version 1.0
 */
public interface OrderInService {
	public String save(OrderIn orderIn);
	public String update(OrderIn orderIn);
	public String delete(OrderIn orderIn);
	public OrderIn findById(OrderIn orderIn);
	public List<OrderIn> findAllByPaging(int first,int size);
}
