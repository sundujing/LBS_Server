package com.dbutil.product.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dbutil.product.service.ProductService;
import com.dbutil.product.util.UUIDTools;
import com.dbutil.product.dao.ProductDao;
import com.dbutil.product.util.DividePage;

public class ProductAction extends HttpServlet
{

	private ProductService service;

	public ProductAction()
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
		if (action_flag.equals("add"))
		{
			addProduct(request, response);
		} else if (action_flag.equals("list"))
		{
			listProduct(request, response);
		} else if (action_flag.equals("del"))
		{
			delProduct(request, response);
		} else if (action_flag.equals("view"))
		{
			viewProduct(request, response);
		} else if (action_flag.equals("update"))
		{
			updateProduct(request, response);
		}
		else if (action_flag.equals("update1"))// update查看
		{
			update1Product(request, response);
		}
		else if (action_flag.equals("update2"))// update提交
		{
			update2Product(request, response);
		}

		out.flush();
		out.close();
	}



	private void updateProduct(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException
	{
		String latitude = request.getParameter("latitude");
		double lat=Double.parseDouble(latitude);
		latitude = new String(latitude.getBytes("iso-8859-1"), "utf-8");// 中文处理
		System.out.println("-latitude->>" + latitude);
		String longitude = request.getParameter("longitude");
		double lon=Double.parseDouble(longitude);
		System.out.println("-longitude->>" + longitude);
		//String UID = (String) request.getSession().getAttribute("UID");
		String UID=request.getParameter("UID");
		System.out.println("UID-->>" + UID);
		List<Object> params = new ArrayList<Object>();
		params.add(latitude);
		params.add(longitude);
		params.add(UID);
		List<Map<String, Object>> list= service.selectall();
		int listsize=list.size();	 
		if (!list.isEmpty())
		{double[] d = new double[listsize];
		String[] o=new String[listsize];
		for (int i=0;i<listsize;i++)
		{
			Map<String, Object> map=(Map<String, Object>)list.get(i);
	System.out.println("OID-->>"+map.get("OID"));
	o[i]=(String) map.get("OID");//记录是s[i]对应的OID
	System.out.println("proname-->>"+map.get("proname"));
	System.out.println("latitude-->>"+map.get("latitude"));
	double la= (Double) map.get("latitude");
	double lo= (Double) map.get("longitude");
	double a=(la-lat)* Math.PI / 180.0;
	double b=(lo-lon)* Math.PI / 180.0;
	double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
 Math.cos(la* Math.PI / 180.0)*Math.cos(lat* Math.PI / 180.0)*Math.pow(Math.sin(b/2),2)));
	s=s* 6378137;
      s = Math.round(s * 10000) / 10000;
      d[i]=s;//循环遍历出算出object与用户间的距离
      
      List<Object> params4 = new ArrayList<Object>();
      params4.add(d[i]);
		params4.add(o[i]);
		
		boolean flag = service.updateall(params4);
		System.out.println("adddistance--"+flag);
		
      System.out.println(" d[i]=-->>"+s);
      
	System.out.println("longitude-->>"+map.get("longitude"));
	System.out.println("proimage-->>"+map.get("proimage"));
		
		}
		}
		
	}

	private void viewProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{

		String OID = request.getParameter("OID");
		String UID = (String) request.getSession().getAttribute("UID");
		System.out.println("UID-->>" + UID);
		List<Object> params = new ArrayList<Object>();
		params.add(UID);
		params.add(OID);
		Map<String, Object> map = service.viewProduct(params);
		request.setAttribute("map", map);
		String username = (String) request.getSession()
				.getAttribute("username");
		System.out.println("username-->>" + username);
		String pswd = (String) request.getSession().getAttribute("pswd");
		System.out.println("pswd-->>" + pswd);
		request.getRequestDispatcher("/product/2_1_5xs.jsp").forward(request,
				response);
	}

	private void delProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getContextPath();
		String[] ids = request.getParameterValues("ids");
		boolean flag = service.delProduct(ids);
		if (flag)
		{
			response.sendRedirect(path
					+ "/servlet/ProductAction?action_flag=list");
		}
	}
	
	// 修改查看update1，同viewProduct
	private void update1Product(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String OID = request.getParameter("OID");
		System.out.println("ProductAction--updateProduct--UID-->>" + OID);
		List<Object> params = new ArrayList<Object>();
		params.add(OID);
		Map<String, Object> map = service.update1Product(params);// 查看
		request.setAttribute("map", map);
		request.getRequestDispatcher("/product/update.jsp").forward(request,
				response);
	}

	// 修改提交update2
	private void update2Product(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String OID = request.getParameter("OID");
		System.out.println("ProductAction--update2Product--OID-->>" + OID);
		
		
		String path = request.getContextPath();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		servletFileUpload.setFileSizeMax(3 * 1024 * 1024);
		servletFileUpload.setSizeMax(6 * 1024 * 1024);
		List<Object> params = new ArrayList<Object>();
//		params.add(UUIDTools.getUUID());
		params.add(OID);
		
		try
		{
			@SuppressWarnings("unchecked")
			List<FileItem> list = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : list)
			{
				if (fileItem.isFormField())
				{
					if (fileItem.getFieldName().equals("proname"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("bcategory"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("scategory"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("latitude"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("longitude"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					
				} else
				{
					try
					{
						
						String image = fileItem.getName();
						params.add(image);
//						String upload_path = request.getRealPath("/upload");
						String upload_path = this.getServletContext().getRealPath("/upload");
						
						System.out.println("--upload_path" + upload_path);
						
						System.out.println("image" + image);
						// 将图片包装成一个file类，路径+图片名
						File real_path = new File(upload_path + "/" + image);
						
						fileItem.write(real_path);
						
						
						boolean flag = service.update2Product(params);
						
						System.out.println("--params" + params);
						System.out.println("--flag->>" + flag);
						if (flag)
						{
							response.sendRedirect(path
										+ "/servlet/ProductAction?action_flag=list");
						}
						// 把数据插入到数据库中
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}

		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
	}
	
	private void listProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// 接受查询名字
		String proname = request.getParameter("proname");
		String bcategory = request.getParameter("bcategory");
		String scategory = request.getParameter("scategory");
		int recordCount = service.getItemCount();
		int currentPage = 1;// 当前页是第一页
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null)
		{
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(5, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		// String path =request.getContextPath();//当前的根目录
		List<Object> params = new ArrayList<Object>();
		params.add("%" + proname + "%");
		params.add("%" + bcategory + "%");
		params.add("%" + scategory + "%");
		params.add(start);
		params.add(end);
		List<Map<String, Object>> list = service.listProduct(params);// 已经进行分页后的数据集合
		request.setAttribute("pUtil", pUtil);
		request.setAttribute("listproduct", list);
		request.getRequestDispatcher("/product/2_1_5.jsp").forward(request,
				response);
	}

	private void addProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{// 表单含有文件要提交
		String path = request.getContextPath();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 构建一个文件上传类
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		servletFileUpload.setFileSizeMax(3 * 1024 * 1024);
		servletFileUpload.setSizeMax(6 * 1024 * 1024);// 上传文件总大小
//		List<FileItem> list = null;
		List<Object> params = new ArrayList<Object>();
		params.add(UUIDTools.getUUID());
		try
		{// 解析request的请求
//			list = servletFileUpload.parseRequest(request);
			@SuppressWarnings("unchecked")
			List<FileItem> list =  servletFileUpload.parseRequest(request);
			
			// 取出所有表单值，判断文本字段和非文本字段
			for (FileItem fileItem : list)
			{
				if (fileItem.isFormField())
				{
					if (fileItem.getFieldName().equals("proname"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("bcategory"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("scategory"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("latitude"))
					{
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("longitude"))
					{
						params.add(fileItem.getString("utf-8"));
					}
				} else
				{
					try
					{
						String image = fileItem.getName();
						params.add(image);
//						String upload_path = request.getRealPath("/upload");
						String upload_path = this.getServletContext().getRealPath("/upload");
						
						System.out.println("--upload_path" + upload_path);
						File real_path = new File(upload_path + "/" + image);// 将图片包装成一个file类，路径+图片名
						fileItem.write(real_path);
						boolean flag = service.addProduct(params);
						System.out.println("--params" + params);
						System.out.println("--flag->>" + flag);
						if (flag)
						{
							response
									.sendRedirect(path
											+ "/servlet/ProductAction?action_flag=list");
						}
						// 把数据插入到数据库中
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}

		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
	}

	public void init() throws ServletException
	{
		service = new ProductDao();
	}

}
