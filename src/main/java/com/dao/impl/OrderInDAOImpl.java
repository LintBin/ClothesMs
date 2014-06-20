/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.OrderInDAO;
import com.entity.Admin;
import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.Storage;
import com.util.PageNoUtil;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
@Component
@SuppressWarnings("unchecked")
public class OrderInDAOImpl implements OrderInDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(OrderIn orderIn) {
		hibernateTemplate.save(orderIn);
	}

	
	@Override
	public void updateFlag(OrderIn orderIn) {
		hibernateTemplate.update(orderIn);
	}

	
	@Override
	public void update(OrderIn orderIn) {
		hibernateTemplate.update(orderIn);
	}

	
	@Override
	public OrderIn findById(int id) {
		OrderIn orderIn = hibernateTemplate.get(OrderIn.class, id);
		return orderIn;
	}

	/* 分页查找
	 * @see com.dao.OrderInDAO#findAllByPaging(int, int)
	 */
	@Override
	public List<OrderIn> findAllByPaging(final int firstIndex,final int size) {
		List<OrderIn> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from OrderIn as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

	
}
