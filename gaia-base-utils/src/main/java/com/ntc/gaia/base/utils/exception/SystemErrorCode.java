package com.ntc.gaia.base.utils.exception;

/**
 * 系统错误码定义类
 * 
 * @author david
 * @time 2017-08-10
 * 
 */
public interface SystemErrorCode extends BaseErrorCode {

	// 业务错误码开始值
	int InitSystemErrorCode = InitErrorCode + 100000;

	int InitEmailErrorCode = InitErrorCode + 200000;

	interface DBCode {

		/** 连接数据库异常 (1100001)* */
		int COON_DATA_ERROR = InitSystemErrorCode + 1;

		/** 连接数据库异常 (1100002)* */
		int EXEC_DATA_ERROR = InitSystemErrorCode + 2;

	}

	interface EmailCode {

		/** 连接数据库异常 (1100001)* */
		int Send_Email_ERROR = InitEmailErrorCode + 1;

	}
}
