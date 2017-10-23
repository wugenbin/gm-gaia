package com.ntc.gaia.base.utils.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	/**
	 * 获得传入的天是当前第几周
	 * 
	 * @param dayStr
	 * @return
	 */
	public static int getWeekNumOfYear(String dayStr) {

		int day = -1;
		if (dayStr != null && dayStr.length() != 0) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = format.parse(dayStr);
				Calendar calendar = Calendar.getInstance();
				calendar.setFirstDayOfWeek(Calendar.SUNDAY);
				calendar.setTime(date);
				day = calendar.get(Calendar.WEEK_OF_YEAR);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}

		return day;
	}

	// 获取当前时间所在年的最大周数
	public static int getMaxWeekNumOfYear(int year) {

		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	// 获取当前时间所在年的周数
	public static int getWeekOfYear(Date date) {

		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 判断某天是周几（中文系统）
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekdayCN(String date) {

		String msg = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		msg = sdw.format(d);
		// System.out.println("getWeekday.day:"+msg);

		if ("星期一".equalsIgnoreCase(msg)) {
			msg = "2";
		} else if ("星期二".equalsIgnoreCase(msg)) {
			msg = "3";
		} else if ("星期三".equalsIgnoreCase(msg)) {
			msg = "4";
		} else if ("星期四".equalsIgnoreCase(msg)) {
			msg = "5";
		} else if ("星期五".equalsIgnoreCase(msg)) {
			msg = "6";
		} else if ("星期六".equalsIgnoreCase(msg)) {
			msg = "7";
		} else if ("星期日".equalsIgnoreCase(msg)) {
			msg = "1";
		}

		return msg;
	}

	/**
	 * 判断某天是周几（英文系统）
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekdayEN(String date) {

		String msg = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		msg = sdw.format(d);
		// System.out.println("getWeekday.day:"+msg);

		if ("Mon".equalsIgnoreCase(msg)) {
			msg = "2";
		} else if ("Tue".equalsIgnoreCase(msg)) {
			msg = "3";
		} else if ("Wed".equalsIgnoreCase(msg)) {
			msg = "4";
		} else if ("Thu".equalsIgnoreCase(msg)) {
			msg = "5";
		} else if ("Fri".equalsIgnoreCase(msg)) {
			msg = "6";
		} else if ("Sat".equalsIgnoreCase(msg)) {
			msg = "7";
		} else if ("Sun".equalsIgnoreCase(msg)) {
			msg = "1";
		}

		return msg;
	}

	/**
	 * 获得某天的下一天
	 * 
	 * @param sdf
	 *            ："yyyy-mm-dd"
	 * @param dateString
	 *            : "2012-4-30"
	 * @return
	 */
	public static String getNextDate(String sdf, String dateString) {

		Calendar now_Time = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(sdf);
		try {
			now_Time.setTime(df.parse(dateString));
		} catch (Exception e) {
			e.printStackTrace();
		}
		now_Time.add(Calendar.DATE, 1);
		SimpleDateFormat sdNowDate = new SimpleDateFormat(sdf);

		return sdNowDate.format(now_Time.getTime());
	}

	/**
	 * 获取某周中的头一天的日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getFirstDataByYearAndWeekOfYear(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK) - 1;
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date firstDayInWeek = calFirstDayInWeek.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(firstDayInWeek);
	}

	/**
	 * 获取某周中的最后一天的日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getLastDataByYearAndWeekOfYear(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK) - 1;
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);

		Calendar calLastDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		calLastDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMaximum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date lastDayInWeek = calLastDayInWeek.getTime();

		return df.format(lastDayInWeek);
	}

	/**
	 * 获取某周中的头一天的日期(英文输出)
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getFirstDataByYearAndWeekOfYearen(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK) - 1;
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date firstDayInWeek = calFirstDayInWeek.getTime();
		SimpleDateFormat df = new SimpleDateFormat("dd.MM");

		return df.format(firstDayInWeek);
	}

	/**
	 * 获取某周中的最后一天的日期(英文输出)
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getLastDataByYearAndWeekOfYearen(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK) - 1;
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);

		Calendar calLastDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		SimpleDateFormat df = new SimpleDateFormat("dd.MM");
		calLastDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMaximum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date lastDayInWeek = calLastDayInWeek.getTime();

		return df.format(lastDayInWeek);
	}

	/**
	 * 获取某周中的头一天的日期(英文输出只有月日)
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getFirstDataByYearAndWeekOfYearenday(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK);
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date firstDayInWeek = calFirstDayInWeek.getTime();
		SimpleDateFormat df = new SimpleDateFormat("dd.MM");

		return df.format(firstDayInWeek);
	}

	/**
	 * 获取某周中的最后一天的日期(英文输出只有月日)
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getLastDataByYearAndWeekOfYearenday(int year, int week) {

		Calendar calFirstDayOfTheYear = new GregorianCalendar(year, Calendar.JANUARY, 1);
		calFirstDayOfTheYear.add(Calendar.DATE, 7 * (week - 1));
		int dayOfWeek = calFirstDayOfTheYear.get(Calendar.DAY_OF_WEEK);
		Calendar calFirstDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		calFirstDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek);

		Calendar calLastDayInWeek = (Calendar) calFirstDayOfTheYear.clone();
		SimpleDateFormat df = new SimpleDateFormat("dd.MM");
		calLastDayInWeek.add(Calendar.DATE, calFirstDayOfTheYear.getActualMaximum(Calendar.DAY_OF_WEEK) - dayOfWeek);
		Date lastDayInWeek = calLastDayInWeek.getTime();
		return df.format(lastDayInWeek);
	}

	// 需要留意的是：月份是从0开始的，比如说假如输进5的话，实际上显示的是6月份的最后一天，为了方便使用处理是直接减1
	/**
	 * 获取某年某月最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获取某年某月第一天)
	 * 
	 * @param year
	 * @param month
	 * @return
	 */

	public static String getFirstDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 生成格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMS() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 控制时间输出格式
		return sdf.format(new Date());
	}

	/**
	 * 生成格式 yyyy-MM-dd
	 */
	public static String getYMD() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式
		return sdf.format(new Date());
	}

	/**
	 * 生成格式 yyyyMMdd
	 */
	public static String getYYYYMMDD() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 控制时间输出格式
		return sdf.format(new Date());
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 *            传入时间
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * String转Date
	 * 
	 * @param strDate
	 *            字符日期：如：2009-04-02 08:30:22
	 * @param formates
	 *            格式，必须跟传入的日期对应 如：yyyy-MM-dd HH:mm:ss
	 */
	public static Date strChangeDate(String strDate, String formates) {

		Date dt_dates = null;
		if (null == formates || "".equals(formates)) {
			formates = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(formates);
			dt_dates = formatter.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt_dates;
	}

	/**
	 * Date转String
	 * 
	 * @param strDate
	 *            日期：如：2009-04-02 08:30:22
	 * @param formates
	 *            格式，必须跟传入的日期对应 如：yyyy-MM-dd HH:mm:ss
	 */
	public static String dateChangeStr(Date date, String formates) {

		if (null == date || "".equals(date)) {
			date = new Date();
		}
		if (null == formates || "".equals(formates)) {
			formates = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formates);// 控制时间输出格式
		String str_dt = sdf.format(date); // 查询的日期，时间格式为yyyyMMddHHmiss
		return str_dt;
	}

	/**
	 * 判断时间date1是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 */
	public static boolean isDateBefore(String date1, String date2) {

		try {
			DateFormat df = DateFormat.getDateTimeInstance();
			return df.parse(date1).before(df.parse(date2));
		} catch (Exception e) {
			System.out.print("[SYS] " + e.getMessage());
			return false;
		}
	}

	/**
	 * 判断当前时间是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 */
	public static boolean isDateBefore(String date2) {

		try {
			Date date1 = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return date1.before(df.parse(date2));
		} catch (Exception e) {
			System.out.print("[SYS] " + e.getMessage());
			return false;
		}
	}

	/**
	 * 判断时间date1是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 */
	public static int comparedate(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取日期差，返回相差天数。
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static long getCompareDate(String startDate, String endDate) {

		long d = 0;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = formatter.parse(startDate);
			Date date2 = formatter.parse(endDate);
			long tempTime = date2.getTime() - date1.getTime();
			d = tempTime / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			System.out.print("[SYS] " + e.getMessage());
		}
		return d;
	}

	/**
	 * 获取日期差，返回相差秒
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static long getCompareDateSeconds(String startDate, String endDate) {

		long d = 0;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = formatter.parse(startDate);
			Date date2 = formatter.parse(endDate);
			long tempTime = date2.getTime() - date1.getTime();
			d = tempTime / 1000;// / (24 * 60 * 60 * 1000)
		} catch (Exception e) {
			System.out.print("[SYS] " + e.getMessage());
		}
		return d;
	}

	/**
	 * 获取传入时间N小时前的时间
	 * 
	 * @param dates
	 *            时间
	 * @param agetime
	 *            dates几小时前 如：1
	 * @param formates
	 *            格式 如：yyyy-MM-dd HH:mm:ss:SS
	 * @return 当前时间N小时前的时间
	 */
	public static String getHoursAgoTime(Date dates, int agetime, String formates) {

		String oneHoursAgoTime = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dates);
		cal.set(Calendar.HOUR, (cal.get(Calendar.HOUR) - agetime));
		oneHoursAgoTime = new SimpleDateFormat(formates).format(cal.getTime());
		return oneHoursAgoTime;
	}

	/**
	 * 测试类
	 */
	public static void main(String[] args) {

		System.out.println(getYMDHMS());
		System.out.println(getCompareDateSeconds("2011-01-13 16:51:00", "2011-01-13 16:52:01"));

	}
}
