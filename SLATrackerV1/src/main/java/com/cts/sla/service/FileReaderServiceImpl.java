package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;
@Service(value = "fileReaderService")
public class FileReaderServiceImpl implements IFileReaderService {
	
	@Override
	public List<CaseDetail> readFile(MultipartFile file) throws FileNotFoundException, IOException, ParseException {
		List<CaseDetail> caseDetailList = null;
		ReadFileFactory readFileFactory = new ReadFileFactory();
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		IFileReader reader = readFileFactory.getFileReader(fileExtension);
		if(reader!= null )
		{
		caseDetailList =  reader.read(file);
		}

		return caseDetailList;
	}

}
