package com.dbutil.product.json;

import net.sf.json.JSONObject;

public class JsonTools
{

	public JsonTools()
	{
	}

	/**
	 * 
	 * @param key
	 *            ��ʾjson�ַ�����ͷ��Ϣ
	 * @param object
	 *            �ǶԽ����ļ��ϵ�����
	 * @return
	 */
	public static String createJsonString(String key, Object object)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, object);
		return jsonObject.toString();

	}

}
