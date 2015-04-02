package com.cts.sla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CaseDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String caseId;
	private String priority;
	private String age;
	private String queue;
	private String owner;
	private String caseStatus;
	private String condition;

	@Temporal(TemporalType.TIMESTAMP)
	private Date caseCreationDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date targetFixDateTime;
	private String desciption;
	private String SLAStatus;

	public CaseDetail() {
	}

	public CaseDetail(String caseId, String priority, String age,
			String queue, String owner, String caseStatus,
			Date caseCreationDateTime, Date targetFixDateTime, String desciption) {
		super();
		this.caseId = caseId;
		this.priority = priority;
		this.age = age;
		this.queue = queue;
		this.owner = owner;
		this.caseStatus = caseStatus;
		this.caseCreationDateTime = caseCreationDateTime;
		this.targetFixDateTime = targetFixDateTime;
		this.desciption = desciption;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Date getCaseCreationDateTime() {
		return caseCreationDateTime;
	}

	public void setCaseCreationDateTime(Date caseCreationDateTime) {
		this.caseCreationDateTime = caseCreationDateTime;
	}

	public Date getTargetFixDateTime() {
		return targetFixDateTime;
	}

	public void setTargetFixDateTime(Date targetFixDateTime) {
		this.targetFixDateTime = targetFixDateTime;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getSLAStatus() {
		return SLAStatus;
	}

	public void setSLAStatus(String sLAStatus) {
		SLAStatus = sLAStatus;
	}

	@Override
	public String toString() {
		return "CaseDetail [caseId=" + caseId + ", priority=" + priority
				+ ", Age=" + age + ", queue=" + queue + ", owner=" + owner + ", Condition = " + condition
				+ ", caseStatus=" + caseStatus + ", caseCreationDateTime="
				+ caseCreationDateTime + ", targetFixDateTime="
				+ targetFixDateTime + ", desciption=" + desciption + ", SLACaseStatus =" + SLAStatus + "]";
	}

	
}
