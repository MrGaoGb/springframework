package com.series.demo.test.value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: Mr.Gao
 * @date: 2022年06月29日 16:53
 * @description:
 */
@ComponentScan
@PropertySource(value = {"classpath:db.properties"})
public class MainConfig {
}
