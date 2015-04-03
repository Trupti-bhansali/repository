package com.cts.sla.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cts.sla.model.CaseDetail;
import com.cts.sla.model.SLA_CASE_STATUS;

public class SLACaseUtils {
	
	
	private final static int NUMBER_OF_COLUMN = 14;
	final static DateFormat DATE_FORMAT1 = new SimpleDateFormat("dd/MM/yyyy");
	final static DateFormat DATE_FORMAT2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	
	
	public static CaseDetail isSLABreached(String targetFixDate, CaseDetail caseDetail) {
		
		Date currentDate = new Date ();
		Date inputDate = getInputDate(targetFixDate);
		
		if (getCurrentDateStr().compareTo(getInputDateStr(targetFixDate)) == 0 ) { 
			//TODO: for status hold need to handle separately
			
			if(currentDate.compareTo(inputDate) < 0 )
			{
				caseDetail.setSLAStatus(SLA_CASE_STATUS.Breach.toString());
			}
			else
			{
				caseDetail.setSLAStatus(SLA_CASE_STATUS.Breached.toString());
			}
		
		}else if (currentDate.compareTo(inputDate) > 0  ) {
			caseDetail.setSLAStatus(SLA_CASE_STATUS.Breached.toString());
		}

		else if (currentDate.compareTo(inputDate) < 0 ) {
			caseDetail.setSLAStatus(SLA_CASE_STATUS.About_To_Breach.toString());
		}
		return caseDetail;
		
	}

	public static String getCurrentDateStr() {
		return (DATE_FORMAT1.format(new Date()));
	}

	public static String getInputDateStr(String Input) {
		Date date;
		String inputDateStr = null;
		try {
			date = DATE_FORMAT2.parse(Input);
			inputDateStr = DATE_FORMAT1.format(date);
		} catch (ParseException e) {
			System.err.println("TargetDate is not in expected format:" + Input);
		}
		return inputDateStr;
	}

	public static Date getInputDate(String targetDate) {
		Date inputDate = null;
		try {
			inputDate = DATE_FORMAT2.parse(targetDate);
		} catch (ParseException e) {
			System.err.println("TargetDate is not in expected format:" + targetDate);
		}
		return inputDate;
	}
	
	public static boolean validateNumberOfColumn(String[] details) {
		boolean isValid = false;
		if(details.length == NUMBER_OF_COLUMN)
		{
			isValid = true;
		}
		return isValid;
		
	}

}
