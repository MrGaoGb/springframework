package com.series.demo.juc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Gao
 * @date 2022/12/26 16:14
 * @apiNote:
 */
public class HashMapTest {
    public static void main(String[] args) {

        // 创建一个map 容器
        Map<String, Object> map = new HashMap<>(4);
        map.put("A", 1);
        map.put("B", 2);

        for (String key : map.keySet()) {
            if (key.equals("A")) {
                map.remove("A");
            }
        }
    }
}
