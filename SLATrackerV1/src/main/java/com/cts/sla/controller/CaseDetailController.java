package com.cts.sla.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "/loadFile", method = RequestMethod.POST)
	public String loadFile(@ModelAttribute("uploadForm")FileUpload uploadForm, Model map) {
		System.out.println("Inside CaseDetailController::loadFileS");
		List<MultipartFile> uploadFiles = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != uploadFiles && uploadFiles.size() > 0)
		{
			for (MultipartFile multipartFile : uploadFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if(fileName != null && ! fileName.isEmpty() )
				{
					fileNames.add(fileName);
					ticketFeederService.saveorUpdateCaseDetail(multipartFile);
				}
				else
				{
					System.err.println("File is not valid");
				}
				
		}
		
		System.out.println("Successfully updated");
		
		}
		map.addAttribute("files", fileNames);
		return "uploadfilesuccess";
	}
}
