package com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PageNoUtil {
	public static List<?> getList(Session session,String hql , int firstIndex,int size){
		Query query = session.createQuery(hql).setFirstResult(firstIndex).setMaxResults(size);
		List<?> list = query.list();
		return list;
	}
}
