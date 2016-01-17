package com.dbutil.register.dao;

import java.util.List;

import com.dbutil.jdbc.JdbcUtils;
import com.dbutil.register.service.RegisterService;

public class RegisterDao implements RegisterService
{

	private JdbcUtils utils = null;

	public RegisterDao()
	{
		utils = new JdbcUtils();

	}

	/**
	 * 完成了对用户注册的dao的编写
	 */
	public boolean registerUser(List<Object> params)
	{
		boolean flag = false;

		String sql = "insert into user(UID,username,pswd,age) values(?,?,?,?)";

		try
		{
			utils.getConnection();
			flag = utils.updateByPreparedStatement(sql, params);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{// 关闭数据库的连接
			utils.releaseConnection();
		}
		return flag;
	}

}
