package com.hpe.tf.dto;

import com.hpe.tf.entity.Member;

/**   
 * @ClassName:  MemberDto   
 * @Description:TODO描述：会员类的dto，为了调整查询条件和分页   
 * @author: 刘及光
 * @date:   2018年9月26日 下午5:05:05       
 */  
public class MemberDto extends Member {
	private int pageNum;//第几页
	private int pageSize=10;//叶容量 每页展示多少条
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "MemberDto [pageNum=" + pageNum + ", pageSize=" + pageSize + ", getPageNum()=" + getPageNum()
				+ ", getPageSize()=" + getPageSize() + ", getMemberId()=" + getMemberId() + ", getMemberName()="
				+ getMemberName() + ", getAccount()=" + getAccount() + ", getPassword()=" + getPassword()
				+ ", getPhone()=" + getPhone() + ", getAddress()=" + getAddress() + ", getDisabled()=" + getDisabled()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
