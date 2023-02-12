package com.series.demo.service;

import org.springframework.context.annotation.Import;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置类：使用@Import标注,导入手动注入的BeanDefinition依赖关系
 */
@Import(value = MyImportBeanDefinitionRegistrar.class)
public class MainConfig2 {

}
