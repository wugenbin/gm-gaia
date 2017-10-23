package com.ntc.gaia.base.utils.tools;

public class IntegerUtil {

	public static boolean isNumber(String str) {

		if (StringUtil.empty(str)) {
			return false;
		}

		return str.matches("[\\d]+");
	}

}
