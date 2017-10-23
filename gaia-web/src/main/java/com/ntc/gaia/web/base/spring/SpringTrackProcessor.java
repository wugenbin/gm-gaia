package com.ntc.gaia.web.base.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * Spring 对象创建器业务方法
 *
 * @author David
 * @date 2017-07-25
 */
@Service("spingTrackProcessor")
public class SpringTrackProcessor implements BeanPostProcessor {

    /**
     * 对象创建后处理
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        if (bean instanceof SpringOnLoadBussion) {

            // 调用方法加载数据
            ((SpringOnLoadBussion) bean).initLoad();
        }

        return bean;
    }

    /**
     * 对象创建前处理
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        return bean;
    }

}
