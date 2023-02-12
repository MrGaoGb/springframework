package com.series.demo.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Mr.Gao
 * @date: 2022年06月20日 19:24
 * @description:
 */
@Data
public class CompositeObj {
    private String name;
    private Integer salary;
    private UserModel userModel;
    private List<String> stringList;
    private List<UserModel> carList;
    private Set<String> stringSet;
    private Set<UserModel> carSet;
    private Map<String, String> stringMap;
    private Map<String, UserModel> stringCarMap;


}
