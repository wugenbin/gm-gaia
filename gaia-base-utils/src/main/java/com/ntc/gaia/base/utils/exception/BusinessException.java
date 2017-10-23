/**
 * 
 */
package com.ntc.gaia.base.utils.exception;

/**
 * 系统业务类型
 * 
 * @author david
 * @time 2017-08-08
 * 
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	// 错误码
	private int errorCode;

	// 错误消息内容
	private String errorMessage;

	public BusinessException() {
		super();
	}

	public BusinessException(int errorCode, String message) {

		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
