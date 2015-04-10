package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;
@Service(value = "fileReaderService")
public class FileReaderServiceImpl implements IFileReaderService {
	
	@Override
	public List<CaseDetail> readFile(MultipartFile file) {
		List<CaseDetail> caseDetailList = null;
		ReadFileFactory readFileFactory = new ReadFileFactory();
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		IFileReader reader = readFileFactory.getFileReader(fileExtension);
		if (reader != null) {
			try {
				caseDetailList = reader.read(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return caseDetailList;
	}

}
