package com.dbutil.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService
{
	public boolean addProduct(List<Object> params);
	public boolean updateall(List<Object> params);
	public List<Map<String, Object>> selectall();
	// 提取所有产品的信息 public List<Map<String, Object>> listProduct();
	public List<Map<String, Object>> listProduct(List<Object> params);// 接收用户录入的产品名字

	public int getItemCount();

	public boolean delProduct(String[] ids);
	
	public Map<String, Object> update1Product(List<Object> params);
	
	public boolean update2Product(List<Object> params);

	public Map<String, Object> viewProduct(List<Object> params);
}
