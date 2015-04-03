package com.cts.sla.service;

import java.util.List;

import com.cts.sla.vo.GrandRecordVO;
import com.cts.sla.vo.ReportDetailVO;

public interface IGetCaseReportsService {
	
	public List<ReportDetailVO> getCaseReports();

	public GrandRecordVO getGrandRecordValues(
			List<ReportDetailVO> caseDetailList);

}
