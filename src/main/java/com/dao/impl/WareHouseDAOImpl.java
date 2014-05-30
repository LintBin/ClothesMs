package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.WareHouseDAO;
import com.entity.Admin;
import com.entity.WareHouse;
import com.util.PageNoUtil;
@SuppressWarnings("unchecked")
@Component
public class WareHouseDAOImpl implements WareHouseDAO{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(WareHouse wareHouse) {
		hibernateTemplate.save(wareHouse);
	}

	@Override
	public List findByDocu_number(String docu_number) {

		List<WareHouse> list = (List<WareHouse>) hibernateTemplate.find("from WareHouse as wh where wh.docu_number=?",docu_number);
		return list;
	}

	@Override
	public void updateFlag(WareHouse warreHouse) {
		hibernateTemplate.update(warreHouse);
	}

	@Override
	public void update(WareHouse wareHouse) {
		hibernateTemplate.update(wareHouse);
	}

	@Override
	public List<WareHouse> findAllByPaging(final int firstIndex,final int size) {
		List<WareHouse> list = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from WareHouse ";
				List<?> list = PageNoUtil.getList(session, hql, firstIndex, size);
				return list;
			}
		});
		return list;
	}
	
}
