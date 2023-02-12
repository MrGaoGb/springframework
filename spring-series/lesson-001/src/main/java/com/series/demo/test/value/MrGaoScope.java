package com.series.demo.test.value;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.lang.annotation.*;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 11:01
 * @description:自定义Scope
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Scope(BeanMyScope.MY_SCOPE)
public @interface MrGaoScope {
    /**
     * 设置代理模式为目标类
     *
     * @return
     */
    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;
}
