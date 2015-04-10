package com.cts.sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.sla.model.FileUpload;
import com.cts.sla.service.ITicketFeederService;

@Controller
public class CaseDetailController {

	@Autowired
	private ITicketFeederService ticketFeederService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String displayForm() {
		return "uploadfile";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String loadFile(@ModelAttribute("uploadForm")FileUpload uploadForm, Model map) {
		System.out.println("Inside CaseDetailController::loadFileS");
		
		List<String> fileNames = ticketFeederService.saveorUpdateCaseDetail(uploadForm.getFiles());
		map.addAttribute("files", fileNames);
		return "uploadfilesuccess";
	}
}
