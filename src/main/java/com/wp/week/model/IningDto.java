package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 入库表
 * 
 **/
@SuppressWarnings("serial")
public class IningDto implements Serializable {

	/****/
	private Integer id;

	/**粮食编号**/
	private String grainNumber;

	/**入库数量**/
	private Integer inNumber;

	/****/
	private java.util.Date storageTime;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public String getGrainNumber() {
		return grainNumber;
	}

	public void setGrainNumber(String grainNumber) {
		this.grainNumber = grainNumber;
	}

	public void setInNumber(Integer inNumber){
		this.inNumber = inNumber;
	}

	public Integer getInNumber(){
		return this.inNumber;
	}

	public void setStorageTime(java.util.Date storageTime){
		this.storageTime = storageTime;
	}

	public java.util.Date getStorageTime(){
		return this.storageTime;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
