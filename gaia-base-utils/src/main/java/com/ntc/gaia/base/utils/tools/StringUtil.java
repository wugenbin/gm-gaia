package com.ntc.gaia.base.utils.tools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class StringUtil {

	public final static Logger log = Logger.getLogger(StringUtil.class);

	public static boolean empty(String param) {

		if (null == param || param.length() == 0 || param.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean notEmpty(String param) {

		return !empty(param);
	}

	/**
	 * 验证转换NULL值(null转换为 "")
	 * 
	 * @param obj
	 * @return
	 */
	public static String parseNull(String obj) {

		if (obj == null || obj.length() == 0) {
			return "";
		}
		return obj.trim();
	}

	/**
	 * 去掉String首尾空格
	 */
	public static String trim(String str) {

		if (notEmpty(str)) {
			return str.trim();
		} else {
			return null;
		}
	}

	/**
	 * 中文转码（将ISO-8859-1转成UTF-8）
	 * 
	 * @param str
	 * @return
	 */
	public static String iSOToUtf8(String str) {

		if (empty(str)) {
			return "";
		}
		String utf8Str = "";
		try {

			utf8Str = new String(str.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return utf8Str;
	}

	/**
	 * 中文转码（将UTF-8转成ISO-8859-1）
	 * 
	 * @param str
	 * @return
	 */
	public static String utf8ToISO(String str) {

		if (empty(str)) {
			return "";
		}
		String iSOStr = "";
		try {

			iSOStr = new String(str.getBytes("utf-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return iSOStr;
	}

	/***************************************************************************
	 * 界面字符转换，如：'测' 转成 '%E6%B5%8B' 这样方面在url中传中文
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeURL(String str) {
		if (notEmpty(str)) {
			try {
				return java.net.URLEncoder.encode(str.trim(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		} else {
			return "";
		}
	}

	/***************************************************************************
	 * 界面字符解码，如： '%E6%B5%8B' 转成 '测'
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeURL(String str) {
		if (notEmpty(str)) {
			try {
				return java.net.URLDecoder.decode(str.trim(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		} else {
			return "";
		}
	}

	// 文本格式函数，去除中英文标点符号，空格
	public static String textFormat(String str) {
		String text = null;
		String stext = null;
		Pattern pa = Pattern.compile("[.,\"\\?!:']");
		Matcher ma = pa.matcher(str);
		text = ma.replaceAll("");// 除去英文标点符号
		pa = Pattern.compile(" {2,}");// 去除多余空格
		ma = pa.matcher(text);
		stext = ma.replaceAll("");
		// stext =stext.replaceAll("[^\\u4e00-\\u9fa5]",
		// "");//汉字所在的utf-8编码范围，此句仅输出汉字，且输出中不包含标点符号，英文字母
		return stext;
	}

	// 字符串切割函数，将格式化后的字符串切割为不同长度的短字符串
	public static List<String> cutText(String text) {
		List<String> list = new ArrayList<String>();
		String temp = textFormat(text);
		int i = 0, j = 0;
		// 将字符串切割为长度为4,3,2位的长度
		for (i = 0; i < temp.length() - 4; i++) {
			j = i + 4;
			list.add(temp.substring(i, j));
		}
		for (i = 0; i < temp.length() - 3; i++) {
			j = i + 3;
			list.add(temp.substring(i, j));
		}
		for (i = 0; i < temp.length() - 2; i++) {
			j = i + 2;
			list.add(temp.substring(i, j));
		}
		return list;
	}

	// 检查字符串中是否含有非法字符,有则返回 包含关键字
	public static String auditText(String text, List<String> keylist) {
		StringBuffer sb = new StringBuffer();
		if (null != text) {
			for (String keyword : keylist) {
				if (text.indexOf(keyword) > 0) {
					sb.append(keyword);
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}

	// 检查字符串中是否含有非法字符,有则返回 包含关键字
	public static String checkText(List<String> textlist, List<String> keylist) {
		StringBuffer sb = new StringBuffer();
		List<String> text = new ArrayList<String>();
		text = textlist;
		for (String check : text) {
			for (String keyword : keylist) {
				if (check.contains(keyword) || keyword.contains(check)) {
					sb.append(keyword);
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 截取邮件中的邮件名
	 * 
	 * @param mailName
	 * @return
	 */
	public static String spliteEmail(String mailName) {
		String result = "";
		if (notEmpty(mailName)) {
			int index = mailName.indexOf("@");
			if (index > -1) {
				result = mailName.substring(0, index);
			} else {
				result = mailName.replace("@", "");
			}

		}
		return result;
	}

	/**
	 * 验证是否是邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {

		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);

		return m.matches();
	}

	public static String[] spliteString(String regex, String param) {

		String[] result = {};
		if (notEmpty(param)) {
			result = param.split(regex);
		}
		return result;
	}

	public static String replaceStr(String param, int regex, char value) {
		StringBuffer buffer = new StringBuffer();
		if (notEmpty(param)) {
			if (regex <= 1)
				regex = 1;
			if (regex >= 12)
				regex = 12;
			char[] paramArray = param.toCharArray();
			paramArray[regex - 1] = value;
			for (int index = 0; index < paramArray.length; index++) {
				buffer.append(paramArray[index]);
			}
		}
		return buffer.toString();
	}

	public static String splitFileName(String fileUrl) {

		String result = "";
		if (notEmpty(fileUrl)) {
			return result;
		}
		String temp[] = fileUrl.replaceAll("\\\\", "/").split("/");
		if (temp.length > 1) {
			result = temp[temp.length - 1];
		}

		return result;
	}

	// 去掉字符串空格
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
