package com.series.demo.service.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Gao
 * @date: 2022年06月16日 15:43
 * @description:
 */
@Service
public class Service2 {

    private Service1 service1;

    public Service2() {

        System.out.println("service2 was created!");
    }

    @Autowired
    public Service2(Service1 service1, @Autowired(required = false) String name) {
        this.service1 = service1;
    }

}
