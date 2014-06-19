package com.entity;
/**实体类
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class Clothes {
	private int id;
	private String docuNum;
	private String color;
	private int size;
	private String commodity_name;
	private int ex_factory_price;
	private Admin operator;
	private int retail_price;
	private String out_material;
	private String in_material;
	
	public String getIn_material() {
		return in_material;
	}

	public void setIn_material(String in_material) {
		this.in_material = in_material;
	}

	private int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocuNum() {
		return docuNum;
	}

	public void setDocuNum(String docuNum) {
		this.docuNum = docuNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCommodity_name() {
		return commodity_name;
	}

	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public int getEx_factory_price() {
		return ex_factory_price;
	}

	public void setEx_factory_price(int ex_factory_price) {
		this.ex_factory_price = ex_factory_price;
	}

	public Admin getOperator() {
		return operator;
	}

	public void setOperator(Admin operator) {
		this.operator = operator;
	}

	public int getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(int retail_price) {
		this.retail_price = retail_price;
	}

	public String getOut_material() {
		return out_material;
	}

	public void setOut_material(String out_material) {
		this.out_material = out_material;
	}



	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
