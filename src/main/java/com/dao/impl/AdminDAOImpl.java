package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;

@Component("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List loadByUsernameAndPassword(String username,String password){
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setFlag(1);
		List<Admin> list = hibernateTemplate.findByExample(admin);
		return list;
	}

	@Override
	public String save(Admin admin) {
		
	//	hibernateTemplate.getSessionFactory().getCurrentSession().save(admin);
		/*System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();*/
//		System.out.println(">>>>>" + tx);
		
/*		try{
			session.save(admin);
		//	tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		System.out.println(admin.getId());
		System.out.println(admin.getIntroduction());
		System.out.println(admin.getName());
		System.out.println(admin.getPassword());
		System.out.println(admin.getUsername());
		
		
		
		
		hibernateTemplate.save(admin);
		return null;
	}
	
	
	
	
}
