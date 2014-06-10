package com.util.clothes;

import com.entity.Clothes;

public class GetClothesStatus {
	public Clothes getClothes(Clothes was_found,Clothes clothes){
		
		was_found.setColor(clothes.getColor());
		was_found.setCommodity_name(clothes.getCommodity_name());
		was_found.setDocuNum(clothes.getDocuNum());
		was_found.setEx_factory_price(clothes.getEx_factory_price());
		was_found.setFlag(clothes.getId());
		was_found.setIn_material(clothes.getIn_material());
		was_found.setOperator(clothes.getOperator());
		was_found.setOut_material(clothes.getOut_material());
		was_found.setRetail_price(clothes.getRetail_price());
		was_found.setSize(clothes.getSize());
		
		return was_found;
	}
}
