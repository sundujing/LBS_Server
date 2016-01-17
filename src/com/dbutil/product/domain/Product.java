package com.dbutil.product.domain;

public class Product
{

	private String OID;
	private String proname;
	private String bcategory;
	private String scategory;
	private double latitude;
	private double longitude;
	private String proimage;

	public Product()
	{

	}

	public Product(String OID, String proname, String bcategory,
			String scategory, double latitude, double longitude, String proimage)
	{
		super();
		this.OID = OID;
		this.proname = proname;
		this.bcategory = bcategory;
		this.scategory = scategory;
		this.latitude = latitude;
		this.longitude = longitude;
		this.proimage = proimage;
	}

	public String getOID()
	{
		return OID;
	}

	public void setOID(String oid)
	{
		OID = oid;
	}

	public String getProname()
	{
		return proname;
	}

	public void setProname(String proname)
	{
		this.proname = proname;
	}

	public String getBcategory()
	{
		return bcategory;
	}

	public void setBcategory(String bcategory)
	{
		this.bcategory = bcategory;
	}

	public String getScategory()
	{
		return scategory;
	}

	public void setScategory(String scategory)
	{
		this.scategory = scategory;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public String getProimage()
	{
		return proimage;
	}

	public void setProimage(String proimage)
	{
		this.proimage = proimage;
	}

	@Override
	public String toString()
	{
		return "Object [OID=" + OID + ", proname=" + proname + ", bcategory="
				+ bcategory + "scategory=" + scategory + "latitude=" + latitude
				+ "longitude=" + longitude + ",proimage=" + proimage + ",]";
	}

}
