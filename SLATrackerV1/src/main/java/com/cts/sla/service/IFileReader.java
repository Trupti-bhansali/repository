package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;

public interface IFileReader {

	public List<CaseDetail> read(MultipartFile file) throws FileNotFoundException, IOException;
}
