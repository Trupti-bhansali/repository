package com.cts.sla.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;

public interface ITicketFeederService {

	public List<CaseDetail> saveorUpdateCaseDetail(MultipartFile file);

	public CaseDetail saveorUpdateCaseDetail(CaseDetail caseDetail);

	public List<CaseDetail> saveorUpdateCaseDetail(List<CaseDetail> caseDetails);
	
}
