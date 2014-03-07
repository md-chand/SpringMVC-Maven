package com.springmvc.bigfileupload;

import java.util.concurrent.Callable;

public class ProcessCSVFileRecord implements Callable<AirportModel>
{

	private String record;
	public ProcessCSVFileRecord(String record)
	{
		this.record = record;
	}
	@Override
	public AirportModel call() throws Exception
	{
		AirportModel airportModel = FileUploadUtils.fromRecordToModel(record);
		//Call validations here		
		return airportModel;
	}
	
}
