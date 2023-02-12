package com.series.demo.juc;

import lombok.val;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.Gao
 * @date 2022/12/30 15:27
 * @apiNote:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {

        //
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put("A", "B");

        ConcurrentHashMap<String, Object> conMap = new ConcurrentHashMap<>(256);
        conMap.put("KEY", "ARRAY_KEY");
    }
}
