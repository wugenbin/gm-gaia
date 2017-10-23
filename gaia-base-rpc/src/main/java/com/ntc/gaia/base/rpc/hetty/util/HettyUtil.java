package com.ntc.gaia.base.rpc.hetty.util;

import java.io.File;

/**
 * Hetty Util
 * 
 * @author david
 * @date 2016-1-12
 *
 */
public class HettyUtil {

	/**
	 * 文件帮助类
	 * 
	 * @param path
	 * @return
	 */
	public static File getFile(String path) {

		String applicationPath = HettyUtil.class.getClassLoader().getResource("").getPath();
		return new File(applicationPath, path);
	}

	/**
	 * 字符串为 null 或者为 "" 时返回 true
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim()) ? true : false;
	}

	/**
	 * 字符串不为 null 而且不为 "" 时返回 true
	 */
	public static boolean isNotEmpty(String str) {
		return str == null || "".equals(str.trim()) ? false : true;
	}

}
