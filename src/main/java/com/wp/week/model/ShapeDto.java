package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 形状表
 * 
 **/
@SuppressWarnings("serial")
public class ShapeDto implements Serializable {

	/****/
	private Integer id;

	/**粮食形状**/
	private java.util.Date grainForm;

	/**长**/
	private Double longness;

	/**宽**/
	private Double width;

	/****/
	private java.util.Date checktime;

	/****/
	private String checker;

	/****/
	private String isactive;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setGrainForm(java.util.Date grainForm){
		this.grainForm = grainForm;
	}

	public java.util.Date getGrainForm(){
		return this.grainForm;
	}

	public Double getLongness() {
		return longness;
	}

	public void setLongness(Double longness) {
		this.longness = longness;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public void setChecktime(java.util.Date checktime){
		this.checktime = checktime;
	}

	public java.util.Date getChecktime(){
		return this.checktime;
	}

	public void setChecker(String checker){
		this.checker = checker;
	}

	public String getChecker(){
		return this.checker;
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
