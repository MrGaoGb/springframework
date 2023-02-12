package com.series.demo.test;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author: Mr.Gao
 * @date: 2022年05月24日 17:10
 * @description:
 */
public class StrongDependenceBean {

    public static class BeanOne implements DisposableBean {

        public BeanOne() {
            System.out.println(this.getClass() + " contructor()!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class BeanTwo implements DisposableBean {
        private BeanOne beanOne;

        public BeanTwo(BeanOne beanOne) {
            this.beanOne = beanOne;
            System.out.println(this.getClass() + " contructor()!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class BeanThree implements DisposableBean {

        private BeanTwo beanTwo;

        public BeanThree(BeanTwo beanTwo) {
            this.beanTwo = beanTwo;
            System.out.println(this.getClass() + " contructor()!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }
}
