package com.cts.sla.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.cts.sla.model.CaseDetail;

public class TXTFileReader implements IFileReader {

	@Override
	public List<CaseDetail> read(File file) throws FileNotFoundException,
			IOException {
		return getSLACaseDetailsFromTXT(file);
	}

	private List<CaseDetail> getSLACaseDetailsFromTXT(File file) {

		return null;
	}

}
