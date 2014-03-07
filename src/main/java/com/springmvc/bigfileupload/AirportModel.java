/**
 * 
 */
package com.springmvc.bigfileupload;

import java.io.Serializable;

/**
 * @author mpasha
 * 
 */
public class AirportModel implements Serializable
{

	private static final long serialVersionUID = 1L;

	private long id;
	private String code;
	private String name;
	private String type;
	private double latitude;
	private double longitude;
	private long elivation;
	private String continent;
	private String isoCountry;
	private String isoRegion;
	private String municipality;
	private String scheduledService;
	private String gpsCode;
	private String iataCode;
	private String localCode;
	private String homeLink;
	private String wikiLink;
	private String keyword;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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

	public long getElivation()
	{
		return elivation;
	}

	public void setElivation(long elivation)
	{
		this.elivation = elivation;
	}

	public String getContinent()
	{
		return continent;
	}

	public void setContinent(String continent)
	{
		this.continent = continent;
	}

	public String getIsoCountry()
	{
		return isoCountry;
	}

	public void setIsoCountry(String isoCountry)
	{
		this.isoCountry = isoCountry;
	}

	public String getIsoRegion()
	{
		return isoRegion;
	}

	public void setIsoRegion(String isoRegion)
	{
		this.isoRegion = isoRegion;
	}

	public String getMunicipality()
	{
		return municipality;
	}

	public void setMunicipality(String municipality)
	{
		this.municipality = municipality;
	}

	public String getScheduledService()
	{
		return scheduledService;
	}

	public void setScheduledService(String scheduledService)
	{
		this.scheduledService = scheduledService;
	}

	public String getGpsCode()
	{
		return gpsCode;
	}

	public void setGpsCode(String gpsCode)
	{
		this.gpsCode = gpsCode;
	}

	public String getIataCode()
	{
		return iataCode;
	}

	public void setIataCode(String iataCode)
	{
		this.iataCode = iataCode;
	}

	public String getLocalCode()
	{
		return localCode;
	}

	public void setLocalCode(String localCode)
	{
		this.localCode = localCode;
	}

	public String getHomeLink()
	{
		return homeLink;
	}

	public void setHomeLink(String homeLink)
	{
		this.homeLink = homeLink;
	}

	public String getWikiLink()
	{
		return wikiLink;
	}

	public void setWikiLink(String wikiLink)
	{
		this.wikiLink = wikiLink;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirportModel other = (AirportModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "AirportModel [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + ", latitude="
				+ latitude + ", longitude=" + longitude + ", elivation=" + elivation + ", continent=" + continent
				+ ", isoCountry=" + isoCountry + ", isoRegion=" + isoRegion + ", municipality=" + municipality
				+ ", scheduledService=" + scheduledService + ", gpsCode=" + gpsCode + ", iataCode=" + iataCode
				+ ", localCode=" + localCode + ", homeLink=" + homeLink + ", wikiLink=" + wikiLink + ", keyword="
				+ keyword + "]";
	}
}
