package com.hpe.tf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  Item   
 * @Description:TODO描述：   商品表
 * @author: 刘及光
 * @date:   2018年10月8日 下午6:33:53
 */
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemId;//商品id，自动递增
	@Column(name="category_id")
	private Integer categoryId;//分类id
	@Column(name="item_title")
	private String itemTitle;//商品名称
	@Column(name="item_Img")
	private String itemImg;//商品图片
	@Column(name="item_desc")
	private String itemDesc;//商品详细描述
	private String price;//商品价格
	private Integer sales;//销量默认为0
	@Column(name="create_time")
	private String createTime;//创建时间
	private Integer disabled;//是否删除，默认为0 0-未删除1-删除
	@Column(name="is_recommend")
	private Integer isRecommend;//是否推荐商品0-不是 1-是
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	public Integer getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	
	
	
}
