package com.cts.sla.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.cts.sla.model.CaseDetail;

public interface IFileReader {

	public List<CaseDetail> read(File file) throws FileNotFoundException, IOException;
}
