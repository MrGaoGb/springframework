package com.series.demo.test;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 15:42
 * @description:
 */
public class TestObject {
    public static void main(String[] args) {
        final Object saveLocker = new Object();
        final Object updateLocker = new Object();
        System.out.println("saveLocker:" + saveLocker);
        System.out.println("updateLocker:" + updateLocker);
        String helloStr = "HeLLOStr";
        final String decapitalize = Introspector.decapitalize(helloStr);
        System.out.println(decapitalize);
        ///
        // testHashMapClear();

        Objenesis objenesis = new ObjenesisStd();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        System.out.println(current.nextInt(0, 100));
    }


    public static void testHashMapClear() {
        Map<String, Object> params = new HashMap<>(4);
        for (int i = 0; i < 10; i++) {
            params.clear();
            params.put("A", "A" + i);
            params.put("B", "B" + i);
            params.put("AC", "C" + i);
            params.clear();
        }
        System.out.println(params);
    }
}
