package com.tylt.filter;

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

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		if (req.getServletPath().equals("/LoginServlet") || req.getServletPath().equals("/RegisterServlet")
				|| req.getServletPath().equals("/VerifyCodeServlet")|| !req.getServletPath().endsWith("Servlet")) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = req.getSession();
		Object userIdObject = session.getAttribute("USERID");

		if (userIdObject == null) {
			res.sendRedirect("login.jsp");
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
