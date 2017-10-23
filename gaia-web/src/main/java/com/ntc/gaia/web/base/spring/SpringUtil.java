package com.ntc.gaia.web.base.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * 普通类获取Spring IOC对象帮助类
 *
 * @author David
 * @date 2017-8-11
 */
@Repository("springUtil")
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringUtil.context = context;

    }

    public static Object getBean(String name) {
        return context.getBean(name);

    }

    public static Object getBean(String name, Class<?> cls) {
        return context.getBean(name, cls);
    }
}
