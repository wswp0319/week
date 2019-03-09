package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class NoticeDto implements Serializable {

	/****/
	private Integer id;

	/****/
	private String title;

	/****/
	private String content;

	/****/
	private String username;

	/****/
	private java.util.Date createTime;

	/**1审核，2未审核**/
	private String isAsses;



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

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setIsAsses(String isAsses){
		this.isAsses = isAsses;
	}

	public String getIsAsses(){
		return this.isAsses;
	}

}
