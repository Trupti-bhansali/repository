package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.NotSupportedException;

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
	public List<CaseDetail> saveorUpdateCaseDetail(MultipartFile file) {
			
			List<CaseDetail> slaCaseDetail = null;
			try {
				slaCaseDetail = saveorUpdateCaseDetail(fileReaderService.readFile(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (NotSupportedException e) {
				e.printStackTrace();
			}
			return slaCaseDetail;
		}
	
	
	@Override
	@Transactional
	public List<CaseDetail> saveorUpdateCaseDetail(List<CaseDetail> caseDetails) {
	for (CaseDetail caseDetail : caseDetails) {
		saveorUpdateCaseDetail(caseDetail);
	}
	 return caseDetails;
}

	@Override
	@Transactional
	public CaseDetail saveorUpdateCaseDetail(CaseDetail caseDetail) {
		caseRepository.save(caseDetail);
		return caseDetail;
	}

}
