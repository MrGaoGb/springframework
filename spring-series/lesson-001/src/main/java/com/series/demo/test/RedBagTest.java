package com.series.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Mr.Gao
 * @date: 2022年07月14日 10:05
 * @description:
 */
public class RedBagTest {
    public static void main(String[] args) {

        //获取钱包比例-红包金额 按照比例值降序排列
        Map<Integer, String> scaleRateMap = new TreeMap<>();
        scaleRateMap.put(45, "0");
        scaleRateMap.put(30, "66.88");
        scaleRateMap.put(15, "99.88");
        scaleRateMap.put(8, "99.88");
        scaleRateMap.put(3, "139.88");
        Integer total = scaleRateMap.keySet().stream().reduce(0, Integer::sum);
        System.out.println(JSONObject.toJSONString(scaleRateMap));
        System.out.println(total);
        if (total != 100) {
            throw new IllegalArgumentException("比例值数据不满足100%");
        }
        //生成比例范围对应的amt 0~40 1.88 , 40~70 6.88 ,70~90 9.88 ,90~100 39.88
        //[0,39) [40,69) [70,89) [90,100)
        List<Triple<Integer, Integer, String>> list = new ArrayList<>();
        AtomicReference<Integer> tempCalNum = new AtomicReference<>(0);
        scaleRateMap.forEach((k, v) -> {
            list.add(new ImmutableTriple<>(tempCalNum.get(), tempCalNum.get() + k, v));
            tempCalNum.updateAndGet(v1 -> v1 + k);
        });
        System.out.println(list);

        // 模拟进行抽奖
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int autoNum = random.nextInt(0, 100);
        Triple<Integer, Integer, String> triple = list.stream().filter(it -> autoNum >= it.getLeft() && autoNum < it.getMiddle())
                .findFirst().get();
        System.out.println("========开始摇奖==========");
        System.out.println("中奖范围为：[" + triple.getLeft() + "," + triple.getMiddle() + ")");
        System.out.println("随机数为:" + autoNum);
        if (new BigDecimal(triple.getRight()).compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("抱歉,你尚未中奖!");
        } else {
            System.out.println("恭喜中奖,中奖金额:" + triple.getRight());
        }
    }
}
