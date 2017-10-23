package com.ntc.gaia.base.utils.constants;

/**
 * 平台业务核心常量
 *
 * @author David
 * @date 2017-07-25
 */
public interface BootConstants {

    // 成功
    int SUCCESS = 1;

    // 失败
    int FAILURE = -1;

    // 成功
    String SUCCESS_STR = "1";

    // 失败
    String FAILURE_STR = "-1";

    // 系统异常
    int ENIP_EX = -2;

    // 无效
    int INVALID = -3;

    // 验证码错误
    int CODE_ERROR = -4;

    // 分页无数据参数(-1)
    int PG_INVALID_VALUE = -1;

    // 超级管理默认账号等级名称
    String SUPER_ADMIN_LEVEL_STR = "超级管理员";

    // 公共默认用户
    String DEFAULT_USER = "itadmin";

    // 公共默认客户
    String DEFAULT_UC = "UC";

    // 登陆Session会话键
    String LOGIN_SESSION_KEY = "LOGINUSER";

    // AJAX请求Session超时返回结果码600
    int AJAX_TIMEOUT = 600;

    // 替换密码
    String SIX_STAR = "******";

    int NO = 0;// 否

    int YES = 1;// 是

    // 字符NO
    String RS_NO = "NO";

    // 字符YES
    String RS_YES = "YES";

    // 业务会话参数
    String US_SN = "SN";

    // 会话用户等级参数
    String US_LV = "LV";

    // 文件系统上下文
    String US_FILECONTEXT = "FILECONTEXT";

    // 默认UI配置编号
    int DEFAULT_UI_CFG = 0;

    // 默认UI配置编号
    String UI_CFG = "UICFG";

    // http前缀
    String HTTP_PREFIX = "http://";

    // 超级管理默认账号ID
    int SUPER_ADMIN_ID = 1;

    // 超级管理默认账号等级
    int SUPER_ADMIN_LEVEL = 1;

    // 默认的菜单展示索引
    int DEFAULT_MENU_INDEX = 1002;

    // 默认操作成功消息
    String DefAULT_MESSAGE = "Successful operation.";

    // 终端默认最大有效期3年
    int MAX_ET_YEAR = 3;

    // 标识状态类型
    interface STATUS {

        int All = 0;// 全部
        int Effective = 1;// 有效
        int Invalid = 2;// 无效

        String All_Str = "0"; // 全部(字符)
        String Valid_Str = "1"; // 有效值(字符)
        String Invalid_Str = "2"; // 无效值(字符)

    }

    // 日志类型
    interface LOG_TYPE {

        int info = 0;// 信息

        int error = 1;// 异常
    }

    // 操作类型
    interface OPT_STATUS {

        int Forbidden = 0;// 禁用

        int Add = 1;// 新增

        int Update = 2;// 修改

        int Edit = 3;// 编辑操作

        int Save = 4;// 保存操作

        int Imports = 5;// 导入操作

        int Exports = 6;// 导出操作

        int Audit = 7;// 审核

    }

    // 系统登录人类型
    interface Login_User_Type {

        int System = 1;// 系统管理人员

        int User = 2;// 普通用户
    }
}
