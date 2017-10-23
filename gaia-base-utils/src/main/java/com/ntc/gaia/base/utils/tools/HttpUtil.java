package com.ntc.gaia.base.utils.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * 发送数据
 * 
 * @author Allen
 * @date 2014-8-15
 * 
 */
public class HttpUtil {

	/**
	 * 发送数据
	 * 
	 * @param paths
	 *            http地址
	 * @param datas
	 * @return
	 */
	public static String send(String paths, String datas) {

		String requestString = datas;
		String result = null;
		HttpURLConnection httpURLConnection;
		try {
			// 建立链接
			URL gatewayUrl = new URL(paths);
			httpURLConnection = (HttpURLConnection) gatewayUrl.openConnection();

			// 设置连接属性
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setUseCaches(false);

			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
			byte[] requestStringBytes = requestString.getBytes("UTF-8");

			// 设置请求属性
			httpURLConnection.setRequestProperty("Content-length", "" + requestStringBytes.length);
			httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");

			// 建立输出流，并写入数据
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(requestStringBytes);
			outputStream.close();

			// 获得响应状态
			int responseCode = httpURLConnection.getResponseCode();

			if (HttpURLConnection.HTTP_OK == responseCode) {

				// 当正确响应时处理数据
				StringBuffer responseBuffer = new StringBuffer();

				String readLine;
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					responseBuffer.append(readLine).append("\n");
				}

				responseReader.close();

				System.out.println("Http Response:" + responseBuffer);
				if (responseBuffer.length() > 0) {
					result = responseBuffer.toString().trim();
				}
			}
		} catch (IOException e) {
			e.fillInStackTrace();
		}

		return result;
	}

	public static String send(String paths, HashMap<String, String> paramMap) {

		String data = paramMap.toString();
		return send(paths,data);

	}


}
