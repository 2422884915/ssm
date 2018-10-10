package com.hpe.tf.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpe.sys.util.ToolUtil;
import com.hpe.tf.dao.CategoryMapper;
import com.hpe.tf.dto.CategoryDto;
import com.hpe.tf.entity.Category;
import com.hpe.tf.service.CategoryService;

/**
 * @ClassName: CategoryServiceImpl
 * @Description:分类模块的service实现类
 * @author: 刘及光
 * @date: 2018年9月26日 上午10:27:50
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public Map<String, Object> selectByInfo(CategoryDto categoryDto) throws RuntimeException {
		Map<String, Object> map =new HashMap<>();//返回结果
		List<Category> categories =null;//查询的记录
		
		// 通用mapper实现条件查询selectExample
		Example example = new Example(Category.class);
		Criteria criteria = example.createCriteria();
		// 具体的查询条件的设置
		if (categoryDto.getCategoryName() != null && !"".equals(categoryDto.getCategoryName().trim())) {
		//	!StringUtils.isEmpty(categoryDto.getCategoryName())
			criteria.andLike("categoryName", "%" + categoryDto.getCategoryName() + "%");//分类名称模糊查询
		}
		if (categoryDto.getpId()!=null&&categoryDto.getpId()!=0) {
			criteria.andEqualTo("pId",categoryDto.getpId());//父id查询
		}
		if (categoryDto.getLevel()!=null &&categoryDto.getLevel()!=0) {
			criteria.andEqualTo("level", categoryDto.getLevel());
		}
		//第几页
		if (categoryDto.getPageNum()>0) {//需要分页查询
			//mapper分页查询 PageHelper 在查询语句之前
			PageHelper.startPage(categoryDto.getPageNum(), categoryDto.getPageSize());
			categories = categoryMapper.selectByExample(example);
			
			PageInfo<Category> pageInfo =new PageInfo<>(categories);
			//查询多少条记录
			//返回结果集的封装
			map.put("rows", pageInfo.getList());//记录 
			map.put("total", pageInfo.getTotal());//总记录数
			map.put("pages", pageInfo.getPages());//一共多少页
			map.put("pageNum", pageInfo.getPageNum());//当前页
		
			
		}else {
			categories = categoryMapper.selectByExample(example);
			map.put("rows", categories);//查询记录
		}
		
		
		return map;
	}
	
	@Override
	public int del(Integer[] ids) throws RuntimeException{
		//返回的结果
		
		return categoryMapper.del(ids);
	}

	@Override
	public int add(Category category) throws RuntimeException {
		if (category.getpId()==0) {
			category.setLevel(1);
		}else {
			category.setLevel(2);
		}
		category.setCreateTime(ToolUtil.getCurrentTime());
		return categoryMapper.insertSelective(category);
	}

	@Override
	public int chg(Category category) throws RuntimeException {
		// TODO Auto-generated method stub
		Example example = new Example(Category.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("categoryId", category.getCategoryId());
		return categoryMapper.updateByExample(category, example);
	}

	@Override
	public Category selectById(int id) {
		// TODO Auto-generated method stub
		
		return categoryMapper.selectByPrimaryKey(id);
	}

	
}
