package com.cts.sla.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cts.sla.model.CaseDetail;


public interface IFileReaderService {
	

		public List<CaseDetail> readFile(File file) throws FileNotFoundException,
		 IOException, ParseException;

		List<CaseDetail> readFile() throws FileNotFoundException, IOException, ParseException;
	}


