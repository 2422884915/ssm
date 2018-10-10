package com.hpe.tf.service;

import java.util.Map;

import com.hpe.tf.dto.MemberDto;
import com.hpe.tf.entity.Member;

/**   
 * @ClassName:  MemberService   
 * @Description:TODO描述：会员类的Service层接口   
 * @author: 刘及光
 * @date:   2018年9月26日 下午5:06:27       
 */  
public interface MemberService {
	/**
	 * 
	 * @Description:TODO描述：根据条件查找出相应页数的数据   
	 * @author: 刘及光
	 * @date:   2018年9月26日 下午5:08:26    
	 * @param memberDto
	 * @return
	 */
	public Map<String, Object> selectMember(MemberDto memberDto);
}
