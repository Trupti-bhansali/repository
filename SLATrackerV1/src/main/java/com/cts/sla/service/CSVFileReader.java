package com.cts.sla.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.util.SLACaseUtils;

public class CSVFileReader implements IFileReader {

	@Override
	public List<CaseDetail> read(MultipartFile file) throws FileNotFoundException, IOException {

		return getSLACaseDetailsFromCSV(file);
	}

	
	private List<CaseDetail> getSLACaseDetailsFromCSV(MultipartFile file)	throws FileNotFoundException, IOException {

		List<CaseDetail> caseList = new ArrayList<CaseDetail>();
		Reader inputReader =  (new InputStreamReader(file.getInputStream()));
		@SuppressWarnings("resource")
		CSVReader reader = new CSVReader(inputReader);
		
		int count = 0;
		String[] details = null;
		while ((details = reader.readNext()) != null) {
			count++;
			// ignore header record while processing
			if (count == 1) {
				continue;
			}
			if (SLACaseUtils.validateNumberOfColumn(details)) {
				// Get the input
				CaseDetail caseDetail = new CaseDetail();

				caseDetail.setCaseId(details[1]);
				caseDetail.setAge(details[2]);
				caseDetail.setCaseCreationDateTime(SLACaseUtils.getInputDate(details[3]));
				caseDetail.setCondition(details[4]);
				caseDetail.setCaseStatus(details[5]);
				caseDetail.setPriority(details[6]);
				caseDetail.setOwner(details[7]);
				caseDetail.setDesciption(details[12]);
				caseDetail.setQueue(details[13]);

				//TODO: set queue once csv format is final
				
				String targetFixDate = SLACaseUtils.getInputDateStr(details[9]);
				if (targetFixDate != null) {
					caseDetail.setTargetFixDateTime(SLACaseUtils.getInputDate(details[9]));
					caseDetail = SLACaseUtils.isSLABreached(details[9], caseDetail);
					System.out.println(caseDetail.toString());

					caseList.add(caseDetail);
				} else {
					System.err.println("Not able to parse date for record having id: " + caseDetail.getCaseId());
				}

			} else {
				System.err.println("There is some discrepency in data matcher for row " + count);
			}
		}
		reader.close();
		return caseList;
		
	}

}
