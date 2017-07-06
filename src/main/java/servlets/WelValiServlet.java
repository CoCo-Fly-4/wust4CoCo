package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username1=request.getParameter("username");
		String username2=(String)request.getSession().getAttribute("username");
		System.out.println("username1---:"+username1);
		System.out.println("username2---:"+username2);
		String s=new String();
		if(username2!=null&&username1.equals(username2))
			s="success";
		else
			s="fail";
		
		response.getWriter().append(s);
			
	}

}
