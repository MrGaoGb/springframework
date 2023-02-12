package com.series.demo.createbean;

/**
 * @author: Mr.Gao
 * @date: 2022年05月22日 11:04
 * @description:
 */
public class BeanScopeModel {

    public BeanScopeModel(String beanScope) {
        System.out.println(String.format("Create BeanScopeModel,{scope:%s},{this:%s}", beanScope, this));
    }
}
