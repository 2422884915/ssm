package com.hpe.tf.service;

import java.util.Map;

import com.hpe.tf.dto.ItemDto;
import com.hpe.tf.dto.ItemPageDto;
import com.hpe.tf.entity.Item;

/**
 * 
 * @ClassName:  ItemService   
 * @Description:TODO描述：商品表的服务层   
 * @author: 刘及光
 * @date:   2018年10月8日 下午7:23:17
 */
public interface ItemService {
	/**
	 * 
	 * @Description:TODO描述：   分页查找数据
	 * @author: 刘及光
	 * @date:   2018年10月8日 下午7:25:22    
	 * @param itemDto
	 * @return
	 */
	Map<String,Object> findItem(ItemPageDto itemPageDto) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述：  根据所选数据id删除商品
	 * @author: 刘及光
	 * @date:   2018年10月10日 下午8:06:07    
	 * @param ids
	 * @return
	 * @throws RuntimeException
	 */
	int deleteItemByIds(int[] ids) throws RuntimeException;
	/**
	 * 
	 * @Description:TODO描述：   添加商品数据
	 * @author: 刘及光
	 * @date:   2018年10月10日 下午8:03:39    
	 * @param item
	 * @return
	 * @throws RuntimeException
	 */
	int addItem(Item item) throws RuntimeException;
	
	
}
