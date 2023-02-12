package com.series.demo.service;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 18:07
 * @description:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MainConfig3.class.getName(), ImportService2.class.getName(),
                ImportService1.class.getName()};
    }
}
