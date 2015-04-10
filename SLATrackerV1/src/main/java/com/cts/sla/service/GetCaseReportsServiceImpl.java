package com.cts.sla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.model.CaseDetailsReportParameter;
import com.cts.sla.model.GrandRecord;
import com.cts.sla.model.ReportDetail;
import com.cts.sla.repository.SLACaseRepository;
@Repository
public class GetCaseReportsServiceImpl implements IGetCaseReportsService{

	
	@Autowired
	private SLACaseRepository caseRepository;
	
	
	@Override
	public List<ReportDetail> getOwnerReports() {
		List<CaseDetail> caseDetailList=caseRepository.findAll();
		CaseDetailsReportParameter caseDetails = new CaseDetailsReportParameter(caseDetailList);
		List<ReportDetail> ownerReportDetailVOs=caseDetails.getOwnerReport();
		return ownerReportDetailVOs;
	}
	
	@Override
	public List<ReportDetail> getQueueReports() {
		List<CaseDetail> caseDetailList=caseRepository.findAll();
		CaseDetailsReportParameter caseDetails = new CaseDetailsReportParameter(caseDetailList);
		List<ReportDetail> queueReportDetailVOs=caseDetails.getQueueReport();
		return queueReportDetailVOs;
	}

	@Override
	public List<ReportDetail> getStatusReports() {
		List<CaseDetail> caseDetailList=caseRepository.findAll();
		CaseDetailsReportParameter caseDetails = new CaseDetailsReportParameter(caseDetailList);
		List<ReportDetail> statusReportDetailVOs=caseDetails.getStatusReport();
		return statusReportDetailVOs;
	}
	
	
	@Override
	public GrandRecord getGrandRecordValues(List<ReportDetail> caseDetailList) {
		CaseDetailsReportParameter caseDetails = new CaseDetailsReportParameter();
		GrandRecord grandRecordVOs = caseDetails.getGrandRecordVO(caseDetailList);
		return grandRecordVOs;
	}

}
