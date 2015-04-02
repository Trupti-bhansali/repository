package com.cts.sla.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cts.sla.model.CaseDetail;
@Service(value = "fileReaderService")
public class FileReaderServiceImpl implements IFileReaderService {

	@Value("${InputfilePath}")
	private String filePath;
	
	

	@Override
	public List<CaseDetail> readFile() throws FileNotFoundException, IOException, ParseException {
		File file = new File(filePath);
		return readFile(file);
	}
	
	@Override
	public List<CaseDetail> readFile(File file) throws FileNotFoundException, IOException, ParseException {
		ReadFileFactory readFileFactory = new ReadFileFactory();
		String fileExtension = FilenameUtils.getExtension(file.getAbsolutePath());
		IFileReader reader = readFileFactory.getFileReader(fileExtension);
		return reader.read(file);
	}

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
	{
		
//		System.out.println(System.getProperty("java.class.path"));
		FileReaderServiceImpl obj = new FileReaderServiceImpl();
		File file = new File("D:\\Amdocs\\Amdocs\\sample1.csv");
		obj.readFile(file);
	}

}
