package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.JsonResult;

public class WelValiServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username1=request.getParameter("username");
		String username2=(String)request.getSession().getAttribute("username");
		System.out.println("username1---:"+username1);
		System.out.println("username2---:"+username2);
        
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		
		if(username1.equals(username2))
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
