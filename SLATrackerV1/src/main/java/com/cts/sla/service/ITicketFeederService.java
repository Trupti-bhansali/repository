package com.cts.sla.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;

public interface ITicketFeederService {

	public List<String> saveorUpdateCaseDetail(List<MultipartFile> file);

	public List<List<CaseDetail>> saveorUpdateCaseDetails(List<List<CaseDetail>> caseDetails);
	
}
