package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class NewsDto implements Serializable {

	/****/
	private Integer id;

	/****/
	private String title;

	/****/
	private String content;

	/****/
	private String keywords;

	/****/
	private String isTop;

	/****/
	private String isActive;

	/****/
	private String hit;

	/****/
	private java.util.Date createTime;

	/****/
	private java.util.Date updateTime;

	/****/
	private String username;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getKeywords(){
		return this.keywords;
	}

	public void setIsTop(String isTop){
		this.isTop = isTop;
	}

	public String getIsTop(){
		return this.isTop;
	}

	public void setIsActive(String isActive){
		this.isActive = isActive;
	}

	public String getIsActive(){
		return this.isActive;
	}

	public void setHit(String hit){
		this.hit = hit;
	}

	public String getHit(){
		return this.hit;
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

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

}
