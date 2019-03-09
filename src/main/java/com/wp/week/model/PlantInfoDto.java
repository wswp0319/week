package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class PlantInfoDto implements Serializable {

	/****/
	private Integer id;

	/**粮食编号**/
	private Integer plantNo;

	/**植物名称**/
	private String plantName;

	/**类别所属**/
	private String gsno;

	/**产地分布**/
	private String prodarea;

	/**生态习性**/
	private String ecolhabit;

	/****/
	private String imagePath;

	/**二维码**/
	private String dimenCode;


	private String username;
	/****/
	private String createTime;

	/****/
	private String updateTime;

	/**是否发布**/
	private String isState;

	/****/
	private String remark;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public void setPlantName(String plantName){
		this.plantName = plantName;
	}

	public String getPlantName(){
		return this.plantName;
	}

	public String getGsno() {
		return gsno;
	}

	public void setGsno(String gsno) {
		this.gsno = gsno;
	}

	public void setProdarea(String prodarea){
		this.prodarea = prodarea;
	}

	public String getProdarea(){
		return this.prodarea;
	}

	public void setEcolhabit(String ecolhabit){
		this.ecolhabit = ecolhabit;
	}

	public String getEcolhabit(){
		return this.ecolhabit;
	}

	public void setImagePath(String imagePath){
		this.imagePath = imagePath;
	}

	public String getImagePath(){
		return this.imagePath;
	}

	public void setDimenCode(String dimenCode){
		this.dimenCode = dimenCode;
	}

	public String getDimenCode(){
		return this.dimenCode;
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

	public void setIsState(String isState){
		this.isState = isState;
	}

	public String getIsState(){
		return this.isState;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
