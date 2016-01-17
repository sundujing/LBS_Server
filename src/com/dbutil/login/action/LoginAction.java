package com.dbutil.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.login.service.LoginService;
import com.dbutil.login.dao.LoginDao;

public class LoginAction extends HttpServlet
{
	private LoginService service;

	public LoginAction()
	{
		super();
	}

	public void destroy()
	{
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("login"))
		{
			String username = request.getParameter("username");
			username = new String(username.getBytes("iso-8859-1"), "utf-8");// 中文处理
			System.out.println("-username->>" + username);
			String pswd = request.getParameter("pswd");
			System.out.println("-password->>" + pswd);
			String UID;
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(pswd);
			boolean flag = service.login(params);
			if (flag)
			{
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("pswd", pswd);
				UID = service.getId(params);
				System.out.println("UID-->>" + UID);
				request.getSession().setAttribute("UID", UID);
				out.print("login is success!!");
				response.sendRedirect(path + "/main.jsp");

			} else
			{
				out.print("<#LOGIN_FAIL#>登录失败，请返回重新登录");
			}
		} else if (action_flag.equals("getuid"))
		{
			String username = request.getParameter("username");
			System.out.println("-username->>" + username);
			String pswd = request.getParameter("pswd");
			System.out.println("-password->>" + pswd);
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(pswd);
			String UID;
			UID = service.getId(params);
			System.out.println("UID-->>" + UID);
			request.getSession().setAttribute("UID", UID);
			out.print(UID);
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException
	{
		service = new LoginDao();
	}

}
