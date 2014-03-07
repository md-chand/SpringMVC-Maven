package com.springmvc.bigfileupload;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author mpasha
 * 
 */
public class UploadBigFileData
{
	public static Queue<AirportModel> AITPORT_MODEL_QUEUE = new LinkedList<AirportModel>();
	public static boolean FILE_READ = false;
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		ExecutorService executorService = null;
		BufferedReader bufferedReader = null; 
		try
		{
			executorService = Executors.newFixedThreadPool(10);
			InputStream inputStream = UploadBigFileData.class.getClassLoader().getResourceAsStream("airports.csv");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String record = null;
			ProcessCSVFileRecord csvFileRecord = null;
			bufferedReader.readLine();//To skip header
			while ((record = bufferedReader.readLine()) != null)
			{
				csvFileRecord = new ProcessCSVFileRecord(record);
				Future<AirportModel> future = executorService.submit(csvFileRecord);
				AITPORT_MODEL_QUEUE.add(future.get());				
			}
			FILE_READ = true;
			System.out.println("Total records read: " + AITPORT_MODEL_QUEUE.size());
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.err.println("Total Time taken: " + (System.currentTimeMillis() - startTime));
			try
			{
				bufferedReader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
