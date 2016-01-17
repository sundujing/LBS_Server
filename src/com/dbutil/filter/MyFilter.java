package com.dbutil.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter
{

	public MyFilter()
	{

	}

	public void destroy()
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// 过滤用户的请求，判断是否登录
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String path = httpServletRequest.getContextPath();
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletRequest.setCharacterEncoding("utf-8");
		httpServletResponse.setCharacterEncoding("utf-8");
		String username = (String) httpServletRequest.getSession()
				.getAttribute("username");
		if (username == null)
		{
			httpServletResponse.sendRedirect(path + "/index.jsp");
		}
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	public void init(FilterConfig arg0) throws ServletException
	{

	}

}
