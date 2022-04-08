package com.hashedin.bank.util;

import java.util.Calendar;
import java.util.Date;

public class ExpiryDateGenerator {
	
	public static Date getExpiryDate(int months) {
		Date date = new Date();
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, months);
	    Date expirationDate = cal.getTime();
	    
	    return expirationDate;
	}
}