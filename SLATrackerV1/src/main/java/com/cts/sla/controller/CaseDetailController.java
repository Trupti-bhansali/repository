package com.cts.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.sla.service.ITicketFeederService;

@Controller
public class CaseDetailController {

	@Autowired
	private ITicketFeederService ticketFeederService;

	@RequestMapping(value = "/loadFile", method = RequestMethod.GET)
	public void loadFile() {
		System.out.println("Inside CaseDetailController::loadFileS");
		ticketFeederService.saveorUpdateCaseDetail();
		System.out.println("Successfully updated");
	}

}
