package com.ecology.utils.juc.pool;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Gao
 * @date 2022/12/15 11:48
 * @apiNote:
 */
@Data
@Service
public class Cat {
    private String catName;

    public Cat setCatName(String name) {
        this.catName = name;
        return this;
    }
}
