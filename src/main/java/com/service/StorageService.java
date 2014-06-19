/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import com.entity.Storage;

/**除findById方法外，其他返回的是错误信息，如果错误信息为空，则成功调用
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public interface StorageService {
	public String save(Storage storage);
	
	/**
	 * @return 实体 Storage
	 * @Description 当返回空值时，为找不到
	 */
	public Storage findById();
	public String delete(Storage storage);
	public String update(Storage storage);
}
