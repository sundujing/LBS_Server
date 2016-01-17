package com.dbutil.push.service;

import java.util.List;
import java.util.Map;

public interface PushService
{
	public List<Map<String, Object>> push(List<Object> params);
	public String getOID(List<Object> params);
//	public boolean addDistance(List<Object> params);
}
