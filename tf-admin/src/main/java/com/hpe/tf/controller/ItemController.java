package com.hpe.tf.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hpe.sys.util.R;
import com.hpe.sys.util.ToByteArray;
import com.hpe.tf.dto.ItemDto;
import com.hpe.tf.dto.ItemPageDto;
import com.hpe.tf.entity.Item;
import com.hpe.tf.service.ItemService;

@Controller
@RequestMapping(value="/item")
public class ItemController {
	@Autowired 
	private ItemService itemService;
	
	@RequestMapping(value="list",method=RequestMethod.POST )
	@ResponseBody
	public R itemList(@RequestParam Map<String, Object> params){
		Map<String, Object> map =new HashMap<>();
		ItemPageDto itemPageDto =new ItemPageDto();
		try {
			int pageNum =Integer.valueOf(params.get("page").toString());
 			int pageSize=Integer.valueOf(params.get("rows").toString());
 			//获得查询的值
 			String itemTitle=params.get("itemTitle")==null?null:params.get("itemTitle").toString();
 			int categoryId=Integer.valueOf(params.get("categoryId")==null?"0":params.get("categoryId").toString());
 			
 			itemPageDto.setPageNum(pageNum);
 			itemPageDto.setPageSize(pageSize);
 			itemPageDto.setItemTitle(itemTitle==null?null:"%"+itemTitle+"%");
 			itemPageDto.setCategoryId(categoryId);
			map=itemService.findItem(itemPageDto);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok().put("page", map);
		
	}
	
/*	@RequestMapping(value="uploadItemImg",method=RequestMethod.POST )
	@ResponseBody*/
	/**
	 * 
	 * 
	 * @Description:TODO描述：  根据获取的图片放入fastDfs中 
	 * @author: 刘及光
	 * @date:   2018年10月10日 下午3:31:58    
	 * @return
	 */
/*	public R uploadItemImg(@RequestParam(value = "itemImg", required = false) MultipartFile itemImg){
		String url="http://192.168.85.128/";
		try {
			InputStream inputStream = itemImg.getInputStream();
			String name=itemImg.getName();
			String name2=itemImg.getOriginalFilename();
			//格式名称
			String extName = itemImg.getOriginalFilename().substring(itemImg.getOriginalFilename().lastIndexOf(".")+1);
			FastDFSClient fastDFSClient=new FastDFSClient("classpath:client.conf");
			String uri = fastDFSClient.uploadFile(ToByteArray.toByteArray(inputStream), extName);
			url=url+uri;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return R.error();
		}
		return R.ok().put("url", url);
		
	}*/
	@RequestMapping(value="addItem",method=RequestMethod.POST )
	@ResponseBody
	public R addItem(Item item){
		try {
			itemService.addItem(item);
		} catch (Exception e) {
			return R.error();
		}
		
		return R.ok();
		
	}
	/**
	 * 
	 * @Description:TODO描述：根据id删除商品   
	 * @author: 刘及光
	 * @date:   2018年10月10日 下午8:15:28    
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="deleteItemByIds",method=RequestMethod.POST )
	@ResponseBody
	public R deleteItemByIds(@RequestBody int[] ids){
		try {
			itemService.deleteItemByIds(ids);
		} catch (Exception e) {
			return R.error();
		}
		
		return R.ok();
		
	}
	


	
}
