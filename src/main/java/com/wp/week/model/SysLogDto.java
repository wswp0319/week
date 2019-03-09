package com.wp.week.model;
import java.io.Serializable;

/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class SysLogDto implements Serializable {

	/****/
	private Integer id;

	/**操作模块**/
	private String moduleName;

	/**操作动作**/
	private String actionname;

	/**操作信息**/
	private String message;

	/**操作者**/
	private String username;

	/**ip地址**/
	private String ip;

	/**操作时间**/
	private java.util.Date careteTime;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setModuleName(String moduleName){
		this.moduleName = moduleName;
	}

	public String getModuleName(){
		return this.moduleName;
	}

	public void setActionname(String actionname){
		this.actionname = actionname;
	}

	public String getActionname(){
		return this.actionname;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setIp(String ip){
		this.ip = ip;
	}

	public String getIp(){
		return this.ip;
	}

	public void setCareteTime(java.util.Date careteTime){
		this.careteTime = careteTime;
	}

	public java.util.Date getCareteTime(){
		return this.careteTime;
	}

}
