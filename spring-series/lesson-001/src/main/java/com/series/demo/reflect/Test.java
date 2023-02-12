package com.series.demo.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: Mr.Gao
 * @date: 2022年06月15日 20:48
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        Method[] methods = Child.class.getMethods();
        Method[] declaredMethods = Child.class.getDeclaredMethods();
        System.out.println(methods);
        System.out.println(declaredMethods);
        Arrays.stream(child.getClass().getDeclaredMethods()).filter(method -> method.getName().equals("setValue")).forEach(method -> {
            try {
                method.invoke(child, "test");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(child.toString());
    }
}
