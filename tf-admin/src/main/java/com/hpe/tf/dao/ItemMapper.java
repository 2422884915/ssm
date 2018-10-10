package com.hpe.tf.dao;

import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.hpe.tf.dto.ItemDto;
import com.hpe.tf.entity.Item;

/**
 * 
 * @ClassName:  ItemMapper   
 * @Description:TODO描述： 商品表和数据库的交互  
 * @author: 刘及光
 * @date:   2018年10月8日 下午6:58:13
 */
public interface ItemMapper extends Mapper<Item>{
	/**
	 * 
	 * @Description:TODO描述：  查找商品 
	 * @author: 刘及光
	 * @date:   2018年10月8日 下午7:24:29    
	 * @param item
	 * @return
	 */
	List<ItemDto>  findItem(Item item);
	
	int deleteItemByIds(int[] ids);
}
