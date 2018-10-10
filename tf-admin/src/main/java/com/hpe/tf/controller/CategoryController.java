package com.hpe.tf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpe.sys.util.R;
import com.hpe.tf.dto.CategoryDto;
import com.hpe.tf.entity.Category;
import com.hpe.tf.service.CategoryService;

/**   
 * @ClassName:  CategoryController   
 * @Description:分类模块的控制层  
 * @author: 刘及光
 * @date:   2018年9月26日 上午10:25:10       
 */  
@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	/**
	 * 
	 * @Description:TODO描述：   条件+分页返回列表
	 * @author: 刘及光
	 * @date:   2018年9月26日 下午2:13:19    
	 * @param category
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="list",method=RequestMethod.POST)
	@ResponseBody
	public R selectByCategory(@RequestParam Map<String, Object> params){
		
		Map<String, Object> map =null;
		CategoryDto categoryDto =new CategoryDto();
 		try {
 			
 			int pageNum =Integer.valueOf(params.get("page").toString());
 			int pageSize=Integer.valueOf(params.get("rows").toString());
 			String categoryName = params.get("categoryName")==null?"":params.get("categoryName").toString();
 			int pId=params.get("pId")==null?0:Integer.valueOf(params.get("pId").toString());
 			categoryDto.setPageNum(pageNum);
 			categoryDto.setPageSize(pageSize);
 			categoryDto.setCategoryName(categoryName);
 			categoryDto.setpId(pId);
			map =categoryService.selectByInfo(categoryDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return R.error();
		}
		return R.ok().put("page", map);
		
	}
	/**
	 * 
	 * @Description:TODO描述： 获取一级分类列表  
	 * @author: 刘及光
	 * @date:   2018年10月8日 上午8:54:49    
	 * @return
	 */
	@RequestMapping(value="/firstCategorys")
	@ResponseBody
	public R firstCategorys(){
		Map<String, Object> map=null;
		CategoryDto categoryDto =new CategoryDto();
		categoryDto.setLevel(1);
		
		try {
			map=categoryService.selectByInfo(categoryDto);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok().put("list", map);
		
	}
	/**
	 * 
	 * @Description:TODO描述：  批量删除
	 * @author: 刘及光
	 * @date:   2018年10月8日 上午10:42:06    
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delCategory" ,method=RequestMethod.POST)
	@ResponseBody
	public R delCategory(@RequestBody Integer ids[]){
			
		try {
			categoryService.del(ids);
		} catch (Exception e) {
			R.error();
		}
		return R.ok();
		
	}
	@RequestMapping(value="addCategory",method=RequestMethod.POST)
	@ResponseBody
	public R addCategory(Category category){
		try {
			categoryService.add(category);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok();
		
	}
	@RequestMapping(value="/info/{id}",method=RequestMethod.GET)
	@ResponseBody
	public R info(@PathVariable int id){
		Category category =null;
		try {
			category=categoryService.selectById(id);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok().put("category", category);
		
	}
	@RequestMapping(value="ChgCategory",method=RequestMethod.POST)
	@ResponseBody
	public R chgCategory(Category category){
		try {
			categoryService.chg(category);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok();
		
	}
	@RequestMapping(value="secondCategorys",method=RequestMethod.POST)
	@ResponseBody
	public R secondCategorys(int pId){
		Map<String, Object> map  =new HashMap<>();
		try {
			CategoryDto categoryDto =new CategoryDto();
			categoryDto.setpId(pId);
			map = categoryService.selectByInfo(categoryDto);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok().put("secondList", map);
		
	}
		
	
}
