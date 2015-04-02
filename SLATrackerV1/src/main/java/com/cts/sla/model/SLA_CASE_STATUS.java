package com.cts.sla.model;

public enum SLA_CASE_STATUS {

	Breach("Breach"),
	Breached("Breached"),
	About_To_Breach("About_To_Breach");
	
	private String slaCaseStatus;

	private SLA_CASE_STATUS(String slaCaseStatus){
		this.slaCaseStatus = slaCaseStatus;
	}
	
	public String getSlaStatus(){
		return slaCaseStatus;
	}
	
}
