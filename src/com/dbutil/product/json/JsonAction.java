package com.dbutil.product.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.product.dao.ProductDao;
import com.dbutil.product.json.JsonTools;
import com.dbutil.product.service.ProductService;

public class JsonAction extends HttpServlet
{

	private ProductService service;

	public JsonAction()
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("single"))
		{
			String proid = request.getParameter("OID");
			String UID = request.getParameter("UID");
			
//			String UID = (String) request.getSession().getAttribute("UID");
			List<Object> params = new ArrayList<Object>();
			params.add(UID);
			params.add(proid);
			Map<String, Object> map = service.viewProduct(params);
			String jsonString = JsonTools.createJsonString("object", map);
			out.print(jsonString);
		} else if (action_flag.equals("more"))
		{
			String proname = (request.getParameter("proname") == null ? ""
					: request.getParameter("proname"));
			String bcategory = (request.getParameter("bcategory") == null ? ""
					: request.getParameter("bcategory"));
			String scategory = (request.getParameter("scategory") == null ? ""
					: request.getParameter("scategory"));
			int start = 0;
			int end = 100;
			List<Object> params = new ArrayList<Object>();
			params.add("%" + proname + "%");
			params.add("%" + bcategory + "%");
			params.add("%" + scategory + "%");
			params.add(start);
			params.add(end);
			List<Map<String, Object>> list = service.listProduct(params);
			String jsonString = JsonTools.createJsonString("objects", list);
			out.println(jsonString);
			
		} else if (action_flag.equals("view"))
		{
			String OID = (request.getParameter("OID") == null ? "" : request
					.getParameter("OID"));
			String UID = (request.getParameter("UID") == null ? "" : request
					.getParameter("UID"));
			System.out.println("UID-->>!!" + UID);
			List<Object> params = new ArrayList<Object>();
			params.add(UID);
			params.add(OID);
			Map<String, Object> map = service.viewProduct(params);
			String jsonString = JsonTools.createJsonString("user", map);
			out.println(jsonString);
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException
	{
		service = new ProductDao();
	}

}
