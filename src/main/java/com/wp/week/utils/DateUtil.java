package com.wp.week.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final SimpleDateFormat YYYYMMDD24HHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat YYYYMM = new SimpleDateFormat("yyyyMM");

	/**
	 * 根据给的日期到底时间
	 * 
	 * @param date
	 * @param gapMinute
	 *            负数标识过去的时间，正数表示将来的时间
	 * @return
	 */
	public static Date getDateByGapMinute(Date date, int gapMinute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, gapMinute);

		return cal.getTime();
	}
	
	public static Date getDateByGapSecond(Date date, int gapSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, gapSecond);

		return cal.getTime();
	}

	public static Date getDateByGapMonth(Date date, int gapMonth) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, gapMonth);

		return cal.getTime();
	}

	public static Date getDateByGapDay(Date date, int gapDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, gapDay);

		return cal.getTime();
	}

	public static int getYearMonth(Date date) {
		return Integer.parseInt(YYYYMM.format(date));
	}

	public static long getDate(Date date) {
		return Long.parseLong(YYYYMMDD24HHMMSS.format(date));
	}

	public static void main(String[] args) {

			//Date d = YYYYMMDD24HHMMSS.parse("20180501000102");
//			Date d = new Date();
//			d = getDateByGapMinute(d, -5);
//			System.err.println(YYYYMMDD24HHMMSS.format(d));
//
//			d = getDateByGapSecond(d, 30);
//			System.out.println(YYYYMMDD24HHMMSS.format(d));
//
//			d = getDateByGapMonth(d, -1);
//			System.err.println(YYYYMMDD24HHMMSS.format(d));
//
//			d = getDateByGapDay(d, -1);
//			System.err.println(YYYYMMDD24HHMMSS.format(d));
//
//			System.out.println(getYearMonth(d));
//
//			System.out.println(getDate(d));
		System.out.println(getMondayDayStr(new Date()));
		System.out.println(getSaturdayStr(new Date()));

	}


	// 获得本周一0点时间
	public static Date getTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	// 获得本周日24点时间
	public static Date getTimesWeeknight() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		return cal.getTime();
	}
	/**
	 * 根据时间，获取周一的日期
	 *
	 * @param curDate
	 *            字符串形式
	 * @return
	 */
	public static String getMondayDayStr(Date curDate) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM.dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);

		// System.out.println(sdf2.format(cal.getTime()));

		int a = cal.get(Calendar.DAY_OF_WEEK) - 1; // 得到今天是周几
		// 周几,如果是周日 变为7
		// System.out.println(a);
		if (a == 0) {
			a = 7;
		}
		// 当前时间减去 几天得到周一的时间
		long resDateTime = curDate.getTime() - (a * 86400000);
		// 再加上1天的时间
		resDateTime += 86400000;
		// System.out.println(resDateTime);
		Date resDate = new Date(resDateTime);

		return sdf2.format(resDate);
	}

	/**
	 * 根据时间，获取周六的日期
	 *
	 * @param curDate
	 *            字符串形式
	 * @return
	 */
	public static String getSaturdayStr(Date curDate) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM.dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);

		// System.out.println(sdf2.format(cal.getTime()));

		int a = cal.get(Calendar.DAY_OF_WEEK) - 1; // 得到今天是周几
		// 周几,如果是周日 变为7
		// System.out.println(a);
		if (a == 0) {
			a = 7;
		}
		// 当前时间减去 几天得到周一的时间
		long resDateTime = curDate.getTime() - (a * 86400000);
		// 再加上1天的时间
		resDateTime += 86400000*6;
		// System.out.println(resDateTime);
		Date resDate = new Date(resDateTime);

		return sdf2.format(resDate);
	}


}
