package com.springmvc.bigfileupload;

public class FileUploadUtils
{
	public static AirportModel fromRecordToModel(String record)
	{
//		System.out.println(record);
		String[] airpordDetails = record.split(",");
		AirportModel airportModel = new AirportModel();
		if (!airpordDetails[0].isEmpty())
		{
			airportModel.setId(Long.valueOf(airpordDetails[0]));
		}
		airportModel.setCode(airpordDetails[1]);
		airportModel.setName(airpordDetails[2]);
		airportModel.setType(airpordDetails[3]);
		if (!airpordDetails[4].isEmpty())
		{
			airportModel.setLatitude(Double.valueOf(airpordDetails[4]));
		}
		if (!airpordDetails[5].isEmpty())
		{
			airportModel.setLongitude(Double.valueOf(airpordDetails[5]));
		}
		if (!airpordDetails[6].isEmpty())
		{
			airportModel.setElivation(Long.valueOf(airpordDetails[6]));
		}
		airportModel.setContinent(airpordDetails[7]);
		airportModel.setIsoCountry(airpordDetails[8]);
		airportModel.setIsoRegion(airpordDetails[9]);
		airportModel.setMunicipality(airpordDetails[10]);
		airportModel.setScheduledService(airpordDetails[11]);
		

		/*
		 * airportModel.setGpsCode(airpordDetails[12]);
		 * airportModel.setIataCode(airpordDetails[13]);
		 * airportModel.setLocalCode(airpordDetails[14]);
		 * 
		 * airportModel.setHomeLink(airpordDetails[15]);
		 * airportModel.setWikiLink(airpordDetails[16]);
		 * airportModel.setKeyword(airpordDetails[17]);
		 */

		return airportModel;
	}
}
