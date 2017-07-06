package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import beans.User;

public class RegServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			//response.setContentType("text/html");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println("username:"+username);
			System.out.println("password:"+password);
			String path = request.getContextPath(); //获取请求路径
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDAO userdao=new UserDAO();
			
			/*if( userdao.isUsernameExists(username) ){
                     request.getSession().setAttribute("err", "用户名已存在");
                     response.sendRedirect(path+"/register.html");
                   }
			else{
				boolean flag=userdao.addUser(user);
				if(flag){
				request.getSession().setAttribute("username", username);
				response.sendRedirect(path+"/welcome.html");
				}
				else{
				request.getSession().setAttribute("err", "注册失败");
				response.sendRedirect(path+"/register.html");
				}
				}*/
			boolean flag=userdao.addUser(user);
			String s=new String();
			if(flag){
			request.getSession().setAttribute("username", username);
			
			s="success";
			}
			else
			{
				 s="Failed Register";
				
			}
			response.getWriter().append(s);
			} // end service


	
}	