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

import com.dao.StorageDAO;
import com.entity.Clothes;
import com.entity.Storage;
import com.util.PageNoUtil;
/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
@Component
public class StorageDAOImpl implements StorageDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#add(com.entity.Storage)
	 */
	@Override
	public void add(Storage storage) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(storage);
	}

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#updata(com.entity.Storage)
	 */
	@Override
	public void update(Storage storage) {
		hibernateTemplate.update(storage);
	}
	
	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#findById(int)
	 */
	@Override
	public Storage findById(int id) {
		Storage storage = hibernateTemplate.get(Storage.class, id);
		return storage;
	}

	

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#delete(com.entity.Storage)
	 */
	@Override
	public void updateFlag(Storage storage) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(storage);;
	}

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#findByPaging()
	 */
	@Override
	public List<Storage> findByPaging(final int firstIndex ,final int size) {
		List<Storage> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Storage as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}
	
	
}
