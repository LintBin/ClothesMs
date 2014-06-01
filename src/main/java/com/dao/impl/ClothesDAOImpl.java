package com.dao.impl;

import java.util.List;



import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.ClothesDAO;
import com.entity.Admin;
import com.entity.Clothes;
import com.util.PageNoUtil;

@SuppressWarnings("unchecked")
@Component
public class ClothesDAOImpl implements ClothesDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//通过编号查找
	@Override
	public List<Clothes> findClothesByDocuNum(String docuNum) {
		List<Clothes> result = (List<Clothes>) hibernateTemplate.find("from Clothes as c where c.docuNum = ?",docuNum);
		return result;
	}

	@Override
	public void save(Clothes clothes) {
		hibernateTemplate.save(clothes);
	}

	@Override
	public void update(Clothes clothes) {
		hibernateTemplate.update(clothes);
	}
	
	//删除
	@Override
	public void updateFlag(Clothes clothes){
		hibernateTemplate.update(clothes);
	}
	
	//分页查找
	@Override
	public List<Clothes> findAllByPaging(final int firstIndex,final int size) {
		List<Clothes> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Clothes as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

}
