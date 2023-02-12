package com.series.demo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置类：使用@Import标注,导入两个普通类
 */
@Configuration
@Import(value = {ImportService1.class, ImportService2.class})
public class MainConfig {
}
