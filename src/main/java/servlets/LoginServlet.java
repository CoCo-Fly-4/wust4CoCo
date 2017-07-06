package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String path = request.getContextPath();
			
			request.getSession().setAttribute("username", username);
			
			UserDAO userdao=new UserDAO();
		
			
			boolean flag=userdao.findUser(username, password);
			if( flag ) {
				/*if(!username.equals("admin")){
					
				request.getSession().setAttribute("username", username);
				response.sendRedirect(path+"/welcome.jsp");
				}
				else{
					request.getSession().setAttribute("username", "admin");
					System.out.println("user:"+request.getSession().getAttribute("username"));
					
					request.getSession().setAttribute("username", username);
					response.sendRedirect(path+"/servlet/AdminServlet");
					}
					*/
			    String s="success";
			    response.getWriter().append(s);
				}
				
			} 

}
