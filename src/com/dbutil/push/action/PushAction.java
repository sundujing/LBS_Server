package com.dbutil.push.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.push.dao.PushDao;
import com.dbutil.push.service.PushService;

public class PushAction extends HttpServlet
{
	private PushService service;
	
	public PushAction()
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
		PrintWriter out = response.getWriter();
		String latitude = request.getParameter("latitude");
		double lat=Double.parseDouble(latitude);
		latitude = new String(latitude.getBytes("iso-8859-1"), "utf-8");// ���Ĵ���
		System.out.println("-latitude->>" + latitude);
		String longitude = request.getParameter("longitude");
		double lon=Double.parseDouble(longitude);
		System.out.println("-longitude->>" + longitude);
		//String UID = (String) request.getSession().getAttribute("UID");
		String UID=request.getParameter("UID");
		System.out.println("UID-->>" + UID);
		String action_flag = request.getParameter("action_flag");
		
		
		List<Object> params = new ArrayList<Object>();
		params.add(latitude);
		params.add(longitude);
		params.add(UID);
		if (action_flag.equals("userinterest"))
		{
			if(latitude!="4.9E-324"&&longitude!="4.9E-324")
			{
				System.out.println("latitude->"+latitude);
		List<Map<String, Object>> list= service.push(params);
		
		
		int listsize=list.size();
		
		 
		if (!list.isEmpty())
		{
		double[] d = new double[listsize];
		String[] o=new String[listsize];
			for (int i=0;i<listsize;i++)
			{
				Map<String, Object> map=(Map<String, Object>)list.get(i);
		System.out.println("OID-->>"+map.get("OID"));
		o[i]=(String) map.get("OID");//��¼��s[i]��Ӧ��OID
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
	      d[i]=s;//ѭ�����������object���û���ľ���
	      
//	      List<Object> params4 = new ArrayList<Object>();
//	      params4.add(d[i]);
//			params4.add(o[i]);
			
//			boolean flag = service.addDistance(params4);
//			System.out.println("adddistance--"+flag);
			
	      System.out.println(" d[i]=-->>"+s);
	      
		System.out.println("longitude-->>"+map.get("longitude"));
		System.out.println("proimage-->>"+map.get("proimage"));
			
			}
			double mind=d[0];
			int flag=0;
			for(int i=1;i<listsize;i++)//�õ���̾����object
			{
				if(d[i]<mind)
				{
				mind=d[i];
				flag=i;//�õ����object�ı�־λ
				}
			}
			System.out.println(o[flag]);
			out.print(o[flag]);//�������Ƽ������OID
		}
		}
		}else if (action_flag.equals("otherinterest"))
		{
			if(latitude!="4.9E-324"&&longitude!="4.9E-324")
		{
			String Oid=service.getOID(params);
			System.out.println("--Oid-->>"+Oid);
			out.print(Oid);//�û������������û�������˵ĵص��OID
			}
		}
//		else if (action_flag.equals("addDistance"))
//		{
//			addDistance(request, response);
//		}
		out.flush();
		out.close();
	}
/*	
	private void addDistance(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException
	{
		String OID = request.getParameter("OID");
		double distance =Double.parseDouble(request.getParameter("distance"));
		List<Object> params = new ArrayList<Object>();
		params.add(OID);
		params.add(distance);
		boolean flag = service.addDistance(params);
		System.out.println("adddistance--"+flag);
	}
*/	
	public void init() throws ServletException
	{
		service=new PushDao();
	}

}
