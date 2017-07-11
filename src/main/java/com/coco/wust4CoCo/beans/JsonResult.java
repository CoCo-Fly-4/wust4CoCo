package com.coco.wust4CoCo.beans;

public class JsonResult{
	
	private String string ;
	private int status;
	private String Pdata;
	
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
