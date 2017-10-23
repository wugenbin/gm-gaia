package com.ntc.gaia.web.base.vo;

/**
 * 消息结果定义
 * @author David
 * @date 2017-08-11
 */
public class MessageModel {

    private int msgInt = -1; // 执行结果标识符
    private String msgStr = ""; // 执行消息结果内容
    private String msgUrl = "";//重定向URL

    public int getMsgInt() {
        return msgInt;
    }

    public void setMsgInt(int msgInt) {
        this.msgInt = msgInt;
    }

    public String getMsgStr() {
        return msgStr;
    }

    public void setMsgStr(String msgStr) {
        this.msgStr = msgStr;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public MessageModel() {

    }

    public MessageModel(int msgInt) {

        this.msgInt = msgInt;
    }

    public MessageModel(int msgInt, String msgStr) {

        this.msgInt = msgInt;
        this.msgStr = msgStr;
    }

    public MessageModel(int msgInt, String msgStr, String msgUrl) {

        this.msgInt = msgInt;
        this.msgStr = msgStr;
        this.msgUrl = msgUrl;
    }
}
