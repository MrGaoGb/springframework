package com.series.demo.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 14:27
 * @description:
 */
public class InheritedAnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    @interface A1 {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    @interface A2 {
    }

    @A1
    interface I1 {
    }

    @A2
    static class C1 {
    }

    static class C2 extends C1 implements I1 {
    }


    /**
     * === @com.series.demo.annotation.InheritedAnnotationTest$A2()
     * 从输出中可以看出类可以继承父类上被@Inherited修饰的注解，而不能继承接口上被@Inherited修饰
     * 的注解，这个一定要注意
     *
     * @param args
     */
    public static void main(String[] args) {
        Arrays.stream(C2.class.getAnnotations())
                .forEach(System.out::println);
        final A1 mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(C2.class, A1.class);
        System.out.println(mergedAnnotation);
    }

}
