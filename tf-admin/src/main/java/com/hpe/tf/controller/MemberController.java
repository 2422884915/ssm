package com.hpe.tf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpe.sys.util.R;
import com.hpe.tf.dto.MemberDto;
import com.hpe.tf.service.MemberService;

/**
 * 
 * @ClassName:  MemberController   
 * @Description:TODO描述： 会员的控制层  
 * @author: 刘及光
 * @date:   2018年9月27日 上午9:09:05
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	/**
	 * 
	 * @Description:TODO描述：   返回会员列表
	 * @author: 刘及光
	 * @date:   2018年9月27日 上午9:35:26    
	 * @return 
	 */
	@RequestMapping("/list")
	public R selectMember(){
		Map<String, Object> map =null;
		MemberDto memberDto =new MemberDto();
		memberDto.setPageNum(1);
		try {
			map=memberService.selectMember(memberDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			R.error();
		}
	
		return R.ok().put("page", map);
	}
}
