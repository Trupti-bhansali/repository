package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.transaction.NotSupportedException;

import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;

public class TXTFileReader implements IFileReader {

	@Override
	public List<CaseDetail> read(MultipartFile file) throws FileNotFoundException,
			IOException {
		List<CaseDetail> caseDetailList = null;
		try {
			caseDetailList = getSLACaseDetailsFromTXT(file);
		} catch (NotSupportedException e) {
			e.printStackTrace();
		}
		return caseDetailList;
	}

	private List<CaseDetail> getSLACaseDetailsFromTXT(MultipartFile file) throws NotSupportedException {

		throw new NotSupportedException();
	}

}
