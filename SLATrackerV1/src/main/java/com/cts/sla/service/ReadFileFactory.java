package com.cts.sla.service;

public class ReadFileFactory {
	
	public IFileReader getFileReader(String extension)
	{
		IFileReader readfile = null;
		if(extension == null)
		{
			return null;
		}
		if(extension.equalsIgnoreCase("CSV"))
		{
			readfile =  new CSVFileReader();
		}
		else if(extension.equalsIgnoreCase("TXT"))
		{
			//readfile =  new CSVFileReader();
		}
		
		 return readfile;
		
	}

}
