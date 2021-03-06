package com.ntc.gaia.base.utils.tools;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 系统MD5助手类
 * 
 * @author Allen
 * @date 2015-5-25
 * 
 */
public class MD5Util {

	private String inStr;// 要加密的字符串

	private MessageDigest md5;

	public MD5Util(String inStr) {
		this.inStr = inStr;
		try {
			this.md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	// 加密
	public String compute() {

		char[] charArray = this.inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}

		byte[] md5Bytes = this.md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 对文件的最后修改时间进行MD5加密
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileLastUpdateTimeMd5(File file) {

		String result = "";
		if (file != null) {
			System.out.println("--->>>>要加密的文件：" + file);
			Calendar cal = Calendar.getInstance();
			long time = file.lastModified();
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			cal.setTimeInMillis(time);
			result = formatter.format(cal.getTime());

			try {
				MessageDigest mymd5 = MessageDigest.getInstance("MD5");
				char[] charArray = result.toCharArray();
				byte[] byteArray = new byte[charArray.length];
				for (int i = 0; i < charArray.length; i++) {
					byteArray[i] = (byte) charArray[i];
				}

				byte[] md5Bytes = mymd5.digest(byteArray);
				StringBuffer hexValue = new StringBuffer();

				for (int i = 0; i < md5Bytes.length; i++) {
					int val = ((int) md5Bytes[i]) & 0xff;
					if (val < 16) {
						hexValue.append("0");
					}
					hexValue.append(Integer.toHexString(val));
				}
				result = hexValue.toString();
			} catch (NoSuchAlgorithmException e) {
				result = "";
				return result;
			}
		}
		System.out.println("--->>MD5值：" + result + "\n");
		return result;

	}

	/**
	 * 获取单个文件的MD5值！
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileMD5(File file) {

		String md5str = "";
		if (!file.isFile()) {
			return md5str;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			md5str = "";
			return md5str;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

}
