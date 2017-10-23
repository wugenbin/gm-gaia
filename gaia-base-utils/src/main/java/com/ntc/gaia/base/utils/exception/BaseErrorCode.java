package com.ntc.gaia.base.utils.exception;

import com.ntc.gaia.base.utils.constants.BootConstants;

/**
 * 错误码基本定义类
 * 
 * @author david
 * @time 2017-08-10
 * 
 */
public interface BaseErrorCode {

	// 错误码开始值
	int InitErrorCode = 1000000;

	// 操作成功,通用
	int OPERATE_SUCCESS = BootConstants.SUCCESS;

	// 操作失败,通用
	int OPERATE_FAIED = BootConstants.FAILURE;

}
