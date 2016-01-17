package com.dbutil.push.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dbutil.jdbc.JdbcUtils;
import com.dbutil.push.service.PushService;

public class PushDao implements PushService
{

	private static JdbcUtils jdbcUtils =null;
	public PushDao()
	{
		jdbcUtils =new JdbcUtils();
	}
	public List<Map<String, Object>> push(List<Object> params)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		try
		{
			String sql = "select bcategory,count(bcategory)from record where UID=? group by bcategory order by 2 DESC,1 limit 1";
			String sql1 = "select scategory,count(scategory)from record where UID=? group by scategory order by 2 DESC,1 limit 1";

			
			List<Object> params2 = new ArrayList<Object>();
			params2.add(params.get(2));

			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params2);
			String bcategory = (String) map.get("bcategory");
			System.out.println("bcategory-->>" + bcategory);
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql1, params2);
			String scategory = (String) map.get("scategory");
			System.out.println("scategory-->>" + scategory);//记录用户的喜好bcategory，scategory
			
			String sql2 = "select * from object where (1=1)";
			StringBuffer buffer = new StringBuffer(sql2);
			buffer.append(" and bcategory like ?");
			buffer.append(" and scategory like ?");
			List<Object> params1 = new ArrayList<Object>();
			params1.add(bcategory);
			params1.add(scategory);
				jdbcUtils.getConnection();
				list = jdbcUtils.findMoreResult(buffer.toString(), params1);//返回在object表中，用户感兴趣的bcategory+scategory的产品信息
			
//				System.out.println("latitude-->>" + params.get(0));
//				System.out.println("longitude-->>" + params.get(1));
				
		} catch (Exception e)
		{
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return list;
	}
	
	public String getOID(List<Object> params)
	{
		String OID = null;
		String sql="select * from user where username=? and pswd =?";
		try
		{
			List<Object> params3 = new ArrayList<Object>();
			params3.add(params.get(0));
			params3.add(params.get(0));
			params3.add(params.get(1));
			params3.add(params.get(1));
			String sql3="select  record.OID,count(record.OID)from object,record where object.OID=record.OID and latitude>?*0.95 and latitude<?*1.05 and longitude>?*0.95 and longitude<?*1.05 group by record.OID order by 2 desc,1 limit 1";
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql3, params3);
			OID=(String) map.get("OID");
			System.out.println(OID);
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConnection();
		}
		return OID;
	}
/*	
	public boolean addDistance(List<Object> params)
	{
		boolean flag = false;
		try
		{
			String sql = "update object set distance =? where OID=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return flag;
	}
*/
}
