package com.dbutil.product.util;

public class DividePage
{

	private int pageSize;// 表示显示的条数
	private int recordCount;// 表示记录的总条数
	private int currentPage;// 表示当前页

	public DividePage(int pageSize, int recordCount, int currentPage)
	{
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		setCurrentPage(currentPage);
	}

	public DividePage(int pageSize, int recordCount)
	{
		this(pageSize, recordCount, 1);
	}

	// 获得总页数
	public int getPageCount()
	{
		int size = recordCount / pageSize;
		int mode = recordCount % pageSize;
		if (mode != 0)
		{
			size++;
		}
		return recordCount == 0 ? 1 : size;
	}

	// 取出包含的记录条数
	public int getFromIndex()
	{
		return (currentPage - 1) * pageSize;
	}

	public int getToIndex()
	{
		return pageSize;
	}

	public int getcurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		int validPage = currentPage <= 0 ? 1 : currentPage;
		validPage = validPage > getPageCount() ? getPageCount() : validPage;
		this.currentPage = validPage;

	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getRecordCount()
	{
		return recordCount;
	}

	public void setRecordCount(int recordCount)
	{
		this.recordCount = recordCount;
	}

}
