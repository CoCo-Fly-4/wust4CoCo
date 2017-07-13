package com.coco.wust4CoCo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coco.wust4CoCo.beans.Film;
import com.coco.wust4CoCo.beans.JsonResult;
import com.coco.wust4CoCo.dao.FilmDAO;
import com.google.gson.Gson;

public class AddFilmServlet extends HttpServlet {

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

		String moviename=request.getParameter("newname");
		String classify=request.getParameter("newclassify");
		String newactor=request.getParameter("newactor");
		String newaddress=request.getParameter("newaddress");
		String newurl=request.getParameter("newurl");
		String newintro=request.getParameter("newintro");
		
		FilmDAO filmdao=new FilmDAO();
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		boolean flag=filmdao.addmovie(moviename, classify, newactor, newaddress, newurl, newintro);
		
		if(flag)
		{
			jr.setString("success");
			jr.setStatus(0);
		}
		else{
			jr.setString("fail");
			jr.setStatus(-1);
		}
		
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
	}

}
