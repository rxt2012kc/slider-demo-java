/**
 * Author: balance
 * Datetime: 2010-9-6
 * Note: 
 */
package com.xindun.server.servlet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*; 


public class DateTime {	
	public DateTime()
	{					
	}
	public static GregorianCalendar ConvertStringToDate(String strDate)
	{//将字符串转换为日期如20041101		
		String strYear=strDate.substring(0,4);
		String strMonth=strDate.substring(4,6);		
		String strDay=strDate.substring(6,8);
		
		int nYear=Integer.parseInt(strYear);
		int nMonth=Integer.parseInt(strMonth);
		int nDay=Integer.parseInt(strDay);
		
		GregorianCalendar date= new GregorianCalendar(nYear, nMonth-1,nDay);		
		return date;
		
	}
	public static String ConvertDateToString(GregorianCalendar date)
	{//将日期转换成字符串如20041101
		//将输入的日期转换为正常日期
		ConvertToActualDate(date);
		String strDate;
		String strYear=Integer.toString(date.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		String strMonth=Integer.toString(date.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		String strDay=Integer.toString(date.get(Calendar.DATE));
		if(strDay.length()!=2)
		{
			strDay="0"+strDay;
		}
		strDate=strYear+strMonth+strDay;
						
		return strDate;
	}
	
	public static void ConvertToActualDate(GregorianCalendar date)
	{//将输入的日期转换为正常日期，只限于日期为正且年月均正常，如20040290
		
		int nYear=date.get(Calendar.YEAR);
		int nMonth=date.get(Calendar.MONTH)+1;
		int nDay=date.get(Calendar.DATE);
		
		while(nDay>GetMaxDaysNum(nYear,nMonth))
		{
			if(nMonth!=12)
			{
				nDay-=GetMaxDaysNum(nYear,nMonth);
				nMonth++;				
			}
			else
			{
				nDay-=GetMaxDaysNum(nYear,nMonth);
				nMonth=1;
				nYear++;
			}
		}
		
		date.set(Calendar.YEAR,nYear);
		date.set(Calendar.MONTH,nMonth-1);
		date.set(Calendar.DATE,nDay);
	}
	
	public static int GetMaxDaysNum(int nYear,int nMonth)
	{//获得一个月的最大天数
		if((nYear%4)==0)
		{
			if(nMonth==2)return 29;
		}
		else
		{
			if(nMonth==2)return 28;
		}
		
		if((nMonth==1)||(nMonth==3)||(nMonth==5)||(nMonth==7)||(nMonth==8)||(nMonth==10)||(nMonth==12))
		{
			return 31;
		}
		
		return 30;
		
	}
	
	public static String GetCurrentDateString()
	{//返回当前日期字符串
		GregorianCalendar currentTime = new GregorianCalendar();
		String strCurrentDate=ConvertDateToString(currentTime);
		return strCurrentDate;
	}
	
	public static boolean IsDate(String strData)
	{//检查是否为日期字符串
		if(strData.length()<8)
			return false;
		for(int i=0;i<8;i++)
		{
			char cNum=strData.charAt(i);
			if(!((cNum<='9')&&(cNum>='0')))
				return false;
		}
		
		return true;
	}
	
	public static String CalculateDate(GregorianCalendar date,int nNum,String unit)
	{
		if(date == null)// 取当前时间
		{
			date = new GregorianCalendar();
		}
		
		if( unit.equals("DATE") )
		{
			date.set(Calendar.DATE,date.get(Calendar.DATE)+nNum);
		}else if( unit.equals("MONTH") )
		{
			date.set(Calendar.MONTH,date.get(Calendar.MONTH)+nNum);
		}
		

		String strYear=Integer.toString(date.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		
		String strMonth=Integer.toString(date.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		
		String strDay="";
		if( !unit.equals("MONTH") )
		{
			strDay = Integer.toString(date.get(Calendar.DATE));
			if(strDay.length()!=2)
			{
				strDay="0"+strDay;
			}
		}	
		
		String strDateTime=strYear+strMonth+strDay;
		return strDateTime;
	}
	
	public static String CalculateDateWithSecond(GregorianCalendar date,int nNum)
	{
		if(date == null)// 取当前时间
		{
			date = new GregorianCalendar();
		}
		
		date.set(Calendar.SECOND,date.get(Calendar.SECOND)+nNum);		

		String strDateTime;
		String strYear=Integer.toString(date.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		String strMonth=Integer.toString(date.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		String strDay=Integer.toString(date.get(Calendar.DATE));
		if(strDay.length()!=2)
		{
			strDay="0"+strDay;
		}
		
		String strHour=Integer.toString(date.get(Calendar.HOUR_OF_DAY));
		if(strHour.length()!=2)
		{
			strHour="0"+strHour;
		}
		
		String strMinute=Integer.toString(date.get(Calendar.MINUTE));
		if(strMinute.length()!=2)
		{
			strMinute="0"+strMinute;
		}
		
		String strSecond=Integer.toString(date.get(Calendar.SECOND));
		if(strSecond.length()!=2)
		{
			strSecond="0"+strSecond;
		}
		strDateTime=strYear+strMonth+strDay+strHour+strMinute+strSecond;				
		
		return strDateTime;
	} 
	

	public static GregorianCalendar ConvertStringToDateTime(String strDateTime)
	{//将字符串20041101132112转换为日期时间		
		String strYear=strDateTime.substring(0,4);
		String strMonth=strDateTime.substring(4,6);		
		String strDay=strDateTime.substring(6,8);
		String strHour=strDateTime.substring(8,10);
		String strMinute=strDateTime.substring(10,12);
		String strSecond=strDateTime.substring(12,14);
		
		int nYear=Integer.parseInt(strYear);
		int nMonth=Integer.parseInt(strMonth);
		int nDay=Integer.parseInt(strDay);
		
		int nHour=Integer.parseInt(strHour);
		int nMinute=Integer.parseInt(strMinute);
		int nSecond=Integer.parseInt(strSecond);
		
		GregorianCalendar datetime= new GregorianCalendar(nYear, nMonth-1,nDay,nHour,nMinute,nSecond);
			
		return datetime;
		
	}
	
	public static String GetChineseDate(String strDate)
	{//输入8位日期字符串转换成年月日的方式
		String str;
		if(strDate.length()==8)
		{
			//str=strDate.subSequence(0,4)+"年"+strDate.subSequence(4,6)+"月"+strDate.subSequence(6,8)+"日";
			str = strDate.subSequence(0,4)+" "+strDate.subSequence(4,6)+" "+strDate.subSequence(6,8)+" ";
		}
		else
			//str="未知";
			str="unknown";
		return str;
			
	}
	
	public static void AddDate(GregorianCalendar date ,int nNum)
	{//将输入的日期增加nNum天Emtone add 20060417
		if(nNum<=0)
		{
			return;
		}
		date.set(Calendar.DATE,date.get(Calendar.DATE)+nNum);
	}
	
	public static String GetCurrentDateTimeString()
	{//返回当前日期时间字符串
		GregorianCalendar currentTime = new GregorianCalendar();
		
		String strDateTime;
		String strYear=Integer.toString(currentTime.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		String strMonth=Integer.toString(currentTime.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		String strDay=Integer.toString(currentTime.get(Calendar.DATE));
		if(strDay.length()!=2)
		{
			strDay="0"+strDay;
		}
		
		String strHour=Integer.toString(currentTime.get(Calendar.HOUR_OF_DAY));
		if(strHour.length()!=2)
		{
			strHour="0"+strHour;
		}
		
		String strMinute=Integer.toString(currentTime.get(Calendar.MINUTE));
		if(strMinute.length()!=2)
		{
			strMinute="0"+strMinute;
		}
		
		String strSecond=Integer.toString(currentTime.get(Calendar.SECOND));
		if(strSecond.length()!=2)
		{
			strSecond="0"+strSecond;
		}
		strDateTime=strYear+strMonth+strDay+strHour+strMinute+strSecond;				
		
		return strDateTime;
	}
	
	public static String GetCurrentDateYearToMonth()
	{
		GregorianCalendar currentTime = new GregorianCalendar();
		
		String strDateTime;
		String strYear=Integer.toString(currentTime.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		String strMonth=Integer.toString(currentTime.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		
		strDateTime=strYear.substring(2,4)+strMonth;				
		
		return strDateTime;
	}
	
	public static String GetCurrentMillisecondTimeString()
	{//返回当前日期时间字符串 精确到毫秒
		GregorianCalendar currentTime = new GregorianCalendar();
		
		String strMillisecondTime;
		String strYear=Integer.toString(currentTime.get(Calendar.YEAR));
		for(int i=0;i<(4-strYear.length());i++)
		{
			strYear="0"+strYear;
		}
		String strMonth=Integer.toString(currentTime.get(Calendar.MONTH)+1);
		if(strMonth.length()!=2)
		{
			strMonth="0"+strMonth;
		}
		String strDay=Integer.toString(currentTime.get(Calendar.DATE));
		if(strDay.length()!=2)
		{
			strDay="0"+strDay;
		}
		
		String strHour=Integer.toString(currentTime.get(Calendar.HOUR_OF_DAY));
		if(strHour.length()!=2)
		{
			strHour="0"+strHour;
		}
		
		String strMinute=Integer.toString(currentTime.get(Calendar.MINUTE));
		if(strMinute.length()!=2)
		{
			strMinute="0"+strMinute;
		}
		
		String strSecond=Integer.toString(currentTime.get(Calendar.SECOND));
		if(strSecond.length()!=2)
		{
			strSecond="0"+strSecond;
		}
		
		String strMillisecond=Integer.toString(currentTime.get(Calendar.MILLISECOND));
		while(strMillisecond.length()<3)
		{
			strMillisecond="0"+strMillisecond;
		}
		strMillisecondTime=strYear+strMonth+strDay+strHour+strMinute+strSecond+strMillisecond;				
		
		return strMillisecondTime;
	}
	
	public static String GetCurrentTimeString()
	{//返回当前时间字符串
		GregorianCalendar currentTime = new GregorianCalendar();
		
		String strTime;
		
		String strHour=Integer.toString(currentTime.get(Calendar.HOUR_OF_DAY));
		if(strHour.length()!=2)
		{
			strHour="0"+strHour;
		}
		
		String strMinute=Integer.toString(currentTime.get(Calendar.MINUTE));
		if(strMinute.length()!=2)
		{
			strMinute="0"+strMinute;
		}
		
		String strSecond=Integer.toString(currentTime.get(Calendar.SECOND));
		if(strSecond.length()!=2)
		{
			strSecond="0"+strSecond;
		}
		strTime=strHour+strMinute+strSecond;				
		
		return strTime;
	}
	
	/**
	 * @author 
	 * @date Aug 23, 2011
	 * @param date1
	 * @param date2
	 * @return 返回date1-date2的秒数
	 * @note 
	 */
	public static int GetIntervalSecond(String date1, String date2) 
	{
		long sec1 = ConvertStringToDateTime(date1).getTimeInMillis();
		long sec2 = ConvertStringToDateTime(date2).getTimeInMillis();
		int res = (int)((sec1-sec2)/1000);
		return res;
	}
	
	/**
	 * GetCurrentTimestamp
	 * return: timestamp like yyyy-MM-dd HH:mm:ss
	 */
	public static String GetCurrentTimestamp(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String timestamp = df.format(now);
		
		return timestamp;
	}
	
	/**
	 * @author 
	 * @date 7-30, 2013
	 * @param date1
	 * @param years
	 * @return return n years after date1
	 * @note 
	 */
	public static String GetAfterYearString(String strDateTime, int years) {
		GregorianCalendar date = ConvertStringToDate(strDateTime);
		date.set(Calendar.YEAR, date.get(Calendar.YEAR) + years);
		return ConvertDateToString(date);
	}
	
	/**
	 * @author 
	 * @date 7-31, 2013
	 * @param date1
	 * @param months
	 * @return return n months after date1
	 * @note 
	 */
	public static String GetAfterMonthString(String strDateTime, int months) {
		GregorianCalendar date = ConvertStringToDate(strDateTime);
		date.set(Calendar.MONTH, date.get(Calendar.MONTH) + months);
		return ConvertDateToString(date);
	}
	
	public static String GetAfterDateString(String availableTime, int days) {
		GregorianCalendar date = ConvertStringToDate(availableTime);
		date.set(Calendar.DATE, date.get(Calendar.DATE) + days);
		return ConvertDateToString(date);
	}
	
	/**
	 * 
	 * @param smCreateDateTime 创建时间
	 * @param validDuration 更新间隔
	 * @return true-过期；false-未过期
	 */
	public static boolean IsTimeExpired(String smCreateDateTime, int validDuration) {

		try{
			if (smCreateDateTime.length() != 14) {
				return true;
			}
			String smCurrentDateTime = DateTime.GetCurrentDateTimeString(); // 当前时间
			String smExpiredDateTime = DateTime.CalculateDateWithSecond(
					DateTime.ConvertStringToDateTime(smCreateDateTime),
					validDuration);// 过期时间
	
			if (Long.parseLong(smCurrentDateTime) > Long
					.parseLong(smExpiredDateTime)) {
				return true;
			}
		}
		catch (NumberFormatException e) {
           e.printStackTrace();
           return true;
        }
		return false;
	}
	
}