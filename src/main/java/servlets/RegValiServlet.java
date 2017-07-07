package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAO;

public class RegValiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public RegValiServlet() {
	       super();
	   }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

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
   
		
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		String path = request.getContextPath(); //获取请求路径
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		UserDAO userdao=new UserDAO();
		
		String ss=new String();
		StringBuilder sb = new StringBuilder();
		if( userdao.isUsernameExists(username) ){	
	    	ss="用户名不可用";   
	    	System.out.println("用户名不可用");
		}
		else if(username!=null)
			
		{
			ss="Pass"; 
			System.out.println("用户名可用");
		}
		response.getWriter().append(ss);
	}

}
