package com.springmvc.bigfileupload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BasicFileDataProcessing
{
	public static Queue<AirportModel> AITPORT_MODEL_QUEUE = new LinkedList<AirportModel>();

	public static void main(String[] arg)
	{
		BufferedReader bufferedReader = null;
		long startTime = System.currentTimeMillis();
		try
		{
			InputStream inputStream = UploadBigFileData.class.getClassLoader().getResourceAsStream("airports.csv");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String record;
			bufferedReader.readLine();//To skip header
			while ((record = bufferedReader.readLine()) != null)
			{
				AirportModel airportModel = FileUploadUtils.fromRecordToModel(record);
				AITPORT_MODEL_QUEUE.add(airportModel);
			}
			System.out.println("Total records read: " + AITPORT_MODEL_QUEUE.size());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			System.err.println("Total Time taken: " + (System.currentTimeMillis() - startTime));
			try
			{
				if (bufferedReader != null)
					bufferedReader.close();
			} 
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
