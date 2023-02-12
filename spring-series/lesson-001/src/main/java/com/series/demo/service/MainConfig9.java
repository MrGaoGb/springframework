package com.series.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置执行结果顺序: @Configuration > ImportSelector > DeferredImportSelector
 */
@Import(value = {
        MainConfig7.class,
        MyDeferredImportSelector.class,
        MyImportSelector1.class
})
public class MainConfig9 {

}
