/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.Storage;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public interface StorageDAO {
	public void add(Storage storage);
	public void update(Storage storage);
	public void updateFlag(Storage storage);
	public List<Storage> findByPaging(final int firstIndex ,final int size);
	public Storage findById(int id);
}

