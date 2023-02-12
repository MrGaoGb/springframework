package com.series.demo.pooltest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Mr.Gao
 * @date: 2022年07月20日 16:18
 * @description:
 */
public class HashMapTest {

    private static Unsafe unsafe;

    static {
        try {
            //通过反射获取rt.jar下的Unsafe类
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println("Get Unsafe instance occur error"+ e);
        }
    }

    /**
     * 测试并发条件下导致CPU达到100%
     */
    static final HashMap<String, String> map = new HashMap<>(2);

    public static void main(String[] args) throws Exception {
//        Thread t = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                int finalI1 = i;
//                new Thread(() -> map.put(String.valueOf(finalI1), ""), "ftf" + i).start();
//            }
//        }, "MainThread");
//        t.start();
//        t.join();


        //readHashMap();
        readConcurrentHashMap();
    }

    public static void readHashMap() {
        HashMap<String, Object> params = new HashMap<>(10, 1.2f);
        params.put("Java", "JDK源码解析");
        params.put("Java2", "JDK源码解析2");
        params.put("Java3", "JDK源码解析3");
        params.put("Java4", "JDK源码解析4");
        System.out.println(params);

        int[] nums = new int[10];
        System.out.println(nums.length);
    }

    public static void readConcurrentHashMap() throws NoSuchFieldException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("ConJava", "JDK1.8源码解析");
        map.put("java", "JDK1.8_1源码解析");
        //Unsafe unsafe = Unsafe.getUnsafe();
    }
}
