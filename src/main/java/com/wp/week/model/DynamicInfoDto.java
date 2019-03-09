package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class DynamicInfoDto implements Serializable {

	/****/
	private Integer id;

	/**粮食编号**/
	private Integer plantNo;

	/**基本情况**/
	private String basicState;

	/**是否生病**/
	private String isIll;

	/**检查人**/
	private String checker;

	/****/
	private String isMove;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setPlantNo(Integer plantNo){
		this.plantNo = plantNo;
	}

	public Integer getPlantNo(){
		return this.plantNo;
	}

	public void setBasicState(String basicState){
		this.basicState = basicState;
	}

	public String getBasicState(){
		return this.basicState;
	}

	public void setIsIll(String isIll){
		this.isIll = isIll;
	}

	public String getIsIll(){
		return this.isIll;
	}

	public void setChecker(String checker){
		this.checker = checker;
	}

	public String getChecker(){
		return this.checker;
	}

	public void setIsMove(String isMove){
		this.isMove = isMove;
	}

	public String getIsMove(){
		return this.isMove;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
