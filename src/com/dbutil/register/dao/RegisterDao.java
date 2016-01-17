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
	 * ����˶��û�ע���dao�ı�д
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
		{// �ر����ݿ������
			utils.releaseConnection();
		}
		return flag;
	}

}
