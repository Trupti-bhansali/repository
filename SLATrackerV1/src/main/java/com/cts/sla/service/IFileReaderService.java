package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.NotSupportedException;

import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;


public interface IFileReaderService {
	
		List<CaseDetail> readFile(MultipartFile file)
				throws FileNotFoundException, IOException, ParseException, NotSupportedException;
	}


