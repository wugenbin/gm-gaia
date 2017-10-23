package com.ntc.gaia.base.utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志助手类
 *
 * @author allen.yuan
 * @date 2015-11-26
 *
 */
public class LogUtil {

	private static final Logger Log = LoggerFactory.getLogger(LogUtil.class);

	private static final int LOG_LEVEL = 6;
	private static final int VERBOSE = 5;
	private static final int DEBUG = 4;
	private static final int INFO = 3;
	private static final int WARN = 2;
	private static final int ERROR = 1;

	public static void debug(String msg) {

		if (LOG_LEVEL > DEBUG) {
			Log.debug(msg);
		}

	}

	public static void debug(String tag, Object msg) {

		if (LOG_LEVEL > DEBUG) {

			Log.debug(tag, msg);

		}

	}

	public static void info(String msg) {

		if (LOG_LEVEL > INFO) {

			Log.info(msg);

		}
	}

	public static void info(String tag, Object msg) {

		if (LOG_LEVEL > INFO) {

			Log.info(tag, msg);

		}

	}

	public static void warn(String msg) {

		if (LOG_LEVEL > WARN) {

			Log.warn(msg);

		}

	}

	public static void warn(String tag, Object msg) {

		if (LOG_LEVEL > WARN) {

			Log.warn(tag, msg);

		}

	}

	public static void error(String msg) {

		if (LOG_LEVEL > ERROR) {

			Log.error(msg);

		}

	}

	public static void error(String tag, Object msg) {

		if (LOG_LEVEL > ERROR) {

			Log.error(tag, msg);

		}

	}

}
