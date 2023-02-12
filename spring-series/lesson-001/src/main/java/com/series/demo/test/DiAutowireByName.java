package com.series.demo.test;


/**
 * @author: Mr.Gao
 * @date: 2022年05月23日 23:57
 * @description:
 */
public class DiAutowireByName {

    public static class ServiceA {

        private String desc;


        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Service{");
            sb.append("desc='").append(desc).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ServiceB {

        private String desc;


        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Service{");
            sb.append("desc='").append(desc).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    private ServiceA serviceA;
    private ServiceB serviceB;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        System.out.println("setServiceA->" + serviceA);
        this.serviceA = serviceA;
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        System.out.println("setServiceB->" + serviceB);
        this.serviceB = serviceB;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DiAutowireByName{");
        sb.append("serviceA=").append(serviceA);
        sb.append(", serviceB=").append(serviceB);
        sb.append('}');
        return sb.toString();
    }
}
