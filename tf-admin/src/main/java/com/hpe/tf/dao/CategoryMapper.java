package com.hpe.tf.dao;

import com.github.abel533.mapper.Mapper;
import com.hpe.tf.entity.Category;
/**
 * 
 * @ClassName:  CategoryMapper   
 * @Description:TODO描述：   分类管理的数据交互层
 * @author: 刘及光
 * @date:   2018年10月8日 上午10:13:59
 */
public interface CategoryMapper extends Mapper<Category>{
	/**
	 * 
	 * @Description:TODO描述：  批量删除 
	 * @author: 刘及光
	 * @date:   2018年10月8日 上午10:13:55    
	 * @param ids
	 * @return
	 */
	public int del(Integer[] ids);
}
