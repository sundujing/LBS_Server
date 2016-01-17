package com.dbutil.product.util;

import java.util.UUID;

public class UUIDTools
{

	public UUIDTools()
	{

	}

	public static String getUUID()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").substring(0, 6);

	}
}
