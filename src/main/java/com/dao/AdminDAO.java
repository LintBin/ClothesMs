package com.dao;

import java.util.List;

public interface AdminDAO {
	public List loadByUsernameAndPassword(String username,String password);
}
