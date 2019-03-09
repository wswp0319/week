package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 出库表
 * 
 **/
@SuppressWarnings("serial")
public class ExitingDto implements Serializable {

	/****/
	private Integer id;

	/**粮食编号**/
	private String grainNumber;

	/**出库数量**/
	private Integer outNum;

	/****/
	private java.util.Date outTime;

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

	public String getGrainNumber() {
		return grainNumber;
	}

	public void setGrainNumber(String grainNumber) {
		this.grainNumber = grainNumber;
	}

	public void setOutNum(Integer outNum){
		this.outNum = outNum;
	}

	public Integer getOutNum(){
		return this.outNum;
	}

	public void setOutTime(java.util.Date outTime){
		this.outTime = outTime;
	}

	public java.util.Date getOutTime(){
		return this.outTime;
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
