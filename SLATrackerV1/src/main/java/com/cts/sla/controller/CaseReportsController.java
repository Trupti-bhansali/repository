package com.cts.sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.sla.service.IGetCaseReportsService;
import com.cts.sla.vo.GrandRecordVO;
import com.cts.sla.vo.ReportDetailVO;

@Controller
public class CaseReportsController {

	@Autowired
	private IGetCaseReportsService getCaseReportsService;

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public void getReports(Model model) {
		System.out.println("Inside CaseReportsController::getReports");
		List<ReportDetailVO> caseDetailList=getCaseReportsService.getCaseReports();
		model.addAttribute("ownerCaseReports",caseDetailList);
		GrandRecordVO grandRecord=getCaseReportsService.getGrandRecordValues(caseDetailList);
		model.addAttribute("grandTotalRow",grandRecord);
		
	}
	
}
