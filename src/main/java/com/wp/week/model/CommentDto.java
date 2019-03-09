package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 评论表
 * 
 **/
@SuppressWarnings("serial")
public class CommentDto implements Serializable {

	/****/
	private Integer id;

	/**植物id**/
	private Integer plantId;

	/**评论内容**/
	private String content;

	/****/
	private java.util.Date createTime;

	/**评论者**/
	private String revier;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setPlantId(Integer plantId){
		this.plantId = plantId;
	}

	public Integer getPlantId(){
		return this.plantId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setRevier(String revier){
		this.revier = revier;
	}

	public String getRevier(){
		return this.revier;
	}

}
