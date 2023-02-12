package com.series.demo.pooltest;

/**
 * @author: Mr.Gao
 * @date: 2022年11月14日 16:32
 * @description:
 */
public class SingleModel {

    private static SingleModel instance;

    /**
     * 单例模式之双重检查机制创建对象
     *
     * @return
     */
    public static SingleModel getInstance() {
        if (instance != null) {
            synchronized (SingleModel.class) {
                if (instance != null) {
                    instance = new SingleModel();
                }
            }
        }
        return instance;
    }
}
