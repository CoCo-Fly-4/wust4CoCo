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

public class LoginFilter implements Filter {    //普通用户filter

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
        String Path=req.getContextPath();
        String path = req.getRequestURI();
        System.out.println("path:"+path);
        String username = (String) session.getAttribute("username");
        if(username==null)
        	username="null";
        System.out.println("session:"+username);
	
         if(path.endsWith("/wust4CoCo"))
        	 resp.sendRedirect(Path+"/index.html");
         else if(path.endsWith("index.html")&&username.equals("cocoadmin"))
        		resp.sendRedirect(Path+"/admincoco.html");
        	else
        		arg2.doFilter(req, resp);
        
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("进入LoginFilter");

	}

}
