package com.coco.wust4coco.beans;

public class JsonResult{            
	
	private String string ;          //自定义Json返回字符串
	private int status;              //自定义Json返回状态
	private String Pdata;            //自定义Json返回数据
	
	public String getPdata() {
		return Pdata;
	}
	public void setPdata(String pdata) {
		Pdata = pdata;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	


}
