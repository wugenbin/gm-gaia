package com.ntc.gaia.base.utils.tools;

import java.math.BigInteger;
import java.util.Random;

public class ProcessorUtil {

	// 生成一个唯一值的token
	public static String generateGUID() {

		String token = "";
		try {

			token = new BigInteger(165, new Random()).toString(36);

		} catch (IllegalStateException ex) {
			token = "";
		}

		return token;
	}

	// 生成一个10随机文件名
	public static String generate10GUID() {

		String random = "";
		try {

			random = new BigInteger(50, new Random()).toString(36).toLowerCase();

		} catch (IllegalStateException ex) {
			random = "";
		}

		return random;
	}

	public static void main(String[] args) {

		System.out.println(generateGUID());
	}
}
