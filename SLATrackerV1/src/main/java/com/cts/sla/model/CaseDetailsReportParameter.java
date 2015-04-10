package com.cts.sla.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CaseDetailsReportParameter {

	List<CaseDetail> caseDetails;

	public CaseDetailsReportParameter() {
		super();
	}

	public CaseDetailsReportParameter(List<CaseDetail> caseDetails) {
		super();
		this.caseDetails = caseDetails;
	}
	
	public List<ReportDetail> getOwnerReport() {

		Map<String,ReportDetail> ownerReportDetailMap=createReportMap(ReportParameter.Owner);
		List<ReportDetail> reportDetailVOs=null;
		if(ownerReportDetailMap.size()>0){
			reportDetailVOs=new ArrayList<ReportDetail>();
		}
		for(Entry<String, ReportDetail> entry:ownerReportDetailMap.entrySet()){
			reportDetailVOs.add(entry.getValue());
		}
		
		return reportDetailVOs;
	}

	public List<ReportDetail> getQueueReport() {
		Map<String,ReportDetail> queueReportDetailMap=createReportMap(ReportParameter.Queue);
		List<ReportDetail> reportDetailVOs=null;
		if(queueReportDetailMap.size()>0){
			reportDetailVOs=new ArrayList<ReportDetail>();
		}
		for(Entry<String, ReportDetail> entry:queueReportDetailMap.entrySet()){
			reportDetailVOs.add(entry.getValue());
		}
		
		return reportDetailVOs;
	}

	public List<ReportDetail> getStatusReport() {

		Map<String,ReportDetail> statusReportDetailMap=createReportMap(ReportParameter.Status);
		List<ReportDetail> reportDetailVOs=null;
		if(statusReportDetailMap.size()>0){
			reportDetailVOs=new ArrayList<ReportDetail>();
		}
		for(Entry<String, ReportDetail> entry:statusReportDetailMap.entrySet()){
			reportDetailVOs.add(entry.getValue());
		}
		return reportDetailVOs;
	}

	public GrandRecord getGrandRecordVO(List<ReportDetail> caseDetailList) {
		
		int grandTotalAlreadyBreached=0;
		int grandTotalBreachingToday=0;
		int grandTotalYetToBeBreached=0;
		int grandTotalGrandTotal=0;
		if(caseDetailList != null)
		{
		for (ReportDetail reportDetailVO : caseDetailList) {
			grandTotalAlreadyBreached+=reportDetailVO.getAlreadyBreached();
			grandTotalBreachingToday+=reportDetailVO.getBreachingToday();
			grandTotalGrandTotal+=reportDetailVO.getGrandTotal();
			grandTotalYetToBeBreached+=reportDetailVO.getYetToBeBreached();
		}
		}
		GrandRecord grandRecordVO=new GrandRecord();
		grandRecordVO.setGrandRecordAlreadyBreached(grandTotalAlreadyBreached);
		grandRecordVO.setGrandRecordBreachingToday(grandTotalBreachingToday);
		grandRecordVO.setGrandRecordGrandTotal(grandTotalGrandTotal);
		grandRecordVO.setGrandRecordName("Grand Total");
		grandRecordVO.setGrandRecordYetToBeBreached(grandTotalYetToBeBreached);
		return grandRecordVO;
	
	}


	private Map<String, ReportDetail> createReportMap(ReportParameter inputParameter) {
		Map<String, ReportDetail> reportsMap = new HashMap<String, ReportDetail>();
		
		String value = null ;
		for (CaseDetail caseDetail : caseDetails) {

			
			if (inputParameter.equals(ReportParameter.Status)) {
				value = caseDetail.getCaseStatus();
			} else if (inputParameter.equals(ReportParameter.Owner)) {
				value = caseDetail.getOwner();
			} else if (inputParameter.equals(ReportParameter.Queue)) {
				value = caseDetail.getQueue();
			}
			
			if (reportsMap.get(value) != null) {
				ReportDetail reportDetailVO = reportsMap.get(value);
				String slaStatus = caseDetail.getSLAStatus();
				int breached = reportDetailVO.getAlreadyBreached();
				int breachingToday = reportDetailVO.getBreachingToday();
				int yetToBeBreached = reportDetailVO.getYetToBeBreached();
				switch (slaStatus) {
				case "Breached": {
					breached++;
					break;
				}
				case "About_To_Breach": {
					yetToBeBreached++;
					break;
				}
				case "Breach": {
					breachingToday++;
					break;
				}
				}
				reportDetailVO.setAlreadyBreached(breached);
				reportDetailVO.setBreachingToday(breachingToday);
				reportDetailVO.setYetToBeBreached(yetToBeBreached);
				reportDetailVO.setGrandTotal(reportDetailVO
						.getAlreadyBreached()
						+ reportDetailVO.getBreachingToday()
						+ reportDetailVO.getYetToBeBreached());
				reportsMap.put(caseDetail.getCaseStatus(), reportDetailVO);

			} else {
				ReportDetail reportDetailVO = new ReportDetail();
				String slaStatus = caseDetail.getSLAStatus();
				int breached = 0;
				int breachingToday = 0;
				int yetToBeBreached = 0;
				switch (slaStatus) {
				case "Breached": {
					breached++;
					break;
				}
				case "About_To_Breach": {
					yetToBeBreached++;
					break;
				}
				case "Breach": {
					breachingToday++;
					break;
				}
				}
				reportDetailVO.setReportName(value);
				reportDetailVO.setAlreadyBreached(breached);
				reportDetailVO.setBreachingToday(breachingToday);
				reportDetailVO.setYetToBeBreached(yetToBeBreached);
				reportDetailVO.setGrandTotal(reportDetailVO.getAlreadyBreached()
						+ reportDetailVO.getBreachingToday()
						+ reportDetailVO.getYetToBeBreached());
				reportsMap.put(value, reportDetailVO);
			}

		}
		return reportsMap;
	}
	
	public GrandRecord populateGrandRecordVOForOwner(
			List<ReportDetail> caseDetailList) {
		int grandTotalAlreadyBreached=0;
		int grandTotalBreachingToday=0;
		int grandTotalYetToBeBreached=0;
		int grandTotalGrandTotal=0;
		if(caseDetailList != null)
		{
		for (ReportDetail reportDetailVO : caseDetailList) {
			grandTotalAlreadyBreached+=reportDetailVO.getAlreadyBreached();
			grandTotalBreachingToday+=reportDetailVO.getBreachingToday();
			grandTotalGrandTotal+=reportDetailVO.getGrandTotal();
			grandTotalYetToBeBreached+=reportDetailVO.getYetToBeBreached();
		}
		}
		GrandRecord grandRecordVO=new GrandRecord();
		grandRecordVO.setGrandRecordAlreadyBreached(grandTotalAlreadyBreached);
		grandRecordVO.setGrandRecordBreachingToday(grandTotalBreachingToday);
		grandRecordVO.setGrandRecordGrandTotal(grandTotalGrandTotal);
		grandRecordVO.setGrandRecordName("Grand Total");
		grandRecordVO.setGrandRecordYetToBeBreached(grandTotalYetToBeBreached);
		return grandRecordVO;
	}
	

	enum ReportParameter
	{
		Status("Status"),
		Owner ("Owner"),
		Queue ("Queue");
		
		private String reportParameter;
		
		private ReportParameter(String reportParameter) {
			this.reportParameter = reportParameter;
		}
		
		String getReportParameter()
		{
			return reportParameter;
		}
	}
}
