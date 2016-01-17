package com.dbutil.login.dao;

import java.util.List;
import java.util.Map;

import com.dbutil.login.service.LoginService;
import com.dbutil.jdbc.JdbcUtils;

public class LoginDao implements LoginService
{

	private static JdbcUtils jdbcUtils =null;
	public LoginDao()
	{
		jdbcUtils =new JdbcUtils();
	}

	public boolean login(List<Object> params)
	{
		boolean flag=false;
		String sql="select * from user where username=? and pswd =?";
		try
		{
			jdbcUtils.getConnection();
			Map<String, Object> map=jdbcUtils.findSimpleResult(sql, params);
			flag= !map.isEmpty()?true:false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConnection();
		}
		return flag;
	}

	public String getId(List<Object> params)
	{
		String UID = null;
		String sql="select * from user where username=? and pswd =?";
		try
		{
			jdbcUtils.getConnection();
			Map<String, Object> map=jdbcUtils.findSimpleResult(sql, params);
			UID=(String)map.get("UID");
			System.out.println("UID->>"+UID+"username-->>");
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConnection();
		}
		return UID;
	}

}
