package com.series.demo.test;

import com.series.demo.entity.UserModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: Mr.Gao
 * @date: 2022年06月21日 14:52
 * @description:
 */
public class TestBeanDefinitionMerge {

    public static void main(String[] args) {
        //merge();
        // 实例对象前
        //instanceObjBefore();
        // 实例对象后
        instanceObjAfter();
    }

    /**
     * bean合并
     */
    public static void merge() {
        // 创建Spring容器
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //定义一个XML的BeanDefinition读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionCount = reader.loadBeanDefinitions("classpath:reader-merge-beans.xml");
        System.out.println("找到:" + beanDefinitionCount + " 个Bean对象!");
        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            BeanDefinition mergedBeanDefinition = beanFactory.getMergedBeanDefinition(beanName);
            System.out.println(String.format("beanName:%s --> bdf:%s --> %s", beanName, beanDefinition, beanDefinition.getPropertyValues()));
            System.out.println(String.format("beanName:%s --> mergeBdf:%s --> %s", beanName, mergedBeanDefinition, mergedBeanDefinition.getPropertyValues()));
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * 实例化对象前
     */
    public static void instanceObjBefore() {
        // 创建Spring容器
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("postProcessBeforeInstantiation 被执行了!");
                if (beanClass.isAssignableFrom(UserModel.class)) {
                    UserModel userModel = new UserModel();
                    userModel.setName("beanProcessBeforeInstant");
                    userModel.setAge(2);
                    return userModel;
                }
                return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
            }
        });

        // Bean定义
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "乐视TV")
                .addPropertyValue("age", 99).getBeanDefinition();
        beanFactory.registerBeanDefinition("userModel", beanDefinition);

        //从实例中获取bean的实例
        System.out.println(beanFactory.getBean("userModel"));
    }


    /**
     * 实例化对象后
     */
    public static void instanceObjAfter() {
        // 创建Spring容器
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
//            @Override
//            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//                System.out.println("postProcessBeforeInstantiation 被执行了!");
//                if (beanClass.isAssignableFrom(UserModel.class)) {
//                    UserModel userModel = new UserModel();
//                    userModel.setName("beanProcessBeforeInstant");
//                    userModel.setAge(2);
//                    return userModel;
//                }
//                return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//            }
//        });
        beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if ("userModel".equals(beanName)) {
                    //userModel的属性赋值被跳过了。
                    return false;
                }
                return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
            }
        });
        //beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
        //    @Override
        //    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        //        if ("userModel3".equals(beanName)) {
        //            if (pvs.isEmpty()) {
        //                pvs = new MutablePropertyValues();
        //            } else {
        //                return pvs;
        //            }
        //            if (pvs instanceof MutablePropertyValues) {
        //                MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
        //                mpvs.add("name", "第三方路人甲");
        //                mpvs.add("age", 99);
        //                return mpvs;
        //            }
        //        }
        //        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
        //    }
        //});
        // Bean定义
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "乐视TV")
                .addPropertyValue("age", 99).getBeanDefinition();
        beanFactory.registerBeanDefinition("userModel", beanDefinition);
        // Bean定义
        BeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "爱奇艺TV")
                .addPropertyValue("age", 98).getBeanDefinition();
        beanFactory.registerBeanDefinition("userModel2", beanDefinition2);

        // TODO Bean定义(没有对其属性赋值)
        BeanDefinition beanDefinition3 = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class.getName())
                .addPropertyValue("name", "属性赋值")
                .addPropertyValue("age", 8843)
                .getBeanDefinition();
        beanFactory.registerBeanDefinition("userModel3", beanDefinition3);

        //从实例中获取bean的实例
        System.out.println(beanFactory.getBean("userModel"));
        System.out.println(beanFactory.getBean("userModel2"));
        System.out.println(beanFactory.getBean("userModel3"));
    }
}
