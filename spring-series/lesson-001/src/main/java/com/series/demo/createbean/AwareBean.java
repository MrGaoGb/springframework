package com.series.demo.createbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 9:57
 * @description:
 */
public class AwareBean implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory:" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:" + name);
    }
}
