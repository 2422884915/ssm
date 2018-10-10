package com.hpe.tf.dto;

import com.hpe.tf.entity.Category;
import com.hpe.tf.entity.Item;

public class ItemDto extends Item{
	
	
	private Category category;//分类对象
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
