package com.coco.wust4coco.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)arg0;
        HttpServletResponse resp =(HttpServletResponse) arg1;
        HttpSession session = req.getSession();
		
        String path = req.getRequestURI();
        System.out.println("path:"+path);
        String username = (String) session.getAttribute("username");
        System.out.println("session:"+username);
       
        if(path.indexOf("/login.html") > -1||path.endsWith("index.html")||path.endsWith("wust4CoCo/")) {
        	
        	arg2.doFilter(req, resp);
        	 return;
        }
        else{
        	if(username==null)
        	resp.sendRedirect("http://127.0.0.1:8080/wust4CoCo/login.html");
        	else if(username=="cocoadmin")
        		resp.sendRedirect("http://127.0.0.1:8080/wust4CoCo/admincoco.html");
        	else
        		resp.sendRedirect("http://127.0.0.1:8080/wust4CoCo/index.html?username="+username);
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		

	}

}
