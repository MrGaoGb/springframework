package com.series.demo.service.autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: Mr.Gao
 * @date: 2022年05月31日 11:38
 * @description:
 */
@Component
public class Service0 implements IService {

    public Service0() {
        System.out.println("service0 was created!");
    }
}
