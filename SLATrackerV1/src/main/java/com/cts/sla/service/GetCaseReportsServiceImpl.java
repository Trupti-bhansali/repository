package com.cts.sla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.repository.SLACaseRepository;
import com.cts.sla.util.ReportsPopulatorUtil;
import com.cts.sla.vo.GrandRecordVO;
import com.cts.sla.vo.ReportDetailVO;

@Repository
public class GetCaseReportsServiceImpl implements IGetCaseReportsService{

	
	@Autowired
	private SLACaseRepository caseRepository;
	
	@Autowired
	private ReportsPopulatorUtil reportsPopulatorUtil;
	
	/*@Autowired
	private FileReaderServiceImpl fileReaderService;*/
	
	@Override
	public List<ReportDetailVO> getCaseReports() {
		List<CaseDetail> caseDetailList=caseRepository.findAll();
		List<ReportDetailVO> ownerReportDetailVOs=reportsPopulatorUtil.populateReportsVOForOwner(caseDetailList);
		return ownerReportDetailVOs;
	}

	@Override
	public GrandRecordVO getGrandRecordValues(
			List<ReportDetailVO> caseDetailList) {
		GrandRecordVO grandRecordVOs=reportsPopulatorUtil.populateGrandRecordVOForOwner(caseDetailList);
		return grandRecordVOs;
	}


	

}
