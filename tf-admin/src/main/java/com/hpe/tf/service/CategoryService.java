package com.hpe.tf.service;

import java.util.List;
import java.util.Map;

import com.hpe.tf.dto.CategoryDto;
import com.hpe.tf.entity.Category;


/**   
 * @ClassName:  CategoryService   
 * @Description:分类模块的service接口 
 * @author: 刘及光
 * @date:   2018年9月26日 上午10:27:18       
 */  
public interface CategoryService {
	/**
	 * 
	 * @Description:TODO描述：   条件+分页查询分类列表
	 * @author: 刘及光
	 * @date:   2018年9月26日 上午10:51:57    
	 * @param categoryDto
	 * @return map
	 * @throws RuntimeException
	 */
	public Map<String, Object>  selectByInfo(CategoryDto categoryDto) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述： 根据id批量删除   
	 * @author: 刘及光
	 * @date:   2018年10月8日 上午10:07:34    
	 * @param ids
	 * @return
	 */
	public int del(Integer[] ids) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述：添加   分类
	 * @author: 刘及光
	 * @date:   2018年10月8日 下午1:02:52    
	 * @param category
	 * @return
	 * @throws RuntimeException
	 */
	public int add(Category category) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述： 修改分类  
	 * @author: 刘及光
	 * @date:   2018年10月8日 下午1:05:02    
	 * @param category
	 * @return
	 * @throws RuntimeException
	 */
	public int chg(Category category) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述：   根据id查找分类
	 * @author: 刘及光
	 * @date:   2018年10月8日 下午5:12:45    
	 * @param id
	 * @return
	 */
	public Category selectById(int id);
	
}
