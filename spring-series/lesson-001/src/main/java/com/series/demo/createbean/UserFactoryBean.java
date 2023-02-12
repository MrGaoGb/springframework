package com.series.demo.createbean;

import com.series.demo.entity.UserModel;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: Mr.Gao
 * @date: 2022年05月22日 10:39
 * @description:
 */
public class UserFactoryBean implements FactoryBean<UserModel> {

    int count = 1;

    @Override
    public UserModel getObject() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setName("FactoryBean创建的第" + count++ + "对象!");
        return userModel;
    }

    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }

    /**
     * --false--多例
     * userFactoryBean:com.series.demo.entity.UserModel@49139829
     * userFactoryBean:com.series.demo.entity.UserModel@9597028
     * --true--单例
     * userFactoryBean:com.series.demo.entity.UserModel@223191a6
     * userFactoryBean:com.series.demo.entity.UserModel@223191a6
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
