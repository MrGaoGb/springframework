package com.ecology.springboot.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * @author Mr.Gao
 * @date 2023/2/16 14:40
 * @apiNote:
 */
@Ann2(value = "通过Ann2给Ann1赋值",ann1Value = "火锅鸡")
public class AliasForAnnotationTest {

    public static void main(String[] args) {
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(AliasForAnnotationTest.class, Ann2.class));
        System.out.println("-------------------");
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(AliasForAnnotationTest.class, Ann1.class));
    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann1 { //@1
    String ann1Value() default "";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Ann1
@interface Ann2 { //@2

    String value() default "";

    @AliasFor(annotation = Ann1.class)
    String ann1Value() default "";
}
