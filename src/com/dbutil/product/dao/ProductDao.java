package com.dbutil.product.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dbutil.product.service.ProductService;
import com.dbutil.jdbc.JdbcUtils;

public class ProductDao implements ProductService
{

	private JdbcUtils jdbcUtils;

	public ProductDao()
	{
		jdbcUtils = new JdbcUtils();
	}

	public boolean addProduct(List<Object> params)
	{
		boolean flag = false;
		try
		{
			String sql = "insert into object(OID,proname,bcategory,scategory,latitude,longitude,proimage) values(?,?,?,?,?,?,?)";
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
	
	public Map<String, Object> update1Product(List<Object> params)
	{
		Map<String, Object> map = null;
		try
		{
			String sql = "select * from object where OID = ?";
			List<Object> params2 = new ArrayList<Object>();
			params2.add(params.get(0));// 获得OID

			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params2);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return map;
	}
	
	// 修改
	public boolean update2Product(List<Object> params)
	{
		boolean flag = false;
		try
		{
//			String sql = "insert into object(OID,proname,bcategory,scategory,latitude,longitude,proimage) values(?,?,?,?,?,?,?)";
			
			List<Object> params2 = new ArrayList<Object>();
			params2.add(params.get(1));// 获得proname
			params2.add(params.get(2));
			params2.add(params.get(3));
			params2.add(params.get(4));
			params2.add(params.get(5));
			params2.add(params.get(6));
			params2.add(params.get(0));// 获得OID
			
			System.out.println("ProductDao--update2Product--OID"+params.get(0));
			
//			String sql = "update object set proname=?,bcategory=?,scategory=?,latitude=?,longitude=? where OID=?";
			
			String sql = "update object set proname=?,bcategory=?,scategory=?,latitude=?,longitude=?,proimage=? where OID=?";
			
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params2);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return flag;
		
	}

	
	// 提取产品的信息
	public List<Map<String, Object>> listProduct(List<Object> params)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		String sql = "select OID,proname,bcategory,scategory,latitude,longitude,proimage,distance from object where (1=1)";
		
		String sql = "select * from object where (1=1)";
		StringBuffer buffer = new StringBuffer(sql);
		buffer.append(" and proname like ?");
		buffer.append(" and bcategory like ?");
		buffer.append(" and scategory like ?");
//		buffer.append(" group by distance order by distance ASC " );
		buffer.append("limit ?,?");
		
		try
		{
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(buffer.toString(), params);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return list;
	}

	public int getItemCount()
	{
		int result = 0;
		Map<String, Object> map = null;
		String sql = "select count(*) mycount from object";
		try
		{
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, null);
			result = Integer.parseInt(map.get("mycount").toString());

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return result;
	}

	public boolean delProduct(String[] ids)
	{
		boolean flag = false;
		try
		{
			jdbcUtils.getConnection();
			String[] sql = new String[ids.length];
			if (ids != null)
			{
				for (int i = 0; i < ids.length; i++)
				{
					sql[i] = "delete from object where OID= '" + ids[i] + "'";
				}
			}
			flag = jdbcUtils.deleteByBatch(sql);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return flag;
	}

	public Map<String, Object> viewProduct(List<Object> params)
	{
		Map<String, Object> map = null;
		try
		{
			String sql = "select * from object where OID = ?";
			List<Object> params2 = new ArrayList<Object>();
			params2.add(params.get(1));

			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params2);
			System.out.println("UID-->>" + params.get(0));//
			
			
			List<Object> params1 = new ArrayList<Object>();
			String bcategory = (String) map.get("bcategory");
			System.out.println("bcategory-->>" + bcategory);
			String scategory = (String) map.get("scategory");
			System.out.println("scategory-->>" + scategory);
			double latitude = (Double) map.get("latitude");
			System.out.println("latitude-->>" + latitude);
			double longitude = (Double) map.get("longitude");
			System.out.println("longitude-->>" + longitude);
			java.util.Date a = new java.util.Date();
			System.out.println("a-->>" + a);
			java.sql.Timestamp date = new java.sql.Timestamp(a.getTime());
			System.out.println("d-->>" + date);
			params1.add(params.get(0));
			params1.add(params.get(1));
			params1.add(bcategory);
			params1.add(scategory);
		//	params1.add(latitude);
		//	params1.add(longitude);
			params1.add(date);
			System.out.println("params1--->>" + params1);
	//		String sql1 = "insert into record(UID,OID,bcategory,scategory,latitude,longitude,date) values(?,?,?,?,?,?,?)";
			String sql1 = "insert into record(UID,OID,bcategory,scategory,date) values(?,?,?,?,?)";

			jdbcUtils.getConnection();
			boolean flag = jdbcUtils.updateByPreparedStatement(sql1, params1);
		} catch (Exception e)
		{
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return map;
	}
	
	public boolean updateall(List<Object> params)
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

	public List<Map<String, Object>> selectall()
	{
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		try
		{
		String sql = "select * from object";
		jdbcUtils.getConnection();
		list = jdbcUtils.findMoreResult(sql, null);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jdbcUtils.releaseConnection();
		}
		return list;
	}
}
