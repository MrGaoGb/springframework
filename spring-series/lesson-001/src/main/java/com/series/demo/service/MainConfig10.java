package com.series.demo.service;

import com.series.demo.service.autowired.Service2;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置执行结果顺序: @Configuration > ImportSelector > DeferredImportSelector
 */
@ComponentScan(basePackageClasses = Service2.class)
public class MainConfig10 {
}
