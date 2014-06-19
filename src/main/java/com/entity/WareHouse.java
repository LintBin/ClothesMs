package com.entity;
/**实体类
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class WareHouse {
	public int id;
	public String docu_number;
	public String contact_phone;
	public String name;
	public String contact;
	public int total_storage;
	public int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocu_number() {
		return docu_number;
	}

	public void setDocu_number(String docu_number) {
		this.docu_number = docu_number;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getTotal_storage() {
		return total_storage;
	}

	public void setTotal_storage(int total_storage) {
		this.total_storage = total_storage;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
