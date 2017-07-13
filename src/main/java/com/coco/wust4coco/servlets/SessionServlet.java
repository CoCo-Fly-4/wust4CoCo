package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coco.wust4coco.beans.JsonResult;
import com.google.gson.Gson;

public class SessionServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String session=(String)request.getSession().getAttribute("username");
		System.out.println("SessionSservlet:---"+session);
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		jr.setPdata(session);
		jr.setStatus(0);
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
	}

}
