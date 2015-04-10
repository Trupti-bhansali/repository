package com.cts.sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.sla.model.GrandRecord;
import com.cts.sla.model.ReportDetail;
import com.cts.sla.service.IGetCaseReportsService;

@Controller
public class CaseReportsController {

	@Autowired
	private IGetCaseReportsService getCaseReportsService;

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public void getReports(Model model) {
		System.out.println("Inside CaseReportsController");
		List<ReportDetail> caseDetailList=getCaseReportsService.getOwnerReports();
		model.addAttribute("ownerCaseReports",caseDetailList);
		GrandRecord grandRecord=getCaseReportsService.getGrandRecordValues(caseDetailList);
		model.addAttribute("grandTotalRow",grandRecord);
		
		caseDetailList=getCaseReportsService.getQueueReports();
		model.addAttribute("queueCaseReports",caseDetailList);
		
		caseDetailList=getCaseReportsService.getStatusReports();
		model.addAttribute("statusCaseReports",caseDetailList);
		
	}
}
