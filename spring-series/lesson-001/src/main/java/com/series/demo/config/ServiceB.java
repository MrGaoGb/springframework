package com.series.demo.config;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 16:54
 * @description:
 */
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceB{");
        sb.append("serviceA=").append(serviceA);
        sb.append('}');
        return sb.toString();
    }
}
