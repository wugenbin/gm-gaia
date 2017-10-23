package com.ntc.gaia.base.utils.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class FileUtil {

	// 处理普通java类读取web-inf 下的文件路径问题
	public static String getWebInfoPath() {

		URL url = FileUtil.class.getProtectionDomain().getCodeSource()
				.getLocation();
		String path = url.toString();
		int index = path.indexOf("WEB-INF");

		if (index == -1) {
			index = path.indexOf("classes");
		}

		if (index == -1) {
			index = path.indexOf("bin");
		}

		path = path.substring(0, index);

		if (path.startsWith("zip")) {// 当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		} else if (path.startsWith("file")) {// 当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(6);
		} else if (path.startsWith("jar")) {// 当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(10);
		}
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return path;
	}

	/**
	 * 生成指定格式的文件. 如果文件内容中没有中文内容，则生成的文件为ANSI编码格式； 如果文件内容中有中文内容，则生成的文件为指定格式编码格式文件。
	 * 
	 * @param fileName
	 *            待生成的文件名（含完整路径）
	 * @param fileBody
	 *            文件内容
	 * @return
	 */
	public static boolean writeEncodingFile(String encoding, String fileName,
			String fileBody) {

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = new FileOutputStream(fileName);
			osw = new OutputStreamWriter(fos, encoding);
			osw.write(fileBody);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 删除指定目录下的指定文件
	 */
	public static boolean deleteFile(String filePath) {

		boolean result = false;
		if (null != filePath && !"".equals(filePath)) {
			File instance = new File(filePath);
			// 如果文件存在且是文件类型则删除
			if (instance.exists() && instance.isFile()) {
				instance.delete();
				result = true;
			}
		}
		return result;
	}

	/**
	 * 创建文件夹 判断根据指定目录，判断目录(文件夹)是否存在，不存在则创建 注意：不能判断文件
	 */
	public static boolean creatFileDir(String filepath) {

		try {
			// File file = new File(filepath);
			if (null != filepath && !"".equals(filepath)) {
				if (!(new File(filepath).isDirectory())) {
					new File(filepath).mkdirs();
				}
			}
			return true;
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据传入的String 逐层创建文件夹
	 */
	public static void creatFileDirs(String basepath, String floderpath) {

		// String floderpaths = null;
		if (null != floderpath && floderpath.length() > 0) {
			String arrFloderpath[] = floderpath.split("/");
			for (int i = 0; i < arrFloderpath.length; i++) {
				System.out.println(arrFloderpath[i]);
				basepath += "/" + arrFloderpath[i];
				System.out.println(basepath);
				creatFileDir(basepath);
			}

		}
	}

	/**
	 * 判断文件是否存在
	 */
	public static boolean isExists(String path) {// 判断文件是否存在

		File f = new File(path);
		if (f.exists()) {
			if (f.isFile()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断远程服务器文件是否存在
	 */
	public static boolean isServerExists(String path) {

		try {
			boolean bool = false;
			URL url = new URL(path);
			InputStream inputstream = url.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					inputstream));
			// StringBuffer stringbuffer = new StringBuffer();
			if (in.readLine() != null) {
				bool = true;
			}
			inputstream.close();
			in.close();
			return bool;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 重命名文件 String filePath, 需重命名文件的路径 如：D:\\111.jpeg String newFilePath
	 * 重命名后文件的路径 如：D:\\111啊啊.jpeg
	 */
	public static boolean reNameFile(String filePath, String newFilePath) {

		File file = new File(filePath);
		// File newFile = new File(newFilePath);
		return file.renameTo(new File(newFilePath));
	}

	/**
	 * 获得文件大小
	 */
	public static long getFileSizes(String filePath) {// 取得文件大小

		long s = 0;
		File f = new File(filePath);
		if (f.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(f);
				s = fis.available();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return 0;
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return s;
	}

	/**
	 * 有格式的方式创建文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return
	 */
	public static boolean createFile(String filePathAndName,
			String fileContent, String encoding) {

		boolean result = true;
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		} catch (Exception e) {
			result = false;
			return result;
		}
		return result;
	}

	/**
	 * 规范路径中的斜杠将所有\\的替换成/
	 * 
	 * @return
	 */
	public static String repSlash(String str) {

		return str.replace("\\", "/");
	}

}
