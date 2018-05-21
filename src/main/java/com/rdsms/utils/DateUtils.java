package com.rdsms.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.slf4j.Logger;

/**
 * 
 * @author Nitesh
 *
 */

public class DateUtils {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DateUtils.class);
	
	public static Date toSqlDate(String dateStr) {
		
		Date sqlDate = null ;
		
		if(dateStr != null) {
			logger.debug("Date which needs to be converted : {} ", dateStr);
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date utilDate;
			try {
				DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");//
				java.util.Date date = formatter.parse(dateStr);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
				utilDate = sdf1.parse(formatedDate);
				sqlDate = new java.sql.Date(utilDate.getTime()); 
				logger.debug("Converted Date is : {} ", sqlDate);
				return sqlDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} 
		return sqlDate;
	}
	
	
	public static Date stringToSqlDate(String dateStr) {
		
		Date sqlDate = null ;
		
		if(dateStr != null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date utilDate;
			try {
				DateFormat formatter = new SimpleDateFormat("dd MMM YYYY");
				java.util.Date date = formatter.parse(dateStr);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				String formatedDate = (cal.get(Calendar.DATE)+25) + "/" + (cal.get(Calendar.MONTH) + 3) + "/" + cal.get(Calendar.YEAR);
				utilDate = sdf1.parse(formatedDate);
				sqlDate = new java.sql.Date(utilDate.getTime()); 
				
				return sqlDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} 
		return sqlDate;
	}
	
	
	public static Timestamp convertDate(String dateStr) {
		
		Timestamp sqlDate = null ;
		
		if(dateStr != null) {
			//SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date utilDate;
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				System.out.println(dateStr.contains("."));
				String str = dateStr.substring(0, 19);
//				System.out.println(str);
				java.util.Date date = formatter.parse(str);
				Calendar cal = Calendar.getInstance();
//				System.out.println(date);
				cal.setTime(date);
				/*String formatedDate = (cal.get(Calendar.DATE)) + "/" + (cal.get(Calendar.MONTH)+1 ) + "/" + cal.get(Calendar.YEAR) 
										+ " "+ cal.get(Calendar.HOUR+1)+":"+ cal.get(Calendar.MINUTE) +":"+cal.get(Calendar.SECOND);*/
				//System.out.println("Format :: "+formatedDate);
				utilDate = cal.getTime();// sdf1.parse(formatedDate);
//				System.out.println("util :: "+utilDate.getTime());
				sqlDate = new java.sql.Timestamp(utilDate.getTime()); 
				
				return sqlDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}     
		return sqlDate;
	}
	
/*	public static int convertStringToTime(String time) {
		
		int convertedTime = 0;
		if(time != null) {
			DateFormat formatter = new SimpleDateFormat("mm");
			try {
				long ms = formatter.parse(time).getTime();
				convertedTime = new Time(ms).getMinutes();
				return convertedTime;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		return convertedTime;
	}
	*/
	public static Date convertStringToDate(String dateStr) {
		
		Date date = null;
		if(dateStr != null) {
			DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			try {
				java.util.Date d = formatter.parse(dateStr);
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				java.util.Date utilDate = cal.getTime();
				date = new java.sql.Date(utilDate.getTime());
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	
	public static void main(String[] args) {
		String date  = "20180323";
		Date t = convertStringToDate(date);
//		int t = convertStringToTime("1018.0");
		System.out.println("Time : "+t);
	}

}
