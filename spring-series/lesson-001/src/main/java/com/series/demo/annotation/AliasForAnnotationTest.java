package com.series.demo.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 15:17
 * @description:
 */
public class AliasForAnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Alias1 {
        String valueParam() default "alias1";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Alias1
    @interface Alias2 {
        String value() default "alias2";

        @AliasFor(annotation = Alias1.class, value = "valueParam")
        String alias2ValueToAlias1Value() default "";
    }

    @Alias2(value = "所依赖类注释不让修改", alias2ValueToAlias1Value = "@Alias2对@Alias1注解上value属性的更改!")
    static class AliasForRunTarget {

    }

    public static void main(String[] args) {
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(AliasForRunTarget.class, Alias2.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(AliasForRunTarget.class, Alias1.class));
    }
}
