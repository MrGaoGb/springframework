package com.series.demo.test;

import com.series.demo.entity.CompositeObj;
import com.series.demo.entity.UserModel;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;

import java.util.Arrays;

/**
 * @author: Mr.Gao
 * @date: 2022年06月20日 18:04
 * @description:
 */
public class TestBeanDefinitionBuilder {
    public static void main(String[] args) {
        //testInjectProperty()
        testInjectMutiProperty();
    }

    /**
     * 注入属性
     */
    public static void testInjectProperty() {
        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName());
        //--设置普通属性值
        beanDefinitionBuilder.addPropertyValue("name", "Mr.Gao");
        beanDefinitionBuilder.addPropertyValue("age", 26);

        // 获取BeanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        //创建Spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userModel", beanDefinition);
        UserModel userModel = beanFactory.getBean(UserModel.class);
        System.out.println("i=1," + userModel);
        System.out.println("i=2," + userModel);
        // userModel1 == userModel2 true
    }

    /**
     * 注入多个属性
     * RuntimeBeanReference：用来表示bean引用类型，类似于xml中的ref
     * ManagedList：属性如果是List类型的
     * ManagedMap：属性如果是Map类型的
     * ManagedSet：属性如果是Set类型的
     */
    public static void testInjectMutiProperty() {
        BeanDefinition userModel = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "Mr.Gao")
                .addPropertyValue("age", 28).getBeanDefinition();
        //--设置普通属性值
        BeanDefinition userModel2 = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "Ms.Yanni")
                .addPropertyValue("age", 25).getBeanDefinition();

        //定义stringList对应的值
        ManagedList<String> stringList = new ManagedList<>();
        stringList.addAll(Arrays.asList("王者荣耀", "英雄联盟", "求生之路", "穿越火线"));

        // 内部引用其他两个bean userModel和userModel2
        ManagedList<RuntimeBeanReference> carList = new ManagedList<>();
        carList.add(new RuntimeBeanReference("userModel"));
        carList.add(new RuntimeBeanReference("userModel2"));

        ManagedSet<String> stringSet = new ManagedSet<>();
        stringSet.addAll(Arrays.asList("联想", "苹果", "华硕"));

        ManagedSet<RuntimeBeanReference> carSet = new ManagedSet<>();
        carList.add(new RuntimeBeanReference("userModel"));

        ManagedMap<String, String> stringMap = new ManagedMap<>();
        stringMap.put("系列1", "java高并发系列");
        stringMap.put("系列2", "Maven高手系列");
        stringMap.put("系列3", "mysql系列");

        ManagedMap<String, RuntimeBeanReference> stringCarMap = new ManagedMap<>();
        stringCarMap.put("userModel", new RuntimeBeanReference("userModel"));
        stringCarMap.put("userModel2", new RuntimeBeanReference("userModel2"));

        GenericBeanDefinition compositeObj = new GenericBeanDefinition();
        compositeObj.setBeanClassName(CompositeObj.class.getName());
        compositeObj.getPropertyValues().add("name", "Mr.G").addPropertyValue("salary", 550000);
        compositeObj.getPropertyValues().addPropertyValue("userModel", userModel);
        compositeObj.getPropertyValues().addPropertyValue("stringList", stringList);
        compositeObj.getPropertyValues().addPropertyValue("carList", carList);
        compositeObj.getPropertyValues().addPropertyValue("stringSet", stringSet);
        compositeObj.getPropertyValues().addPropertyValue("carSet", carSet);
        compositeObj.getPropertyValues().addPropertyValue("stringMap", stringMap);
        compositeObj.getPropertyValues().addPropertyValue("stringCarMap", stringCarMap);

        //获取Spring容器
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userModel", userModel);
        beanFactory.registerBeanDefinition("userModel2", userModel2);
        beanFactory.registerBeanDefinition("compositeObj", compositeObj);

        // 从容器中获取所有Bean
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(beanName -> {
            System.out.println(String.format("beanName: %s, bean: %s", beanName, beanFactory.getBean(beanName)));
        });
    }
}
