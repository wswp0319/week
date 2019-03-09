package com.wp.week.base.util;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String HHMMDD_FORMAT = "yyyy-MM-dd";
    public static final String INT_STRING_FORMAT = "yyyyMMddHHmmss";
    public static final String INT_STRING_FORMAT_MONTH = "yyyyMM";
    public static final int DB_LONG_DATE = 5;

    public DateUtil() {
    }

    public static String format(Date date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (date != null) {
                return dateFormat.format(date);
            }
        } catch (Exception var2) {
            var2.getMessage();
        }

        return "";
    }

    public static String format(Date date, String formatType) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatType);
        return dateFormat.format(date);
    }

    public static String getDateForIntString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateForIntString(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String formatDate(Date date, String pattern) {
        if (StringUtil.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        return date instanceof Date ? format(date, pattern) : "";
    }

    public static long getNowTime() {
        return (new Date()).getTime();
    }

    public static Date getDateFromStr(String dateStr, String pattern) {
        Date d = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
            d = sdf.parse(dateStr);
        } catch (Exception var4) {
            ;
        }

        return d;
    }

    public static Date getNextDate(int minutes) {
        Date date = new Date();
        long currTime = date.getTime();
        currTime += (long)(minutes * 60 * 1000);
        date.setTime(currTime);
        return date;
    }

    public static int getYear(Date date) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(1);
    }
}
