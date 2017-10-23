package com.ntc.gaia.web.base.constants;

public interface ENIPConstants {

    // 成功
    int SUCCESS = 1;

    // 失败
    int FAILURE = -1;

    // 成功
    String SUCCESS_STR = "0";

    // 失败
    String FAILURE_STR = "-1";

    // 系统异常
    int ENIP_EX = -2;

    // 无效
    int INVALID = -3;

    // 验证码错误
    int CODE_ERROR = -4;

    String DEFAULT_USER = "admin";
    int SUPER_ADMIN_LEVEL = 0;
    String LOGIN_SESSION_KEY = "LOGIN_SESSION_KEY";
    String US_SN = "UC_SN";
    String US_FILECONTEXT = "US_FILECONTEXT";
    int AJAX_TIMEOUT = 600;

    interface Login_User_Type {

        int System = 0;
        int API = 1;
    }

    interface STATUS {

        int All = 0;
        int Invalid = -1;
        int valid = 1;
    }

}
