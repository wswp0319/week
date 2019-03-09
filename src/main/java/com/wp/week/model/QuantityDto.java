package com.wp.week.model;
import java.io.Serializable;

/**
 *
 *
 *
 **/
@SuppressWarnings("serial")
public class QuantityDto implements Serializable {

	/****/
	private Integer id;

	private String plantId;

	/**入库量**/
	private Integer inQuantity;

	/**出库量**/
	private Integer outQuantity;

	/**总数量**/
	private Integer totalQuantity;

	/**差数**/
	private Integer difference;

	/**差率**/
	private Integer gradient;

	/****/
	private String createTime;

	/****/
	private String updateTime;

	/****/
	private String checker;

	/****/
	private String isActive;

	/****/
	private String remark;

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setInQuantity(Integer inQuantity){
		this.inQuantity = inQuantity;
	}

	public Integer getInQuantity(){
		return this.inQuantity;
	}

	public void setOutQuantity(Integer outQuantity){
		this.outQuantity = outQuantity;
	}

	public Integer getOutQuantity(){
		return this.outQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity){
		this.totalQuantity = totalQuantity;
	}

	public Integer getTotalQuantity(){
		return this.totalQuantity;
	}

	public void setDifference(Integer difference){
		this.difference = difference;
	}

	public Integer getDifference(){
		return this.difference;
	}

	public void setGradient(Integer gradient){
		this.gradient = gradient;
	}

	public Integer getGradient(){
		return this.gradient;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
