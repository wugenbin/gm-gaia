package com.ntc.gaia.base.utils.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间操作类
 */
public class DateUtil {

	/**
	 * 获取当前年份
	 */
	public static String getCurrentYear() {

		// 获取系统时间
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(Calendar.YEAR));// 获取年份
	}

	/**
	 * 获取当前月份
	 */
	public static String getCurrentMonth() {

		// 获取系统时间
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(Calendar.MONTH) + 1);// 获取月份
	}

	/**
	 * 获取当前Day
	 */
	public static String getCurrentDay() {

		// 获取系统时间
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));// 获取天
	}

	/**
	 * 获取当前Day所在月的周次
	 */
	public static String getCurrentWeek() {

		// 获取系统时间
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Monday
		return String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));// 获取年份
	}

	/**
	 * 生成格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMS() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 控制时间输出格式
		return sdf.format(new Date());
	}

	/**
	 * 格式化成 yyyy-MM-dd 00:00:00
	 */
	public static String getYMD000(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");// 控制时间输出格式
		return sdf.format(time);
	}

	/**
	 * 格式化成 yyyy-MM-dd 23:59:59
	 */
	public static String getYMD240(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");// 控制时间输出格式
		return sdf.format(time);
	}

	/**
	 * 格式时间 yyyy-MM-dd HH:mm
	 */
	public static String formatYMDHM(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 控制时间输出格式
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {

		}
		return sdf.format(date);
	}

	/**
	 * 格式时间 MM/dd/yyyy
	 */
	public static String formatYMD(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式

		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
		}
		return sdf.format(date);
	}

	/**
	 * 格式时间 MM/dd/yyyy
	 */
	public static String splitFormatYMD(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式

		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
		}

		String result = "";
		if (date != null) {
			result = sdf.format(date);
			if (result != null) {
				String[] times = result.split("-");
				if (times != null && times.length == 3) {
					result = times[2] + '/' + times[1] + '/' + times[0];
				}
			}
		}
		return result;
	}

	/**
	 * 格式时间 MM/dd/yyyy
	 */
	public static String splitFormatYMD2(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式

		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
		}

		String result = "";
		if (date != null) {
			result = sdf.format(date);
			if (result != null) {
				String[] times = result.split("-");
				if (times != null && times.length == 3) {
					result = times[2] + '-' + times[1];
					if (times[0].length() >= 4) {
						result = result + '-' + times[0].substring(2, 4);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 格式时间 MM/dd/yyyy HH:mm
	 */
	public static String splitFormatYMDHM(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 控制时间输出格式

		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
		}

		String result = sdf.format(date);
		String mcond = "";
		if (result != null) {
			String[] times = result.split(" ");
			if (times != null && times.length == 2) {
				mcond = times[1];
				times = times[0].split("-");
				if (times != null && times.length == 3) {
					result = times[2] + '/' + times[1] + '/' + times[0];
				}
			}
		}
		return result + ' ' + mcond;
	}

	/**
	 * 生成格式 yyyy-MM-dd
	 */
	public static String getYMD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式
		return sdf.format(new Date());
	}

	/**
	 * 生成格式 yyyy年MM月dd日(中文)
	 */
	public static String getYMD_CN() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");// 控制时间输出格式
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
		String str_dt = sdf.format(date); // 查询的日期，时间格式为yyyyMMddHHmmssSSS
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

	public static String getBeforeMonth(int target) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -target); // 得到前N个月

		long date = cal.getTimeInMillis();
		return format.format(new Date(date));
	}

	/**
	 * 得到当前N周的时间
	 * 
	 * @param target
	 * @return
	 */
	public static String getBeforeWeek(int target) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.WEDNESDAY, -target); // 得到前N周的时间

		long date = cal.getTimeInMillis();
		return format.format(new Date(date));
	}

	/**
	 * 将德国时间 日/月/年 转换成 yyyy-MM-dd格式
	 * 
	 * @param target
	 * @return
	 */
	public static String buildThumYMD(String date) {

		if (StringUtil.empty(date)) {
			return "";
		}
		String[] arr = date.split("/");
		StringBuffer buffer = new StringBuffer(30);
		if (arr != null && arr.length == 3) {
			buffer.append("20").append(arr[2]).append("-").append(arr[1]).append("-").append(arr[0]);
		}

		return buffer.toString();
	}

	/**
	 * 返回德国时间 日/月/年
	 * 
	 * @param target
	 * @return
	 */
	public static String getThumYMD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式
		String tempTime = sdf.format(new Date());
		String[] array = tempTime.split("-");
		StringBuffer buffer = new StringBuffer();
		if (array != null && array.length == 3) {
			buffer.append(array[2]).append("/").append(array[1]).append("/").append(array[0].substring(2, 4));
		}

		return buffer.toString();
	}

	/**
	 * 返回德国时间 日/月/年
	 * 
	 * @param target
	 * @return
	 */
	public static String formatThumYMD(String date) {

		if (StringUtil.empty(date)) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		try {

			String[] times = date.split(" ");
			if (times != null && times.length == 2) {
				String[] array = times[0].split("-");

				if (array != null && array.length == 3) {
					buffer.append(array[2]).append("/").append(array[1]).append("/").append(array[0].substring(2, 4));
				}
			}

		} catch (Exception ex) {

		}

		return buffer.toString();
	}

	/**
	 * 获取当前周的开始时间
	 * 
	 * @param target
	 * @return
	 */
	public static String getWeekStartTime() {

		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Monday
		return new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());

	}

	/**
	 * 获取当前周的结束时间
	 * 
	 * @param target
	 * @return
	 */
	public static String getWeekEndTime() {

		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Monday

		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Sunday
		return new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(calendar.getTime());

	}

	/**
	 * 获得传入的天是当前第几周(以周一开始)
	 * 
	 * @param dayStr
	 * @return 周数
	 */
	public static int getWeekNumOfYear(String dayStr) {
		int week = 0;
		if (dayStr != null && dayStr.length() != 0) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = format.parse(dayStr);
				Calendar calendar = Calendar.getInstance();
				calendar.setFirstDayOfWeek(Calendar.MONDAY);
				calendar.setTime(date);
				week = calendar.get(Calendar.WEEK_OF_YEAR);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		return week;
	}

	/**
	 * 检查一个时间是否在当周内
	 * 
	 * @param target
	 * @return
	 */
	public static boolean checkTimeInWeek(String time) {

		boolean result = false;
		if (StringUtil.empty(time)) {
			return result;
		}

		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date weekStart = df.parse(getWeekStartTime());
			Date weekEnd = df.parse(getWeekEndTime());
			Date targetTime = df.parse(time);

			if (targetTime.getTime() >= weekStart.getTime() && targetTime.getTime() <= weekEnd.getTime()) {
				return true;
			}
		} catch (Exception ex) {
			result = false;
		}

		return result;

	}

	/**
	 * 年份增加计算
	 */
	public static String getAfterYMD(int after) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 控制时间输出格式
		String date = sdf.format(new Date());
		String[] dateArgs = date.split("-");
		if (dateArgs != null && dateArgs.length == 3) {
			int year = Integer.valueOf(dateArgs[0]) + after;
			date = String.valueOf(year) + '-' + dateArgs[1] + '-' + dateArgs[2];
		}

		return date;
	}

	/**
	 * 判断某天是周几（中文系统）
	 * 
	 * @param date
	 * @return
	 */
	public static String getCurrentWeekday_CN() {

		String week = "";
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		switch (dayOfWeek) {
		case 1:
			week = "星期日";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		case 7:
			week = "星期六";
			break;

		}

		return week;
	}

	/**
	 * 测试类
	 */
	public static void main(String[] args) {

	}
}
