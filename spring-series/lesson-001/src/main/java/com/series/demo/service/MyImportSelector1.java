package com.series.demo.service;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 18:47
 * @description:
 */
public class MyImportSelector1 implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MainConfig6.class.getName()};
    }
}
