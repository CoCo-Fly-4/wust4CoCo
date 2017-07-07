package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDAO;
import beans.JsonResult;
import beans.User;

public class RegServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			//response.setContentType("text/html");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println("username:"+username);
			System.out.println("password:"+password);
		
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDAO userdao=new UserDAO();
			
			ArrayList<JsonResult> result=new ArrayList<JsonResult>();
			JsonResult jr=new JsonResult();
			
			boolean flag=userdao.addUser(user);
			
			if(flag){
				jr.setString("success");
				jr.setStatus(0);
			request.getSession().setAttribute("username", username);
			}
			else
			{
				jr.setString("fail");
		    	jr.setStatus(-1);
			}
			Gson gb = new Gson();
			result.add(jr);
			String info=gb.toJson(result);
			response.getWriter().append(info);
			} // end service


	
}	