package com.cts.sla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.repository.SLACaseRepository;

@Repository
public class TicketFeederServiceImpl implements ITicketFeederService{

	
	@Autowired
	private SLACaseRepository caseRepository;
	
	@Autowired
	private FileReaderServiceImpl fileReaderService;
	
	@Transactional
	@Override
	public List<String> saveorUpdateCaseDetail(List<MultipartFile> uploadFiles) {

		List<String> fileNames = new ArrayList<String>();
		if (null != uploadFiles && uploadFiles.size() > 0) {
			List<List<CaseDetail>> casedetails = new ArrayList<List<CaseDetail>>();
			
			for (MultipartFile multipartFile : uploadFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if (fileName != null && !fileName.isEmpty()) {
					fileNames.add(fileName);
					List<CaseDetail> caseDetail = fileReaderService.readFile(multipartFile);
					casedetails.add(caseDetail);

				} else {
					System.err.println("File is not valid");
				}

			}

			saveorUpdateCaseDetails(casedetails);
			System.out.println("Successfully updated");

		}
		return fileNames;

	}
	

	@Override
	@Transactional
	public List<List<CaseDetail>> saveorUpdateCaseDetails(List<List<CaseDetail> > caseDetails) {
	for(List<CaseDetail> caseDetail : caseDetails)
		caseRepository.save(caseDetail);
	return caseDetails;
	}

}
