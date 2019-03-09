package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 货位表
 * 
 **/
@SuppressWarnings("serial")
public class CargoDto implements Serializable {

	/****/
	private Integer id;

	/**货位号**/
	private Integer cargoNumber;

	/**存储地点**/
	private String storageSite;

	/**仓库名称**/
	private String warehouseName;

	/**品种**/
	private String assortment;

	/****/
	private String storageMode;

	/****/
	private java.util.Date createTime;

	/****/
	private java.util.Date updateTime;

	/**管理员**/
	private String manager;

	/**状态**/
	private String isActive;

	/****/
	private String remark;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setCargoNumber(Integer cargoNumber){
		this.cargoNumber = cargoNumber;
	}

	public Integer getCargoNumber(){
		return this.cargoNumber;
	}

	public void setStorageSite(String storageSite){
		this.storageSite = storageSite;
	}

	public String getStorageSite(){
		return this.storageSite;
	}

	public void setWarehouseName(String warehouseName){
		this.warehouseName = warehouseName;
	}

	public String getWarehouseName(){
		return this.warehouseName;
	}

	public void setAssortment(String assortment){
		this.assortment = assortment;
	}

	public String getAssortment(){
		return this.assortment;
	}

	public void setStorageMode(String storageMode){
		this.storageMode = storageMode;
	}

	public String getStorageMode(){
		return this.storageMode;
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

	public void setManager(String manager){
		this.manager = manager;
	}

	public String getManager(){
		return this.manager;
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
