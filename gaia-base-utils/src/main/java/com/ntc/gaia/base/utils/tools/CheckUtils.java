package com.ntc.gaia.base.utils.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 利用Java正则表达式校验助手类
 *
 * @author David
 * @date 2017-07-12
 */
public class CheckUtils {


    /**
     * 验证手机号码
     *
     * @param mobiles
     * @return [0-9]{5,9}
     */
    public static boolean isMobileNO(String mobiles) {

        boolean flag = false;
        try {


            boolean b = false;
            Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
            Matcher m = p.matcher(mobiles);
            return  m.matches();

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱地址是否正确
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {

        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }



    /**
     * 判断 是否为数字
     *
     * @param number
     * @return
     */
    public static boolean isNum(String number) {

        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[0-9]{5}$");
            Matcher m = p.matcher(number);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {

        String s = "18124565453";
        System.out.print("s=" + isMobileNO(s));

    }
}