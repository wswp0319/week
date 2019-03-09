package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class ReplyDto implements Serializable {

	/****/
	private Integer id;

	/**评论id**/
	private Integer commentId;

	/**回复**/
	private String content;

	/****/
	private java.util.Date createTime;

	/**回复者**/
	private String replyer;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setCommentId(Integer commentId){
		this.commentId = commentId;
	}

	public Integer getCommentId(){
		return this.commentId;
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

	public void setReplyer(String replyer){
		this.replyer = replyer;
	}

	public String getReplyer(){
		return this.replyer;
	}

}
