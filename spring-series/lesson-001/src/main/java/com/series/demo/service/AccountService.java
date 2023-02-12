package com.series.demo.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author: Mr.Gao
 * @date: 2022年06月21日 10:42
 * @description:
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
@Lazy
public class AccountService {
}
