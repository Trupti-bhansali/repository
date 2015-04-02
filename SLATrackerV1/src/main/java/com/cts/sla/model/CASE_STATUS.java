package com.cts.sla.model;

public enum CASE_STATUS {
	OPEN("Open"),
	CLOSE("Close"),
	RESOLVED("Resolved");

	private String caseStatus;
	
	private CASE_STATUS(String caseStatus){
		this.caseStatus = caseStatus;
	}
	
	public String getStatus(){
		return caseStatus;
	}
	
}

