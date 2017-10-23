package com.ntc.gaia.web.base.vo;

import java.util.HashMap;
import java.util.Map;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.utils.tools.StringUtil;

/**
 * 用户统计业务,及Session业务
 *
 * @author David
 * @time 2017-08-10
 */
public class SessionLogic {


    // 全局登录用户缓存池
    private Map<String, User> mapUtil = new HashMap<String, User>(1);

    private static SessionLogic logic = null;

    private SessionLogic() {

    }

    public static synchronized SessionLogic getInstance() {

        if (logic == null) {

            logic = new SessionLogic();
        }
        return logic;
    }

    public void addUserAttr(User user) {

        mapUtil.put(String.valueOf(user.getId()), user);
    }

    /**
     * 清除在线用户
     *
     * @param userId
     */
    public void removeUserAttr(String userId) {
        mapUtil.remove(userId);
    }

    /**
     * 统计数量
     *
     * @return
     */
    public int getUserCount() {
        return mapUtil.size();
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    public Map<String, User> getUserMaps() {
        return mapUtil;
    }

    /**
     * 返回User对象
     *
     * @param userId
     * @return
     */
    public Object getLoginUC(String userId) {

        User user = null;
        for (Map.Entry<String, User> entry : mapUtil.entrySet()) {

            if (entry.getValue().getId().equals(userId)) {
                user = entry.getValue();
                break;
            }
        }
        return user;
    }

    /**
     * 是否存在登录的用户
     *
     * @param userId 客户ID
     * @return
     */
    public User isExistUC(String userId) {

        User user = null;
        if (mapUtil != null && userId != null) {

            for (Map.Entry<String, User> entry : mapUtil.entrySet()) {

                if (String.valueOf(entry.getValue().getId()).equals(userId)) {
                    user = entry.getValue();
                    break;
                }
            }
        }

        return user;
    }

    /**
     * 是否存在登录的用户
     *
     * @param userId 客户ID
     * @return
     */
    public void removeExistUC(String userId) {

        String UID = null;
        User user = null;
        if (mapUtil != null && userId != null) {

            for (Map.Entry<String, User> entry : mapUtil.entrySet()) {

                if (String.valueOf(entry.getValue().getId()).equals(userId)) {
                    user = entry.getValue();
                    UID = String.valueOf(user.getId());
                    break;
                }
            }
        }

        // 移除操作
        if (UID != null) {
            removeUserAttr(UID);
        }

    }

    /**
     * 重置 登陆用户信息
     *
     * @param user 登陆用户信息
     * @return
     */
    public void resetOldUC(User user) {

        if (user != null && StringUtil.notEmpty(String.valueOf(user.getId()))) {
            mapUtil.put(String.valueOf(user.getId()), user);
        }
    }
}
