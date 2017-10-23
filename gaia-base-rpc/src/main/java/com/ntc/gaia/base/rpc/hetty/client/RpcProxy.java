package com.ntc.gaia.base.rpc.hetty.client;

import com.caucho.hessian.client.HessianProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置 RPC 客户端代理
 *
 * @author david
 * @date 2017-07-20
 */
public class RpcProxy extends HessianProxyFactory {

    @SuppressWarnings("hiding")
    private static final Logger log = LoggerFactory.getLogger(RpcProxy.class);

    private String host;

    private int port;

    @SuppressWarnings("unused")
    private String user;

    @SuppressWarnings("unused")
    private String password;

    public RpcProxy(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;

        super.setUser(user);
        super.setPassword(password);
    }

    public <T> T create(Class<?> interfaceClass) {

        // 构建请求URL
        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("http://").append(host).append(":").append(port).append("/apis/")
                .append(interfaceClass.getSimpleName()).append("/");

        try {
            super.setReadTimeout(120000);
            super.setOverloadEnabled(true);
            return (T) super.create(interfaceClass, sbUrl.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public <T> T create(Class<?> interfaceClass, boolean isSSL) {

        // 构建请求URL
        StringBuffer sbUrl = new StringBuffer();
        if (!isSSL) {
            sbUrl.append("http://");
        } else {
            sbUrl.append("https://");
        }
        sbUrl.append(host).append(":").append(port).append("/apis/").append(interfaceClass.getSimpleName()).append("/");

        try {
            super.setReadTimeout(120000);
            super.setOverloadEnabled(true);
            return (T) super.create(interfaceClass, sbUrl.toString());
        } catch (Exception e) {

            log.error(e.getMessage());
        }
        return null;
    }

}
