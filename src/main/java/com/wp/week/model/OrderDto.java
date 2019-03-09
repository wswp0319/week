package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class OrderDto implements Serializable {

	/****/
	private Integer id;

	/**订单号**/
	private Integer orderNo;

	/**客户名称**/
	private String stuname;

	/**下单时间**/
	private java.util.Date confirmTime;

	/**价格**/
	private java.math.BigDecimal price;

	/**管理员**/
	private String manager;

	/**激活状态**/
	private String isactive;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setOrderNo(Integer orderNo){
		this.orderNo = orderNo;
	}

	public Integer getOrderNo(){
		return this.orderNo;
	}

	public void setStuname(String stuname){
		this.stuname = stuname;
	}

	public String getStuname(){
		return this.stuname;
	}

	public void setConfirmTime(java.util.Date confirmTime){
		this.confirmTime = confirmTime;
	}

	public java.util.Date getConfirmTime(){
		return this.confirmTime;
	}

	public void setPrice(java.math.BigDecimal price){
		this.price = price;
	}

	public java.math.BigDecimal getPrice(){
		return this.price;
	}

	public void setManager(String manager){
		this.manager = manager;
	}

	public String getManager(){
		return this.manager;
	}

	public void setIsactive(String isactive){
		this.isactive = isactive;
	}

	public String getIsactive(){
		return this.isactive;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
