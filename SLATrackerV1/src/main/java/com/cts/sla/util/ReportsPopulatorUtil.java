package com.cts.sla.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.vo.GrandRecordVO;
import com.cts.sla.vo.ReportDetailVO;

@Service
public class ReportsPopulatorUtil {

	public List<ReportDetailVO> populateReportsVOForOwner(List<CaseDetail> caseDetailList) {
		Map<String,ReportDetailVO> ownerReportDetailMap=createOwnerMap(caseDetailList);
		List<ReportDetailVO> reportDetailVOs=null;
		if(ownerReportDetailMap.size()>0){
			reportDetailVOs=new ArrayList<ReportDetailVO>();
		}
		for(Entry<String, ReportDetailVO> entry:ownerReportDetailMap.entrySet()){
			reportDetailVOs.add(entry.getValue());
		}
		
		return reportDetailVOs;

	}
	
	public Map<String,ReportDetailVO> createOwnerMap(List<CaseDetail> caseDetailList){
		Map<String, ReportDetailVO> reportsMap = new HashMap<String, ReportDetailVO>();
		for (CaseDetail caseDetail : caseDetailList) {
			if (reportsMap.get(caseDetail.getOwner()) != null) {
				ReportDetailVO reportDetailVO = reportsMap.get(caseDetail.getOwner());
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
				reportsMap.put(caseDetail.getOwner(), reportDetailVO);

			} else {
				ReportDetailVO reportDetailVO = new ReportDetailVO();
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
				reportDetailVO.setReportName(caseDetail.getOwner());
				reportDetailVO.setAlreadyBreached(breached);
				reportDetailVO.setBreachingToday(breachingToday);
				reportDetailVO.setYetToBeBreached(yetToBeBreached);
				reportDetailVO.setGrandTotal(reportDetailVO
						.getAlreadyBreached()
						+ reportDetailVO.getBreachingToday()
						+ reportDetailVO.getYetToBeBreached());
				reportsMap.put(caseDetail.getOwner(), reportDetailVO);
			}

		}
		return reportsMap;
	}

	public GrandRecordVO populateGrandRecordVOForOwner(
			List<ReportDetailVO> caseDetailList) {
		int grandTotalAlreadyBreached=0;
		int grandTotalBreachingToday=0;
		int grandTotalYetToBeBreached=0;
		int grandTotalGrandTotal=0;
		if(caseDetailList != null)
		{
		for (ReportDetailVO reportDetailVO : caseDetailList) {
			grandTotalAlreadyBreached+=reportDetailVO.getAlreadyBreached();
			grandTotalBreachingToday+=reportDetailVO.getBreachingToday();
			grandTotalGrandTotal+=reportDetailVO.getGrandTotal();
			grandTotalYetToBeBreached+=reportDetailVO.getYetToBeBreached();
		}
		}
		GrandRecordVO grandRecordVO=new GrandRecordVO();
		grandRecordVO.setGrandRecordAlreadyBreached(grandTotalAlreadyBreached);
		grandRecordVO.setGrandRecordBreachingToday(grandTotalBreachingToday);
		grandRecordVO.setGrandRecordGrandTotal(grandTotalGrandTotal);
		grandRecordVO.setGrandRecordName("Grand Total");
		grandRecordVO.setGrandRecordYetToBeBreached(grandTotalYetToBeBreached);
		return grandRecordVO;
	}

}
