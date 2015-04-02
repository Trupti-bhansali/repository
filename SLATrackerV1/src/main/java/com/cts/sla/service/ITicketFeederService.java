package com.cts.sla.service;

import java.util.List;

import com.cts.sla.model.CaseDetail;

public interface ITicketFeederService {

	public List<CaseDetail> saveorUpdateCaseDetail();

	public List<CaseDetail> saveorUpdateCaseDetails(List<CaseDetail> caseDetails);

	public CaseDetail saveorUpdateCaseDetail(CaseDetail caseDetail);

	public List<CaseDetail> saveorUpdateCaseDetail(List<CaseDetail> caseDetails);
	
	public void close();
	

}
