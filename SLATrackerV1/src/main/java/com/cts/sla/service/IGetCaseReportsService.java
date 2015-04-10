package com.cts.sla.service;

import java.util.List;

import com.cts.sla.model.GrandRecord;
import com.cts.sla.model.ReportDetail;

public interface IGetCaseReportsService {
	
	public List<ReportDetail> getOwnerReports();

	public List<ReportDetail> getQueueReports();
	
	public List<ReportDetail> getStatusReports();
	
	public GrandRecord getGrandRecordValues( List<ReportDetail> caseDetailList);

}
