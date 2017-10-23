package com.ntc.gaia.base.model.base;

/**
 * Created by guominchuxing on 2017/8/22.
 */
public class ResultVo {

    // 返回的结果 success 或者 fail
    private String result = "";

    // 返回的中文消息
    private String msg = "";

    // 成功时携带的数据
    private Object data;

    public String getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    // 添加错误信息
    public ResultVo addError(String msg) {
        this.msg = msg;
        this.result = "fail";
        return this;
    }

    /**
     * 封装成功时的数据
     * @param data
     * @return ResultVo
     */
    public ResultVo success(Object data) {
        this.data = data;
        this.result="success";
        return this;
    }

}
