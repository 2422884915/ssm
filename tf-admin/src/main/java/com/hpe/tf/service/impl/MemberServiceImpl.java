package com.hpe.tf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpe.tf.dao.MemberMapper;
import com.hpe.tf.dto.MemberDto;
import com.hpe.tf.entity.Member;
import com.hpe.tf.service.MemberService;

/**   
 * @ClassName:  MemberServiceImpl   
 * @Description:TODO描述：   会员类的Service实现类
 * @author: 刘及光
 * @date:   2018年9月26日 下午5:11:10       
 */
@Service
public class MemberServiceImpl implements MemberService{
	private MemberMapper memberMapper;
	/**
	 * 暂时性只有根据姓名查询
	 */
	@Override
	public Map<String, Object> selectMember(MemberDto memberDto) {
		List<Member> members=null;
		//声明一个Map集合
		Map<String, Object> map =new HashMap<>();
		
		Example example =new Example(Member.class);
		Criteria criteria =example.createCriteria();
		//根据姓名模糊查询
		if (memberDto.getMemberName()!=null &&!"".equals(memberDto.getMemberName())) {
			criteria.andLike("memberName","%"+memberDto.getMemberName()+"%");
		}
		
		//第几页
		if (memberDto.getPageNum()>0) {//需要分页查询
			PageHelper.startPage(memberDto.getPageNum(), memberDto.getPageSize());
			//查询
			 members = memberMapper.selectByExample(example);
			 PageInfo<Member> pageInfo =new PageInfo<>(members);
			 map.put("rows", pageInfo.getList());//记录
			 map.put("total", pageInfo.getTotal());//总记录数
			 map.put("pages", pageInfo.getPages());//总页数
			 map.put("pageNum", pageInfo.getPageNum());//当前页数
		}else {											//不需要分页查询
			 members = memberMapper.selectByExample(example);
			 map.put("rows", members);
		}
		
		return map;
	}

}
