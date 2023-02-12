package com.series.demo.service;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 18:44
 * @description: DeferredImportSelector是ImportSelector的子类，会被延时处理掉.
 * <p>
 * DeferredImportSelector存在多个时候，可以通过注解方式@Order来指定执行顺序或者实现Ordered接口
 * </p>
 */
public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MainConfig8.class.getName()};
    }
}
