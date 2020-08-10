package com.imut.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 9:49
 */
public class MyFactorBean implements FactoryBean<Color> {
    //返回一个对象，这个对象就会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }


    //返回对象类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单例
    //true 表示单实例   false 表示多实例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
