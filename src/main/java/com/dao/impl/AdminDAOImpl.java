package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.util.PageNoUtil;

@SuppressWarnings("unchecked")
@Component("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List<Admin> loadByUsernameAndPassword(String username,String password){
		List<Admin> result = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username=? and a.password =?",username,password);
		return result;
	}

	@Override
	public void save(Admin admin) {
		hibernateTemplate.save(admin);
	}
	
	@Override
	public void updateFlag(Admin admin){
		hibernateTemplate.update(admin);
	}

	@Override
	public List<Admin> loadByUsername(String username) {
		List<Admin> result = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username = ?", username );
		return result;
	}
	
	@Override
	public void update(Admin admin){
		hibernateTemplate.update(admin);
	}

	@Override
	public List<Admin> findAllByPaging(final int firstIndex ,final int size) {
		List<Admin> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Admin as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin result = hibernateTemplate.get(Admin.class, id);
		return result;
	}
	
}
