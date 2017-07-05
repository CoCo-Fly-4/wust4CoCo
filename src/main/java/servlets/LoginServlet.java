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
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String path = request.getContextPath();
			
			request.getSession().setAttribute("name1", username);
			request.getSession().setAttribute("pass1", password);
			UserDAO userdao=new UserDAO();
			int oldid=userdao.findid(username, password);
			request.getSession().setAttribute("oldid", oldid);
			boolean flag=userdao.findUser(username, password);
			if( flag ) {
				if(!username.equals("admin")){
					
				request.getSession().setAttribute("username", username);
				response.sendRedirect(path+"/welcome.jsp");
				}
				else{
					request.getSession().setAttribute("username", "admin");
					System.out.println("user:"+request.getSession().getAttribute("username"));
					
					request.getSession().setAttribute("username", username);
					response.sendRedirect(path+"/servlet/AdminServlet");
					}
					
			
				}
				else{
				request.getSession().setAttribute("err", "用户名或密码不正确!");
				response.sendRedirect(path+"/login.jsp");
				}
			} 

}
