package com.dbutil.register.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.product.util.UUIDTools;
import com.dbutil.register.dao.RegisterDao;
import com.dbutil.register.service.RegisterService;

public class RegisterAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;// 序列化

	private RegisterService service;

	public RegisterAction()
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
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"), "utf-8");// 中文处理
		String pswd = request.getParameter("pswd");
		String age = request.getParameter("age");
		List<Object> params = new ArrayList<Object>();
		params.add(UUIDTools.getUUID());
		params.add(username);
		params.add(pswd);
		params.add(age);
		boolean flag = service.registerUser(params);
		if (flag)
		{
			response.sendRedirect(path + "/index.jsp");
		} else
		{
			out.print("<#REGIST_FAIL#>注册失败，请返回重新注册");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException
	{
		service = new RegisterDao();
	}

}
