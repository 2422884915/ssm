package com.hpe.tf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 分类的实体类
 * @author 刘及光
 *
 */
@Table(name="category")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  categoryId;//主键
	@Column(name="p_id")
	private Integer pId;//父id
	private String categoryName;
	private String categoryPath;
	/**
	 * 层级：1-一级分类；2-二级分类
	 */
	private Integer level;
	private String createTime;//创建时间
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryPath() {
		return categoryPath;
	}
	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", pId=" + pId + ", categoryName=" + categoryName
				+ ", categoryPath=" + categoryPath + ", level=" + level + ", createTime=" + createTime + "]";
	}
	
	
}
