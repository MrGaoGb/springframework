package com.series.demo.service.autowired;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Mr.Gao
 * @date: 2022年06月17日 13:50
 * @description:
 */
public class InjectService {

    private Map<String, IService> map;

    public void setMap(Map<String, IService> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InjectService{");
        sb.append("map=").append(map);
        sb.append('}');
        return sb.toString();
    }
}
