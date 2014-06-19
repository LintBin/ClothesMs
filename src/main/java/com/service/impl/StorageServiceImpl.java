/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import javax.annotation.Resource;

import com.dao.StorageDAO;
import com.entity.Storage;
import com.service.StorageService;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0W
 */
public class StorageServiceImpl implements StorageService {
	@Resource
	private StorageDAO storageDAOImpl;
	/* (non-Javadoc)
	 * @see com.service.StorageService#save()
	 */
	@Override
	public String save(Storage storage) {
		storageDAOImpl.add(storage);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.StorageService#findById()
	 */
	@Override
	public Storage findById() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.StorageService#delete()
	 */
	@Override
	public String delete(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.StorageService#update()
	 */
	@Override
	public String update(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
