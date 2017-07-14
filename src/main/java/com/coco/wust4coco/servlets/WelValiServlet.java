package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.JsonResult;

public class WelValiServlet extends HttpServlet {

	/**
	 *    自定义权限验证，已被Filter取代
	 *    自定义权限验证，已被Filter取代
	 *    
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username1=request.getParameter("username");
		String username2=(String)request.getSession().getAttribute("username");
		System.out.println("username1---:"+username1);
		System.out.println("username2---:"+username2);
        
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		
		if(username1.equals("null")&&username2.equals("null"))
		{
			jr.setString("index");
			jr.setStatus(0);
			System.out.println("1~");
		}
		
		if(!username1.equals("null")&&username2.equals("null"))
		{
			jr.setString("fail");
			jr.setStatus(-1);
			System.out.println("2~");
		}
		
		if(username1.equals("null")&&!username2.equals("null"))
		{
			if(username2.equals("cocoadmin"))
			{
				jr.setString("admin");
				jr.setStatus(0);
				System.out.println("3~");
			}
			else{
			jr.setPdata(username2);
			jr.setString("index?");
			jr.setStatus(0);			
			}
		}
		
		if(!username1.equals("null")&&!username2.equals("null"))
		{
			if(username1.equals(username2))
				if(username2.equals("cocoadmin"))
				{
					jr.setString("admin");
					jr.setStatus(0);
					System.out.println("5~");
				}
				else{
			jr.setString("index");
			jr.setStatus(0);
			System.out.println("6~");
			}
			else
			{
			jr.setString("fail");
		    jr.setStatus(-1);
		    System.out.println("7~");
			}
		}
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
			
	}

}
