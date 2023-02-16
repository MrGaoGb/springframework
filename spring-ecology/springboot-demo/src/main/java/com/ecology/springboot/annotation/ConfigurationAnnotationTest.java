package com.ecology.springboot.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Mr.Gao
 * @date 2023/2/16 15:28
 * @apiNote:测试验证@Configuration加或者不加的区别
 * <p>
 *     在@configuration注解存在的情况下，会被Spring的IOC容器管理，生成的是代理对象并且单例Bean
 *     相反，生成的class对象，而且对象A会被创建多次，也不是代理对象。
 * </p>
 */
public class ConfigurationAnnotationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(beanName -> {
            System.out.println(String.format("bean名称:%s ,bean对象:%s", beanName, applicationContext.getBean(beanName)));
        });
    }


}

//@Configuration
class MainConfig {

    //@Bean
    //public A a() {
    //    System.out.println("调用对象a!");
    //    return new A();
    //}
    //
    //@Bean
    //public B b() {
    //    System.out.println("调用对象b!");
    //    A a = this.a();
    //    return new B(a);
    //}
    //
    //@Bean
    //public B b2() {
    //    System.out.println("调用对象b2!");
    //    A a = this.a();
    //    return new B(a);
    //}

}

class A {

    public A() {
        System.out.println("A........! created");
    }
}

class B {
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
