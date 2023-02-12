package com.series.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置类：使用@Import标注
 */
@Import(MyImportSelector.class)
public class MainConfig5 {

}
