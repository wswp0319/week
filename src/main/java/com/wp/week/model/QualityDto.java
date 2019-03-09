package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class QualityDto implements Serializable {

	/****/
	private Integer id;

	/****/
	private Integer grade;

	/**容重**/
	private Double unitWeight;

	/**水分**/
	private String moisture;

	/**杂质**/
	private String impurity;

	/****/
	private java.util.Date createTime;

	/****/
	private java.util.Date updateTime;

	/****/
	private String checker;

	/****/
	private String isActive;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setGrade(Integer grade){
		this.grade = grade;
	}

	public Integer getGrade(){
		return this.grade;
	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public void setMoisture(String moisture){
		this.moisture = moisture;
	}

	public String getMoisture(){
		return this.moisture;
	}

	public void setImpurity(String impurity){
		this.impurity = impurity;
	}

	public String getImpurity(){
		return this.impurity;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}

	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setChecker(String checker){
		this.checker = checker;
	}

	public String getChecker(){
		return this.checker;
	}

	public void setIsActive(String isActive){
		this.isActive = isActive;
	}

	public String getIsActive(){
		return this.isActive;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
