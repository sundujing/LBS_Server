package com.dbutil.login.service;

import java.util.List;

public interface LoginService
{
	public boolean login(List<Object> params);

	public String getId(List<Object> params);
}
