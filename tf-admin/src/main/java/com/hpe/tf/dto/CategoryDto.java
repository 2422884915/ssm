package com.hpe.tf.dto;


import com.hpe.tf.entity.Category;

public class CategoryDto extends Category{
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
		return "CategoryDto [pageNum=" + pageNum + ", pageSize=" + pageSize + ", getPageNum()=" + getPageNum()
				+ ", getPageSize()=" + getPageSize() + ", getCategoryId()=" + getCategoryId() + ", getpId()=" + getpId()
				+ ", getCategoryName()=" + getCategoryName() + ", getCategoryPath()=" + getCategoryPath()
				+ ", getLevel()=" + getLevel() + ", getCreateTime()=" + getCreateTime() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}
