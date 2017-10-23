package com.ntc.gaia.base.utils.constants;

/**
 * HTTP请求常量
 * 
 * @author David
 * @time 2017-07-25
 * 
 */
public interface HTTPContants {

	// WS 根节点
	String WS_ROOT = "/services";

	// HTTP 'output' 参数
	String PM_OUTPUT = "output";

	// xml格式
	String XML_FORMAT = "xml";

	// json格式
	String JSON_FORMAT = "json";

	// jsonp格式
	String JOSNP_FORMAT = "jsonp";

	// 成功
	String WS_SUCCESS = "100000";

	// 失败
	String WS_FAILED = "100001";

	// WS成功默认消息
	String WS_SUCCESS_MESSAGE = "Successful operation";

	// WS失败默认消息
	String WS_FAILED_MESSAGE = "Failed operation";

}
