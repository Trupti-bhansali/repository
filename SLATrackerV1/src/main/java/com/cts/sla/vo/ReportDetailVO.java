package com.cts.sla.vo;

public class ReportDetailVO {
	private String reportName;
	private Integer alreadyBreached;
	private Integer breachingToday;
	private Integer yetToBeBreached;
	private Integer grandTotal;
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	/**
	 * @return the alreadyBreached
	 */
	public Integer getAlreadyBreached() {
		return alreadyBreached;
	}
	/**
	 * @param alreadyBreached the alreadyBreached to set
	 */
	public void setAlreadyBreached(Integer alreadyBreached) {
		this.alreadyBreached = alreadyBreached;
	}
	/**
	 * @return the breachingToday
	 */
	public Integer getBreachingToday() {
		return breachingToday;
	}
	/**
	 * @param breachingToday the breachingToday to set
	 */
	public void setBreachingToday(Integer breachingToday) {
		this.breachingToday = breachingToday;
	}
	/**
	 * @return the yetToBeBreached
	 */
	public Integer getYetToBeBreached() {
		return yetToBeBreached;
	}
	/**
	 * @param yetToBeBreached the yetToBeBreached to set
	 */
	public void setYetToBeBreached(Integer yetToBeBreached) {
		this.yetToBeBreached = yetToBeBreached;
	}
	/**
	 * @return the grandTotal
	 */
	public Integer getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	

}
