package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.JsonResult;
import beans.User;
import dao.UserDAO;

public class SortServlet extends HttpServlet {

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

		String[] words={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String word=request.getParameter("word");
		int num=Integer.parseInt(word);
		UserDAO userdao=new UserDAO();
		ArrayList<User> list=new ArrayList<User>();
		
		String s1=words[num-1];
		String s2=words[num];
		System.out.println(s1+"&"+s2);
		ResultSet rs=userdao.findbyword(s1, s2);
		
		if(rs!=null)
		{
			System.out.println("rs!======null");
			try {
				while(rs.next())
				{
					System.out.println(Integer.parseInt(rs.getString("id"))+" "+rs.getString("username")+" "+rs.getString("password"));
					User user=new User();
					user.setId(Integer.parseInt(rs.getString("id")));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					
					list.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("That's all !");
				e.printStackTrace();
			} 
		
		}
		else{
			System.out.println("list user null");
		}
		
		Gson gb = new Gson();
		String info=gb.toJson(list);
		response.getWriter().append(info);
	}

}
