package com.hpe.tf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpe.tf.dao.ItemMapper;
import com.hpe.tf.dto.ItemDto;
import com.hpe.tf.dto.ItemPageDto;
import com.hpe.tf.entity.Item;
import com.hpe.tf.service.ItemService;
/**
 * 
 * @ClassName:  ItemServiceImpl   
 * @Description:TODO描述：   商品服务层实现类
 * @author: 刘及光
 * @date:   2018年10月8日 下午7:26:29
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper itemMapper;
	@Override
	public Map<String, Object> findItem(ItemPageDto itemPageDto)  throws RuntimeException{
		Map<String, Object> map =new HashMap<>();
		PageHelper.startPage(itemPageDto.getPageNum(), itemPageDto.getPageSize());
		List<ItemDto> list = itemMapper.findItem(itemPageDto);
		PageInfo<ItemDto> pageInfo =new PageInfo<>(list);
		//查询多少条记录
		//返回结果集的封装
		map.put("rows", pageInfo.getList());//记录 
		map.put("total", pageInfo.getTotal());//总记录数
		map.put("pages", pageInfo.getPages());//一共多少页
		map.put("pageNum", pageInfo.getPageNum());//当前页
		return map;
		
	}
	@Override
	public int addItem(Item item) throws RuntimeException {
		
		return itemMapper.insertSelective(item);
	}
	@Override
	public int deleteItemByIds(int[] ids) throws RuntimeException {
		// TODO Auto-generated method stub
		return itemMapper.deleteItemByIds(ids);
	}

}
